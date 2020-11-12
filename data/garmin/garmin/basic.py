"""
python fit_to_csv.py  "garmin04"
"""
import csv
import os
import sys
# to install fitparse, run 
# pip install fitparse
import fitparse
import datetime
import pytz

import pandas as pd

from garmin.tools import *

# person = sys.argv[1]

OUTPUT_TIMEZONE = pytz.timezone('America/Los_Angeles')
INPUT_TIMEZONE = pytz.timezone('UTC')

allowed_fields = ['timestamp_16', 'heart_rate', 'stress_level_time', 'stress_level_value']
required_fields = ['timestamp_16' ,'heart_rate', 'stress_level_time', 'stress_level_value']

class Garmin():
    def __init__(self, person, in_tz=INPUT_TIMEZONE, out_tz=OUTPUT_TIMEZONE):
        self.person = person
        self.in_tz = in_tz
        self.out_tz = out_tz

    def write_fitfile_to_csv(self, fitfile, output_file):
        messages = fitfile.messages
        if messages[0].fields[1].name != 'time_created':
            print('wrong input')
            sys.exit(1)
        else:
            timestamp = (messages[0].fields[1].value - datetime.datetime(1989, 12, 31, 0, 0)).total_seconds()
        data = []
        for m in messages:
            skip=True
            if not hasattr(m, 'fields'):
                continue
            fields = m.fields
            #check for important data types
            mdata = {}
            for field in fields:
                if field.name in allowed_fields:
                    if field.name=='timestamp_16':
                        # timestamp_16 = int(timestamp/2**16) * 2**16 + field.value
                        timestamp_16 = (int(timestamp) & 0xffff0000) | field.value
                        t_utc = datetime.datetime.utcfromtimestamp(631065600+timestamp_16)
                        mdata[field.name] = GarminTools().timezoneshift(t_utc, self.in_tz, self.out_tz)
                    elif field.name=='heart_rate':
                        mdata[field.name] = field.value
                    elif field.name == 'stress_level_time':
                        timestamp_00 = (field.value - datetime.datetime(1989, 12, 31, 0, 0)).total_seconds()
                        t_utc = datetime.datetime.utcfromtimestamp(631065600+timestamp_00)
                        mdata[field.name] = GarminTools().timezoneshift(t_utc, self.in_tz, self.out_tz)
                    elif field.name == 'stress_level_value':
                        mdata[field.name] = field.value
            for rf in required_fields:
                if rf in mdata:
                    skip=False
                    break
            if not skip:
                data.append(mdata)
        #write to csv
        with open(output_file, 'w') as f:
            writer = csv.writer(f)
            writer.writerow(allowed_fields)
            for entry in data:
                writer.writerow([ str(entry.get(k, '')) for k in allowed_fields])
        print('wrote %s' % output_file)

    def convert_one_day(self, fit_folder, inter_csv_folder):
        files = os.listdir(fit_folder)
        fit_files_name = [file for file in files if file[-4:].lower()=='.fit'] # ['69974411287.fit', ...]
        # output_folder_path = os.path.join(folder_path, 'csv')
        if not os.path.exists(inter_csv_folder):
            os.makedirs(inter_csv_folder)

        for file in fit_files_name:
            input_fit_file_path = os.path.join(fit_folder, file)
            output_csv_file_path = os.path.join(inter_csv_folder, file[:-4] + '.csv')
            # print(output_csv_file_path)

            fitfile = fitparse.FitFile(input_fit_file_path, data_processor=fitparse.StandardUnitsDataProcessor())
            print('converting %s' % input_fit_file_path)
            self.write_fitfile_to_csv(fitfile, output_csv_file_path)
        
        print('finished conversions')
    
    def covert_one_day_to_intermediate_csv(self, date):
        """
        date: string - "2020-10-13"
        """
        if not os.path.exists(os.path.join(self.person, 'intermediate_csv')):
            os.makedirs(os.path.join(self.person, 'intermediate_csv'))

        fit_folder = os.path.join(self.person, 'fit', date)
        inter_csv_folder = os.path.join(self.person, 'intermediate_csv', date)

        if not os.path.exists(fit_folder):
            print(fit_folder, "doesn't exist.")
            return None

        self.convert_one_day(fit_folder, inter_csv_folder)

    def convert_all_days_to_intermediate_csv(self):
        dates = os.listdir(os.path.join(self.person, 'fit'))
        print(dates)

        for oneday in dates:
            self.covert_one_day_to_intermediate_csv(oneday)

    def rearrange_one_day_csv(self, date):
        if not os.path.exists(os.path.join(self.person, 'csv')):
            os.makedirs(os.path.join(self.person, 'csv'))

        inter_csv_folder = os.path.join(self.person, 'intermediate_csv', date)
        final_csv_folder = os.path.join(self.person, 'csv')

        if not os.path.exists(inter_csv_folder):
            print(inter_csv_folder, "doesn't exist.")
            return None

        filenames = os.listdir(inter_csv_folder)
        files_path = [os.path.join(inter_csv_folder, filename) for filename in filenames if filename[-4:] == '.csv']
        # print(files_path)
        dfs_for_hr = [0] * len(files_path)
        dfs_for_stress = [0] * len(files_path)

        for i in range(len(files_path)):
            file_path = files_path[i]
            # print(file_path)
            df_hr_without_nan, df_stress_without_nan = GarminTools().separateData(file_path)
            dfs_for_hr[i] = df_hr_without_nan
            dfs_for_stress[i] = df_stress_without_nan
        
        df_day_hr = pd.concat(dfs_for_hr).reset_index(drop=True)
        df_day_stress = pd.concat(dfs_for_stress).reset_index(drop=True)

        df_day_hr = GarminTools().checkDate(df_day_hr, date)
        df_day_stress = GarminTools().checkDate(df_day_stress, date)

        df_day_hr.to_csv(os.path.join(final_csv_folder, date + '_hr.csv'), index=False)
        df_day_stress.to_csv(os.path.join(final_csv_folder, date + '_stress.csv'), index=False)

    def rearrange_all_days_csv(self):
        dates = os.listdir(os.path.join(self.person, 'intermediate_csv'))

        for oneday in dates:
            self.rearrange_one_day_csv(oneday)

    
    # def deal_one_person_all_day(self):
    #     self.convert_all_days_to_intermediate_csv()
    #     self.rearrange_csv()

if __name__=='__main__':
    pass

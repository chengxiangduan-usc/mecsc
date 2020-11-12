import os
import datetime
from copy import deepcopy

import pandas as pd

class EmbraceTester():
    """
    docstring
    """
    def __init__(self, uid, profile):
        self.uid = uid
        self.profile = profile
        self.df_collection = None

    def collect_one_person_one_day(self, date):
        """
        uid: 'r1_04'
        date: '2020-10-20'
        """
        device_id = '%03d' % int(self.profile['embrace']) # 006
        path_target = os.path.join(date, device_id)
        ls_dir = os.listdir(path_target)
        hash_id = ''
        for x in ls_dir:
            if x[0] != '.':
                hash_id = x
        path_target = os.path.join(path_target, hash_id)
        
        path_eda = os.path.join(path_target, 'eda.csv')
        path_temp = os.path.join(path_target, 'temp.csv')
        
        df_eda = pd.read_csv(path_eda)
        df_temp = pd.read_csv(path_temp)

        return {
            "df_eda": df_eda,
            "df_temp": df_temp
        }

    def collect_one_person_all_days(self):
        dfs_eda = []
        dfs_temp = []

        dates = deepcopy(self.profile['dates']['embrace'])

        # because of the utc timestamp, extend to collect one day
        last_date = dates[-1]
        extend_date = datetime.datetime.strptime(last_date, "%Y-%m-%d").date() + datetime.timedelta(days=1)
        dates.append(str(extend_date))

        for date in dates:
            df = self.collect_one_person_one_day(date)
            dfs_eda.append(df['df_eda'])
            dfs_temp.append(df['df_temp'])
        
        df_eda_all_days = pd.concat(dfs_eda).reset_index(drop=True)
        df_temp_all_days = pd.concat(dfs_temp).reset_index(drop=True)
        
        self.df_collection = {
            "eda": df_eda_all_days,
            "temp": df_temp_all_days
        }
        return self.df_collection

    def process_eda_df(self):
        """
        eda unit: microS
        """
        df = self.df_collection['eda']
        dates = self.profile['dates']['embrace']

        # change column names
        df.columns = ['time', 'eda']

        # timestamp -> formated LA time
        df.time = df.time.map(lambda ts: datetime.datetime.fromtimestamp(ts / 1000))

        # extract data of test dates
        dfs_dates = []
        for date in dates:
            df_one_day = df[df.time.astype(str).str.startswith(date)]
            dfs_dates.append(df_one_day)
        self.df_collection['eda'] = pd.concat(dfs_dates).reset_index(drop=True)

    def process_skin_temp_df(self):
        """
        skin_temp unit: °C
        """
        df = self.df_collection['temp']
        dates = self.profile['dates']['embrace']

        # change column names
        df.columns = ['time', 'skin_temp']

        # timestamp -> formated LA time
        df.time = df.time.map(lambda ts: datetime.datetime.fromtimestamp(ts / 1000))

        # extract data of test dates
        dfs_dates = []
        for date in dates:
            df_one_day = df[df.time.astype(str).str.startswith(date)]
            dfs_dates.append(df_one_day)
        self.df_collection['temp'] = pd.concat(dfs_dates).reset_index(drop=True)

    
    def output_collected_data(self, output_folder):
        if self.df_collection is None:
            print('dataframe collection is None.')
            return None

        output_path = os.path.join(output_folder, self.uid)
        if not os.path.exists(output_path):
            os.makedirs(output_path)

        path_eda = os.path.join(output_path, 'eda.csv')
        path_temp = os.path.join(output_path, 'skin_temp.csv')

        self.df_collection['eda'].to_csv(path_eda, index=False)
        self.df_collection['temp'].to_csv(path_temp, index=False)
import os

import pandas as pd

class HoboTester():
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
        device_file = '%03d.csv' % int(self.profile['hobo']) # 006.csv
        # print(device_file)
        
        df = pd.read_csv(device_file)
        df = df[df.time.str.startswith(date)]

        return df

    def collect_one_person_all_days(self):
        dfs = []

        dates = self.profile['dates']['hobo']
        for date in dates:
            df = self.collect_one_person_one_day(date)
            dfs.append(df)
        
        df_all_days = pd.concat(dfs).reset_index(drop=True)
        
        self.df = df_all_days
        return self.df
    
    def output_collected_data(self, output_folder):
        if self.df is None:
            print('dataframe collection is None.')
            return None

        output_path = os.path.join(output_folder, self.uid)
        if not os.path.exists(output_path):
            os.makedirs(output_path)

        p = os.path.join(output_path, 'hobo.csv')

        self.df.to_csv(p, index=False)
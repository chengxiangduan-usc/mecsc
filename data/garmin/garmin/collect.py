import os

import pandas as pd


class Tester():
    def __init__(self, name, root_folder, dates):
        """
        eg.:
        name = 'r1_01'
        root_folder = './garmin01'
        dates = ['2020-10-19', '2020-10-20', '2020-10-21']
        """
        self.name = name
        self.root_folder = root_folder
        self.csv_folder = os.path.join(self.root_folder, 'csv')
        self.output_folder = None
        self.dates = dates

        self.hr_df = None
        self.stress_df = None

    def setOutputFolder(self, output_folder):
        self.output_folder = output_folder

    def concatHeartRateDataFrames(self):
        dfs = []
        for date in self.dates:
            p = os.path.join(self.csv_folder, date + '_hr.csv')
            df = pd.read_csv(p)
            dfs.append(df)
        
        self.hr_df = pd.concat(dfs).reset_index(drop=True)
        return self.hr_df

    def concatStressDataFrames(self):
        dfs = []
        for date in self.dates:
            p = os.path.join(self.csv_folder, date + '_stress.csv')
            df = pd.read_csv(p)
            dfs.append(df)
        
        self.stress_df = pd.concat(dfs).reset_index(drop=True)
        return self.stress_df

    def outputProfile(self):
        if self.hr_df is None:
            print('hr_df is None.')
            return None
        if self.stress_df is None:
            print('stress_df is None.')
            return None
        if self.output_folder is None:
            print("didn't set output folder")
            return None

        if not os.path.exists(self.output_folder):
            os.makedirs(self.output_folder)
        
        self.hr_df.to_csv(os.path.join(self.output_folder, 'hr.csv'), index=False)
        self.stress_df.to_csv(os.path.join(self.output_folder, 'stress.csv'), index=False)

















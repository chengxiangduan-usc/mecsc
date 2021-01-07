import datetime

import pandas as pd

class HoboDataFrame(object):
    """
    docstring
    """
    def __init__(self, path_csv):
        self.df = pd.read_csv(path_csv)

    def preprocess(self):
        if len(self.df.columns) > 3:
            self.df = self.df[self.df.columns[0:3]]
        self.df.columns = ['time', 'env_temp', 'rh']
        self.df.time = self.df.time.map(lambda t: datetime.datetime.strptime(t, '%m/%d/%y %H:%M:%S'))

    def output_df(self, output_path):
        self.df.to_csv(output_path, index=False)
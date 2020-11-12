import pandas as pd

class GarminTools():
    def __init__(self):
        pass

    def timezoneshift(self, t_in, t_in_tz, t_out_tz):
        t_in_with_tz = t_in.replace(tzinfo=t_in_tz)
        t_out_with_tz = t_in_with_tz.astimezone(t_out_tz)
        t_out_without_tz = t_out_with_tz.replace(tzinfo=None)
        return t_out_without_tz

    def separateData(self, filepath):
        df = pd.read_csv(filepath)
        
        df_hr = df[['timestamp_16', 'heart_rate']]
        df_hr_without_nan = df_hr.dropna(axis=0, how='any')
        df_hr_without_nan.columns = ['time', 'heart_rate']
        
        df_stress = df[['stress_level_time', 'stress_level_value']]
        df_stress_without_nan = df_stress.dropna(axis=0, how='any')
        df_stress_without_nan.columns = ['time', 'stress_level']
        return df_hr_without_nan, df_stress_without_nan
    
    def checkDate(self, df, date_str):
        return df[df.time.str.startswith(date_str)].reset_index(drop=True)
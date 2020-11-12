import json
# import datetime
import os

import pandas as pd
# import numpy as np
# import matplotlib.pyplot as plt

def combine(uid):
    # hobo
    pth_hobo = os.path.join('./hobo', 'profiles', uid, 'hobo.csv')
    df_hobo = pd.read_csv(pth_hobo)

    df_hobo.time = pd.to_datetime(df_hobo.time)

    # garmin hr
    pth_garmin_hr = os.path.join('./garmin', 'profiles', uid, 'hr.csv')
    df_garmin_hr = pd.read_csv(pth_garmin_hr)

    df_garmin_hr.time = pd.to_datetime(df_garmin_hr.time)

    # garmin stress
    pth_garmin_stress = os.path.join('./garmin', 'profiles', uid, 'stress.csv')
    df_garmin_stress = pd.read_csv(pth_garmin_stress)

    df_garmin_stress.time = pd.to_datetime(df_garmin_stress.time)

    df_garmin_stress = df_garmin_stress[df_garmin_stress.stress_level >= 0].reset_index(drop=True)

    # embrace eda
    pth_embrace_eda = os.path.join('./embrace', 'profiles', uid, 'eda.csv')
    df_embrace_eda = pd.read_csv(pth_embrace_eda)

    df_embrace_eda.time = pd.to_datetime(df_embrace_eda.time)
    df_embrace_eda['time_ms'] = df_embrace_eda.time

    df_embrace_eda.time = df_embrace_eda.time_ms.map(lambda t: t.round('s'))

    df_embrace_eda = df_embrace_eda.groupby(by='time', as_index=False).agg({'eda': 'median'})

    # embrace skin temp
    pth_embrace_skin = os.path.join('./embrace', 'profiles', uid, 'skin_temp.csv')
    df_embrace_skin = pd.read_csv(pth_embrace_skin)

    df_embrace_skin.time = pd.to_datetime(df_embrace_skin.time)
    df_embrace_skin['time_ms'] = df_embrace_skin.time

    df_embrace_skin = df_embrace_skin[df_embrace_skin.skin_temp >= 30]

    df_embrace_skin.time = df_embrace_skin.time_ms.map(lambda t: t.round('s'))

    df_embrace_skin = df_embrace_skin.groupby(by='time', as_index=False).agg({'skin_temp': 'median'})

    # join 1
    df_garmin = pd.merge(df_garmin_hr, df_garmin_stress, how='outer', on='time', sort=True)

    df_embrace = pd.merge(df_embrace_skin, df_embrace_eda, how='outer', on='time', sort=True)

    df_all = pd.merge(df_hobo, df_garmin, how='outer', on='time', sort=True)
    df_all = pd.merge(df_all, df_embrace, how='outer', on='time', sort=True)

    df_all['time_m'] = df_all.time
    df_all['time'] = df_all.time_m.map(lambda t: t.round('2min'))

    df_all = df_all.drop(columns=['time_m'])

    df_all = df_all.groupby('time', as_index=False).agg('median')

    # body data
    pth_body = os.path.join('./', 'body_data.csv')
    df_body = pd.read_csv(pth_body)

    df_status = df_body.iloc[:, :6]
    df_status.columns = ['uid', 'height', 'weight', 'gender', 'bmi', 'age']

    df_test_time = pd.DataFrame()
    for col_name in df_body.columns[6:]:
        df_test_time['uid'] = df_body['uid']
        df_test_time[col_name] = pd.to_datetime(df_body[col_name])

    df_one = pd.DataFrame()

    time_start_1 = list(df_test_time[df_test_time['uid'] == uid]['1_start_time'])[0]
    time_end_1 = list(df_test_time[df_test_time['uid'] == uid]['1_end_time'])[0]

    time_start_2 = list(df_test_time[df_test_time['uid'] == uid]['2_start_time'])[0]
    time_end_2 = list(df_test_time[df_test_time['uid'] == uid]['2_end_time'])[0]

    time_start_3 = list(df_test_time[df_test_time['uid'] == uid]['3_start_time'])[0]
    time_end_3 = list(df_test_time[df_test_time['uid'] == uid]['3_end_time'])[0]

    t_list = []

    t = time_start_1
    while t <= time_end_1:
        t_list.append(t)
        t = t + pd.Timedelta('30min')

    t = time_start_2
    while t <= time_end_2:
        t_list.append(t)
        t = t + pd.Timedelta('30min')

    t = time_start_3
    while t <= time_end_3:
        t_list.append(t)
        t = t + pd.Timedelta('30min')

    t_Series = pd.Series(t_list)

    df_one['time'] = t_Series

    one_status = list(df_status[df_status['uid'] == uid].to_dict(orient='index').values())[0]
    df_one['height'] = one_status['height']
    df_one['weight'] = one_status['weight']
    df_one['gender'] = one_status['gender']
    df_one['bmi'] = one_status['bmi']
    df_one['age'] = one_status['age']

    # join 2
    df_one_all_without_record = pd.merge(df_one, df_all, how='left', on='time', sort=True)

    # record & join 3
    pth_record = os.path.join('./record', uid + '.csv')
    df_record = pd.read_csv(pth_record)

    df_record['time'] = df_record.Date + ' ' + df_record.Time + ':00'

    df_record['time'] = pd.to_datetime(df_record['time'])

    df_record = df_record.drop(axis=1, columns=['Date', 'Time'])

    df_one_all = pd.merge(df_one_all_without_record, df_record, how='left', on='time', sort=True)

    print('finish:', uid)
    return df_one_all

def main():
    with open('./profiles.json', 'r') as fp:
        profiles = json.load(fp)
    
    uids = list(profiles.keys())
    dfs = []
    for uid in uids:
        dfs.append(combine(uid))

    return dfs

if __name__ == "__main__":
    main()



















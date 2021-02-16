# -*- coding: utf-8 -*-

import os
import pandas as pd

def trans_tc_categories(value):
    if value == 1:
        return 'very_uncomfortable'
    elif value == 2:
        return 'uncomfortable'
    elif value == 3:
        return 'slightly_uncomfortable'
    elif value == 4:
        return 'neutral'
    elif value == 5:
        return 'slightly_comfortable'
    elif value == 6:
        return 'comfortable'
    elif value == 7:
        return 'very_comfortable'

for person_id in range(1, 31):
    path = os.path.join(os.getcwd(), 'all_data')
    file_path = os.path.join(path, '%.2d.csv' % person_id)
    print(file_path)
    df = pd.read_csv(file_path)

    for feature in ['env_temp', 'rh', 'heart_rate', 'stress_level', 'skin_temp', 'eda']:
        avg_value = df[feature].sum() / df[feature].count()
        df[feature] = df[feature].fillna(avg_value)

    # for idx, row in df.iterrows():
    #     df['TC'][idx] = trans_tc_categories(row['TC'])

    output_filename = 'res_arff/%.2d.arff' % person_id

    df.to_csv(output_filename, header=None, index=None)
    with open(output_filename, "r+") as fp:
        content = fp.read()
        fp.seek(0, 0)
        fp.write('''@RELATION signals\n\n@ATTRIBUTE env_temp NUMERIC\n@ATTRIBUTE rh NUMERIC\n@ATTRIBUTE heart_rate NUMERIC\n@ATTRIBUTE stress_level NUMERIC\n@ATTRIBUTE skin_temp NUMERIC\n@ATTRIBUTE eda NUMERIC\n@ATTRIBUTE Clo NUMERIC\n@ATTRIBUTE Act NUMERIC\n@ATTRIBUTE TC {very_uncomfortable,slightly_uncomfortable,uncomfortable,neutral,slightly_comfortable,comfortable,very_comfortable}\n\n@DATA\n''' + content)


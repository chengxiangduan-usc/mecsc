import json

import hobo

with open('../profiles.json', 'r') as fp:
    profiles = json.load(fp)

filenames = ['01', '03', '04', '06', '07', '08', '09', '10', '11', '12']

for fn in filenames:
    hobo_file = fn + '.csv'
    output_path = '0' + fn + '.csv'
    hobo.preprocess_one_hobo(hobo_file, output_path)
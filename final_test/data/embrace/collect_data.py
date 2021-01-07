import json

import embrace

with open('../profiles.json', 'r') as fp:
    profiles = json.load(fp)

for uid, profile in profiles.items():
    output_folder = './profiles/'
    embrace.collect_one_profile(uid, profile, output_folder)
    print('finish:', uid)





















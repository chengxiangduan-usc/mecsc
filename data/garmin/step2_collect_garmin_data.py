import json

import garmin

# device_id = ["01", "04", "06", "07", "08", "09", "10", "11", "12", "13"]
# rounds = ['r1', 'r2', 'r3']
# typical_dates = {
#     'r1': ['2020-10-19', '2020-10-20', '2020-10-21'],
#     'r2': ['2020-10-23', '2020-10-24', '2020-10-25'],
#     'r3': ['2020-10-26', '2020-10-27', '2020-10-28']
# }

# profiles = {}
# for r in rounds:
#     for i in device_id:
#         pro = {
#             'name': r + '_g' + i, # 'r1_g06'
#             'root_folder': './garmin' + i, # './garmin04'
#             'dates': typical_dates[r], # ['2020-10-19', '2020-10-20', '2020-10-21']
#         }
#         pro['output_folder'] = os.path.join("./profiles", pro['name']) # './profiles/r1_g06'
#         profiles[pro['name']] = pro

# # modify
# profiles['r3_g01']['dates'] = ['2020-10-26', '2020-10-27'] # zilu round3 miss 28 data
# profiles['r3_g07']['dates'] = ['2020-10-28', '2020-10-29', '2020-10-30'] # wudy round3 28-30

with open('../profiles.json', 'r') as fp:
    profiles = json.load(fp)

for uid, v in profiles.items():
    name = uid
    root_folder = './garmin' + v['garmin']
    dates = v['dates']['garmin']
    output_folder = './profiles/' + uid

    garmin.create_one_tester_profile(name, root_folder, dates, output_folder)
    print('finish:', uid)




















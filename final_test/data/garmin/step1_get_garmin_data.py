"""
person = "garmin04" or "all"
date = "2020-10-13" or "all"
"""
import pytz

import sys

import garmin

OUTPUT_TIMEZONE = pytz.timezone('America/Los_Angeles')
INPUT_TIMEZONE = pytz.timezone('UTC')

person = sys.argv[1]
date = sys.argv[2]

PERSONS = [
    "01",
    "04",
    "06",
    "07",
    "08",
    "09",
]

if person == 'all':
    if date == 'all':
        garmin.deal_all_person_all_days(PERSONS, INPUT_TIMEZONE, OUTPUT_TIMEZONE)
    else:
        garmin.deal_all_person_one_day(PERSONS, date, INPUT_TIMEZONE, OUTPUT_TIMEZONE)
else:
    if date == 'all':
        garmin.deal_one_person_all_days(person, INPUT_TIMEZONE, OUTPUT_TIMEZONE)
    else:
        garmin.deal_one_person_one_day(person, date, INPUT_TIMEZONE, OUTPUT_TIMEZONE)
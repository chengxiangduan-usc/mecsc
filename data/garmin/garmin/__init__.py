import pytz

from .basic import *
from .collect import *

OUTPUT_TIMEZONE = pytz.timezone('America/Los_Angeles')
INPUT_TIMEZONE = pytz.timezone('UTC')
# print('load garmin')
def deal_one_person_one_day(person, date, in_tz=INPUT_TIMEZONE, out_tz=OUTPUT_TIMEZONE):
    """
    date: string - "2020-10-13"
    """
    gar = Garmin(person, in_tz, out_tz)
    gar.covert_one_day_to_intermediate_csv(date)
    gar.rearrange_one_day_csv(date)

def deal_one_person_all_days(person, in_tz=INPUT_TIMEZONE, out_tz=OUTPUT_TIMEZONE):
    """
    person: string - "garmin04"
    """
    gar = Garmin(person, in_tz, out_tz)
    gar.convert_all_days_to_intermediate_csv()
    gar.rearrange_all_days_csv()

def deal_all_person_one_day(persons, date, in_tz=INPUT_TIMEZONE, out_tz=OUTPUT_TIMEZONE):
    for p in persons:
        deal_one_person_one_day(p, date, in_tz, out_tz)

def deal_all_person_all_days(persons, in_tz=INPUT_TIMEZONE, out_tz=OUTPUT_TIMEZONE):
    for p in persons:
        deal_one_person_all_days(p, in_tz, out_tz)

def create_one_tester_profile(name, root_folder, dates, output_folder):
    tester = Tester(name, root_folder, dates)
    tester.setOutputFolder(output_folder)
    tester.concatHeartRateDataFrames()
    tester.concatStressDataFrames()
    tester.outputProfile()

from hobo.preprocess import *
from hobo.collect import *

def preprocess_one_hobo(hobo_file, output_path):
    hd = HoboDataFrame(hobo_file)
    hd.preprocess()
    hd.output_df(output_path)

def collect_one_profile(uid, profile, output_folder):
    hdt = HoboTester(uid, profile)
    hdt.collect_one_person_all_days()
    hdt.output_collected_data(output_folder)
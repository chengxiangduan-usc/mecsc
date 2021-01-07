
from embrace.collect import *

def collect_one_profile(uid, profile, output_folder):
    emb = EmbraceTester(uid, profile)
    emb.collect_one_person_all_days()
    emb.process_eda_df()
    emb.process_skin_temp_df()
    emb.output_collected_data(output_folder)
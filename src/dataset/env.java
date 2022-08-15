package dataset;

public class env {
	// All links from CITF Malaysia Github
	public static final String VAX_MALAYSIA = "https://raw.githubusercontent.com/CITF-Malaysia/citf-public/main/vaccination/vax_malaysia.csv";
	public static final String VAX_STATE = "https://raw.githubusercontent.com/CITF-Malaysia/citf-public/main/vaccination/vax_state.csv";
	public static final String VAX_REG_MALAYSIA = "https://raw.githubusercontent.com/CITF-Malaysia/citf-public/main/registration/vaxreg_malaysia.csv";
	public static final String VAX_REG_STATE = "https://raw.githubusercontent.com/CITF-Malaysia/citf-public/main/registration/vaxreg_state.csv";
	public static final String[] STATES = {"Johor","Kedah","Kelantan","Melaka","Negeri Sembilan","Pahang","Perak","Perlis","Pulau Pinang","Sabah",
			"Sarawak","Selangor","Terengganu","W.P. Kuala Lumpur", "W.P. Labuan", "W.P. Putrajaya" };
	public static final String[] VACCINE_TYPES = {"pfizer1","pfizer2","pfizer3","sinovac1","sinovac2","sinovac3","astra1","astra2","astra3","sinopharm1",
			"sinopharm2","sinopharm3","cansino","cansino3","pending1","pending2","pending3"};
        public static final String[] DATA_COL_VAX = {"No.", "Date", "State", "Daily Partial", "Daily Full", "Daily Booster", "Daily", "Daily Partial Adult",
            "Daily Full Adult", "Daily Partial Child", "Daily Full Child", "Cumulative Partial", "Cumulative Full", "Cumulative Booster", "Cumulative",
            "Cumulative Partial Adult", "Cumulative Full Adult", "Cumulative Partial Child", "Cumulative Full Child", "Pfizer1", "Pfizer2", "Pfizer3",
            "Sinovac1", "Sinovac2", "Sinovac3", "Astra1", "Astra2", "Astra3", "Sinopharm1", "Sinopharm2", "Sinopharm3", "Cansino", "Cansino3", "Pending1",
            "Pending2", "Pending3"};
        public static final String[] DATA_COL_REG = {"No.", "Date","State","Total","Phase2","Mysj","Call","Web","Children","Children Solo","Adolescents",
            "Elderly","Comorb","Oku"};
}

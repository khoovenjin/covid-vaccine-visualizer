package classesstate;

public class VaxJohorState<T,U> extends VaxState<T,U> {
	
//	public Nullable<String> state = new Nullable<String>("Johor");
	{
		state.setData("Johor");
	}
	
	public VaxJohorState(T date, U daily_partial, U daily_full, U daily_booster, U daily,
			U daily_partial_adol, U daily_full_adol, U daily_partial_child, U daily_full_child,
			U cumul_partial, U cumul_full, U cumul_booster, U cumul, U cumul_partial_adol,
			U cumul_full_adol, U cumul_partial_child, U cumul_full_child, U pfizer1, U pfizer2, U pfizer3,
			U sinovac1, U sinovac2, U sinovac3, U astra1, U astra2, U astra3, U sinopharm1,
			U sinopharm2, U sinopharm3, U cansino, U cansino3, U pending1, U pending2, U pending3) {
		super(date, daily_partial, daily_full, daily_booster, daily, daily_partial_adol, daily_full_adol, daily_partial_child,
				daily_full_child, cumul_partial, cumul_full, cumul_booster, cumul, cumul_partial_adol, cumul_full_adol,
				cumul_partial_child, cumul_full_child, pfizer1, pfizer2, pfizer3, sinovac1, sinovac2, sinovac3, astra1, astra2,
				astra3, sinopharm1, sinopharm2, sinopharm3, cansino, cansino3, pending1, pending2, pending3);
	}
}

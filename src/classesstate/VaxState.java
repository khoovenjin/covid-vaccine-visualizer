package classesstate;

import datastructure.Nullable;

public class VaxState<T,U> {
	
	private T date; // LocalDate
	private U daily_partial,daily_full,daily_booster,daily,daily_partial_adol,daily_full_adol,daily_partial_child,daily_full_child,
	cumul_partial,cumul_full,cumul_booster,cumul,cumul_partial_adol,cumul_full_adol,cumul_partial_child,cumul_full_child,pfizer1,
	pfizer2,pfizer3,sinovac1,sinovac2,sinovac3,astra1,astra2,astra3,sinopharm1,sinopharm2,sinopharm3,cansino,cansino3,pending1,
	pending2,pending3; // Integer/int/Numbers/Long etc.
	public Nullable<String> state = new Nullable<String>(null); // String
	
	public VaxState (T date, U daily_partial, U daily_full, U daily_booster, U daily, U daily_partial_adol,
			U daily_full_adol, U daily_partial_child, U daily_full_child, U	cumul_partial, U cumul_full, U cumul_booster,
			U cumul, U cumul_partial_adol, U cumul_full_adol, U cumul_partial_child, U cumul_full_child, U pfizer1,
			U pfizer2, U pfizer3, U sinovac1, U sinovac2, U sinovac3, U astra1, U astra2, U astra3, U sinopharm1,
			U sinopharm2, U sinopharm3, U cansino, U cansino3, U pending1, U pending2, U pending3) {
		this.date = date;
		this.daily_partial = daily_partial;
		this.daily_full = daily_full;
		this.daily_booster = daily_booster;
		this.daily = daily;
		this.daily_partial_adol = daily_partial_adol;
		this.daily_full_adol = daily_full_adol;
		this.daily_partial_child = daily_partial_child;
		this.daily_full_child = daily_full_child;
		this.cumul_partial = cumul_partial;
		this.cumul_full = cumul_full;
		this.cumul_booster = cumul_booster;
		this.cumul = cumul;
		this.cumul_partial_adol = cumul_partial_adol;
		this.cumul_full_adol = cumul_full_adol;
		this.cumul_partial_child = cumul_partial_child;
		this.cumul_full_child = cumul_full_child;
		this.pfizer1 = pfizer1;
		this.pfizer2 = pfizer2;
		this.pfizer3 = pfizer3;
		this.sinovac1 = sinovac1;
		this.sinovac2 = sinovac2;
		this.sinovac3 = sinovac3;
		this.astra1 = astra1;
		this.astra2 = astra2;
		this.astra3 = astra3;
		this.sinopharm1 = sinopharm1;
		this.sinopharm2 = sinopharm2;
		this.sinopharm3 = sinopharm3;
		this.cansino = cansino;
		this.cansino3 = cansino3;
		this.pending1 = pending1;
		this.pending2 = pending2;
		this.pending3 = pending3;
	}
	
	public T getDate () {
		return date;
	}
	
	public U getDailyPartial () {
		return daily_partial;
	}
	
	public U getDailyFull () {
		return daily_full;
	}
	
	public U getDailyBooster () {
		return daily_booster;
	}
	
	public U getDaily () {
		return daily;
	}
	
	public U getDailyPartialAdult () {
		return daily_partial_adol;
	}
	
	public U getDailyFullAdult () {
		return daily_full_adol;
	}
	
	public U getDailyPartialChild () {
		return daily_partial_child;
	}
	
	public U getDailyFullChild () {
		return daily_full_child;
	}
	
	public U getCumulativePartial () {
		return cumul_partial;
	}
	
	public U getCumulativeFull () {
		return cumul_full;
	}
	
	public U getCumulativeBooster () {
		return cumul_booster;
	}
	
	public U getCumulative () {
		return cumul;
	}
	
	public U getCumulativePartialAdult () {
		return cumul_partial_adol;
	}
	
	public U getCumulativeFullAdult () {
		return cumul_full_adol;
	}
	
	public U getCumulativePartialChild () {
		return cumul_partial_child;
	}
	
	public U getCumulativeFullChild () {
		return cumul_full_child;
	}
	
	public U getPhizer1 () {
		return pfizer1;
	}
	
	public U getPhizer2 () {
		return pfizer2;
	}

	public U getPhizer3 () {
		return pfizer3;
	}
	
	public U getSinovac1 () {
		return sinovac1;
	}
	
	public U getSinovac2 () {
		return sinovac2;
	}
	
	public U getSinovac3 () {
		return sinovac3;
	}
	
	public U getAstra1 () {
		return astra1;
	}
	
	public U getAstra2 () {
		return astra2;
	}
	
	public U getAstra3 () {
		return astra3;
	}
	
	public U getSinopharm1 () {
		return sinopharm1;
	}
	
	public U getSinopharm2 () {
		return sinopharm2;
	}
	
	public U getSinopharm3 () {
		return sinopharm3;
	}
	
	public U getCansino () {
		return cansino;
	}
	
	public U getCansino3 () {
		return cansino3;
	}
	
	public U getPending1 () {
		return pending1;
	}
	
	public U getPending2 () {
		return pending2;
	}
	
	public U getPending3 () {
		return pending3;
	}
	
	public void setDate (T date) {
		this.date = date;
	}
	
	public void setDailyPartial (U daily_partial) {
		this.daily_partial = daily_partial;
	}
	
	public void setDailyFull (U daily_full) {
		this.daily_full = daily_full;
	}

	public void setDailyBooster (U daily_booster) {
		this.daily_booster = daily_booster;
	}
	
	public void setDaily (U daily) {
		this.daily = daily;
	}
	
	public void setDailyPartialAdult (U daily_partial_adol) {
		this.daily_partial_adol = daily_partial_adol;
	}
	
	public void setDailyFullAdult (U daily_full_adol) {
		this.daily_full_adol = daily_full_adol;
	}
	
	public void setDailyPartialChild (U daily_partial_child) {
		this.daily_partial_child = daily_partial_child;
	}
	
	public void setDailyFullChild (U daily_full_child) {
		this.daily_full_child = daily_full_child;
	}
	
	public void setCumulativePartial (U cumul_partial) {
		this.cumul_partial = cumul_partial;
	}
	
	public void setCumulativeFull (U cumul_full) {
		this.cumul_full = cumul_full;
	}
	
	public void setCumulativeBooster (U cumul_booster) {
		this.cumul_booster = cumul_booster;
	}
	
	public void setCumulative (U cumul) {
		this.cumul = cumul;
	}
	
	public void setCumulativePartialAdult (U cumul_partial_adol) {
		this.cumul_partial_adol = cumul_partial_adol;
	}
	
	public void setCumulativeFullAdult (U cumul_full_adol) {
		this.cumul_full_adol = cumul_full_adol;
	}
	
	public void setCumulativePartialChild (U cumul_partial_child) {
		this.cumul_partial_child = cumul_partial_child;
	}
	
	public void setCumulativeFullChild (U cumul_full_child) {
		this.cumul_full_child = cumul_full_child;
	}

	public void setPfizer1 (U pfizer1) {
		this.pfizer1 = pfizer1;
	}
	
	public void setPfizer2 (U pfizer2) {
		this.pfizer2 = pfizer2;
	}
	
	public void setPfizer3 (U pfizer3) {
		this.pfizer3 = pfizer3;
	}
	
	public void setSinovac1 (U sinovac1) {
		this.sinovac1 = sinovac1;
	}
	
	public void setSinovac2 (U sinovac2) {
		this.sinovac2 = sinovac2;
	}
	
	public void setSinovac3 (U sinovac3) {
		this.sinovac3 = sinovac3;
	}

	public void setAstra1 (U astra1) {
		this.astra1 = astra1;
	}
	
	public void setAstra2 (U astra2) {
		this.astra2 = astra2;
	}
	
	public void setAstra3 (U astra3) {
		this.astra3 = astra3;
	}
	
	public void setSinopharm1 (U sinopharm1) {
		this.sinopharm1 = sinopharm1;
	}
	
	public void setSinopharm2 (U sinopharm2) {
		this.sinopharm2 = sinopharm2;
	}
	
	public void setSinopharm3 (U sinopharm3) {
		this.sinopharm3 = sinopharm3;
	}
	
	public void setCansino (U cansino) {
		this.cansino = cansino;
	}
	
	public void setCansino3 (U cansino3) {
		this.cansino3 = cansino3;
	}
	
	public void setPending1 (U pending1) {
		this.pending1 = pending1;
	}
	
	public void setPending2 (U pending2) {
		this.pending2 = pending2;
	}
	
	public void setPending3 (U pending3) {
		this.pending3 = pending3;
	}
        
}

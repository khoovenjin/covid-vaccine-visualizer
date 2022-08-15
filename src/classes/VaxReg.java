package classes;

import java.util.Date;

public class VaxReg {
    private VaxRegistration<Date, String, Integer> defaultregstate;
    private VaxRegistration<Date, String, Integer> johorregstate;
    private VaxRegistration<Date, String, Integer> kedahregstate;
    private VaxRegistration<Date, String, Integer> kelantanregstate;
    private VaxRegistration<Date, String, Integer> melakaregstate;
    private VaxRegistration<Date, String, Integer> n9regstate;
    private VaxRegistration<Date, String, Integer> pahangregstate;
    private VaxRegistration<Date, String, Integer> perakregstate;
    private VaxRegistration<Date, String, Integer> perlisregstate;
    private VaxRegistration<Date, String, Integer> pinangregstate;
    private VaxRegistration<Date, String, Integer> sabahregstate;
    private VaxRegistration<Date, String, Integer> sarawakregstate;
    private VaxRegistration<Date, String, Integer> selangorregstate;
    private VaxRegistration<Date, String, Integer> terengganuregstate;
    private VaxRegistration<Date, String, Integer> klregstate;
    private VaxRegistration<Date, String, Integer> labuanregstate;
    private VaxRegistration<Date, String, Integer> putrajayaregstate;
    private Date date;

    public VaxReg() {}
	
    public VaxReg(VaxRegistration<Date, String, Integer> defaultregstate,
                    VaxRegistration<Date, String, Integer> johorregstate, VaxRegistration<Date, String, Integer> kedahregstate,
                    VaxRegistration<Date, String, Integer> kelantanregstate, 
                    VaxRegistration<Date, String, Integer> melakaregstate, VaxRegistration<Date, String, Integer> n9regstate,
                    VaxRegistration<Date, String, Integer> pahangregstate, VaxRegistration<Date, String, Integer> perakregstate,
                    VaxRegistration<Date, String, Integer> perlisregstate,
                    VaxRegistration<Date, String, Integer> pinangregstate,
                    VaxRegistration<Date, String, Integer> sabahregstate,
                    VaxRegistration<Date, String, Integer> sarawakregstate,
                    VaxRegistration<Date, String, Integer> selangorregstate,
                    VaxRegistration<Date, String, Integer> terengganuregstate,
                    VaxRegistration<Date, String, Integer> klregstate, VaxRegistration<Date, String, Integer> labuanregstate, 
                    VaxRegistration<Date, String, Integer> putrajayaregstate) {
            this.defaultregstate = defaultregstate;
            this.johorregstate = johorregstate;
            this.kedahregstate = kedahregstate;
            this.kelantanregstate = kelantanregstate;
            this.klregstate = klregstate;
            this.labuanregstate = labuanregstate;
            this.melakaregstate = melakaregstate;
            this.n9regstate = n9regstate;
            this.pahangregstate = pahangregstate;
            this.perakregstate = perakregstate;
            this.perlisregstate = perlisregstate;
            this.pinangregstate = pinangregstate;
            this.putrajayaregstate = putrajayaregstate;
            this.sabahregstate = sabahregstate;
            this.sarawakregstate = sarawakregstate;
            this.selangorregstate = selangorregstate;
            this.terengganuregstate = terengganuregstate;
            this.setDate(defaultregstate.getDate());
    }
	
	public VaxRegistration<Date, String, Integer> getDefaultregstate() {
		return defaultregstate;
	}

	public void setDefaultregstate(VaxRegistration<Date, String, Integer> defaultregstate) {
		this.defaultregstate = defaultregstate;
	}

	public VaxRegistration<Date, String, Integer> getJohorregstate() {
		return johorregstate;
	}

	public void setJohorregstate(VaxRegistration<Date, String, Integer> johorregstate) {
		this.johorregstate = johorregstate;
	}

	public VaxRegistration<Date, String, Integer> getKedahregstate() {
		return kedahregstate;
	}

	public void setKedahregstate(VaxRegistration<Date, String, Integer> kedahregstate) {
		this.kedahregstate = kedahregstate;
	}

	public VaxRegistration<Date, String, Integer> getKelantanregstate() {
		return kelantanregstate;
	}

	public void setKelantanregstate(VaxRegistration<Date, String, Integer> kelantanregstate) {
		this.kelantanregstate = kelantanregstate;
	}

	public VaxRegistration<Date, String, Integer> getKlregstate() {
		return klregstate;
	}

	public void setKlregstate(VaxRegistration<Date, String, Integer> klregstate) {
		this.klregstate = klregstate;
	}

	public VaxRegistration<Date, String, Integer> getLabuanregstate() {
		return labuanregstate;
	}

	public void setLabuanregstate(VaxRegistration<Date, String, Integer> labuanregstate) {
		this.labuanregstate = labuanregstate;
	}

	public VaxRegistration<Date, String, Integer> getMelakaregstate() {
		return melakaregstate;
	}

	public void setMelakaregstate(VaxRegistration<Date, String, Integer> melakaregstate) {
		this.melakaregstate = melakaregstate;
	}

	public VaxRegistration<Date, String, Integer> getN9regstate() {
		return n9regstate;
	}

	public void setN9regstate(VaxRegistration<Date, String, Integer> n9regstate) {
		this.n9regstate = n9regstate;
	}

	public VaxRegistration<Date, String, Integer> getPahangregstate() {
		return pahangregstate;
	}

	public void setPahangregstate(VaxRegistration<Date, String, Integer> pahangregstate) {
		this.pahangregstate = pahangregstate;
	}

	public VaxRegistration<Date, String, Integer> getPerakregstate() {
		return perakregstate;
	}

	public void setPerakregstate(VaxRegistration<Date, String, Integer> perakregstate) {
		this.perakregstate = perakregstate;
	}

	public VaxRegistration<Date, String, Integer> getPerlisregstate() {
		return perlisregstate;
	}

	public void setPerlisregstate(VaxRegistration<Date, String, Integer> perlisregstate) {
		this.perlisregstate = perlisregstate;
	}

	public VaxRegistration<Date, String, Integer> getPinangregstate() {
		return pinangregstate;
	}

	public void setPinangregstate(VaxRegistration<Date, String, Integer> pinangregstate) {
		this.pinangregstate = pinangregstate;
	}

	public VaxRegistration<Date, String, Integer> getPutrajayaregstate() {
		return putrajayaregstate;
	}

	public void setPutrajayaregstate(VaxRegistration<Date, String, Integer> putrajayaregstate) {
		this.putrajayaregstate = putrajayaregstate;
	}

	public VaxRegistration<Date, String, Integer> getSabahregstate() {
		return sabahregstate;
	}

	public void setSabahregstate(VaxRegistration<Date, String, Integer> sabahregstate) {
		this.sabahregstate = sabahregstate;
	}

	public VaxRegistration<Date, String, Integer> getSarawakregstate() {
		return sarawakregstate;
	}

	public void setSarawakregstate(VaxRegistration<Date, String, Integer> sarawakregstate) {
		this.sarawakregstate = sarawakregstate;
	}

	public VaxRegistration<Date, String, Integer> getSelangorregstate() {
		return selangorregstate;
	}

	public void setSelangorregstate(VaxRegistration<Date, String, Integer> selangorregstate) {
		this.selangorregstate = selangorregstate;
	}

	public VaxRegistration<Date, String, Integer> getTerengganuregstate() {
		return terengganuregstate;
	}

	public void setTerengganuregstate(VaxRegistration<Date, String, Integer> terengganuregstate) {
		this.terengganuregstate = terengganuregstate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

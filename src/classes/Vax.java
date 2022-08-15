package classes;

import java.util.Date;

import classesstate.*;

public class Vax {
	private VaxDefaultState<Date, Integer> defaultstate;
	private VaxJohorState<Date, Integer> johorstate;
	private VaxKedahState<Date, Integer> kedahstate;
	private VaxKelantanState<Date, Integer> kelantanstate;
	private VaxKLState<Date, Integer> klstate;
	private VaxLabuanState<Date, Integer> labuanstate;
	private VaxMelakaState<Date, Integer> melakastate;
	private VaxN9State<Date, Integer> n9state;
	private VaxPahangState<Date, Integer> pahangstate;
	private VaxPerakState<Date, Integer> perakstate;
	private VaxPerlisState<Date, Integer> perlisstate;
	private VaxPinangState<Date, Integer> pinangstate;
	private VaxPutrajayaState<Date, Integer> putrajayastate;
	private VaxSabahState<Date, Integer> sabahstate;
	private VaxSarawakState<Date, Integer> sarawakstate;
	private VaxSelangorState<Date, Integer> selangorstate;
	private VaxTerengganuState<Date, Integer> terengganustate;
	private Date date;
	
	public Vax () {	}
	
	public Vax (VaxDefaultState<Date, Integer> defaultstate, VaxJohorState<Date, Integer> johorstate, VaxKedahState<Date, Integer> kedahstate, VaxKelantanState<Date, Integer> kelantanstate,
	VaxKLState<Date, Integer> klstate, VaxLabuanState<Date, Integer> labuanstate, VaxMelakaState<Date, Integer> melakastate, VaxN9State<Date, Integer> n9state, VaxPahangState<Date, Integer> pahangstate,
	VaxPerakState<Date, Integer> perakstate, VaxPerlisState<Date, Integer> perlisstate, VaxPinangState<Date, Integer> pinangstate, VaxPutrajayaState<Date, Integer> putrajayastate,
	VaxSabahState<Date, Integer> sabahstate, VaxSarawakState<Date, Integer> sarawakstate, VaxSelangorState<Date, Integer> selangorstate, VaxTerengganuState<Date, Integer> terengganustate) {
		this.defaultstate = defaultstate;
		this.johorstate = johorstate;
		this.kedahstate = kedahstate;
		this.kelantanstate = kelantanstate;
		this.klstate = klstate;
		this.labuanstate = labuanstate;
		this.melakastate = melakastate;
		this.n9state = n9state;
		this.pahangstate = pahangstate;
		this.perakstate = perakstate;
		this.perlisstate = perlisstate;
		this.pinangstate = pinangstate;
		this.putrajayastate = putrajayastate;
		this.sabahstate = sabahstate;
		this.sarawakstate = sarawakstate;
		this.selangorstate = selangorstate;
		this.terengganustate = terengganustate;
		this.setDate(defaultstate.getDate());
	}
	
	public VaxDefaultState<Date, Integer> getDefaultstate() {
		return defaultstate;
	}
	
	public VaxJohorState<Date, Integer> getJohorstate() {
		return johorstate;
	}
	
	public VaxKedahState<Date, Integer> getKedahstate() {
		return kedahstate;
	}
	
	public VaxKelantanState<Date, Integer> getKelantanstate() {
		return kelantanstate;
	}

	public VaxKLState<Date, Integer> getKlstate() {
		return klstate;
	}
	
	public VaxLabuanState<Date, Integer> getLabuanstate() {
		return labuanstate;
	}

	public VaxMelakaState<Date, Integer> getMelakastate() {
		return melakastate;
	}
	
	public VaxN9State<Date, Integer> getN9state() {
		return n9state;
	}
	
	public VaxPahangState<Date, Integer> getPahangstate() {
		return pahangstate;
	}
	
	public VaxPerakState<Date, Integer> getPerakstate() {
		return perakstate;
	}

	public VaxPerlisState<Date, Integer> getPerlisstate() {
		return perlisstate;
	}
	
	public VaxPinangState<Date, Integer> getPinangstate() {
		return pinangstate;
	}
	
	public VaxPutrajayaState<Date, Integer> getPutrajayastate() {
		return putrajayastate;
	}
	
	public VaxSabahState<Date, Integer> getSabahstate() {
		return sabahstate;
	}

	public VaxSarawakState<Date, Integer> getSarawakstate() {
		return sarawakstate;
	}
	
	public VaxSelangorState<Date, Integer> getSelangorstate() {
		return selangorstate;
	}
	
	public VaxTerengganuState<Date, Integer> getTerengganustate() {
		return terengganustate;
	}
	
	public void setDefaultstate(VaxDefaultState<Date, Integer> defaultstate) {
		this.defaultstate = defaultstate;
	}

	public void setJohorstate(VaxJohorState<Date, Integer> johorstate) {
		this.johorstate = johorstate;
	}

	public void setKedahstate(VaxKedahState<Date, Integer> kedahstate) {
		this.kedahstate = kedahstate;
	}

	public void setKelantanstate(VaxKelantanState<Date, Integer> kelantanstate) {
		this.kelantanstate = kelantanstate;
	}

	public void setKlstate(VaxKLState<Date, Integer> klstate) {
		this.klstate = klstate;
	}
	
	public void setLabuanstate(VaxLabuanState<Date, Integer> labuanstate) {
		this.labuanstate = labuanstate;
	}

	public void setMelakastate(VaxMelakaState<Date, Integer> melakastate) {
		this.melakastate = melakastate;
	}

	public void setN9state(VaxN9State<Date, Integer> n9state) {
		this.n9state = n9state;
	}

	public void setPahangstate(VaxPahangState<Date, Integer> pahangstate) {
		this.pahangstate = pahangstate;
	}
	
	public void setPerakstate(VaxPerakState<Date, Integer> perakstate) {
		this.perakstate = perakstate;
	}

	public void setPerlisstate(VaxPerlisState<Date, Integer> perlisstate) {
		this.perlisstate = perlisstate;
	}

	public void setPinangstate(VaxPinangState<Date, Integer> pinangstate) {
		this.pinangstate = pinangstate;
	}

	public void setPutrajayastate(VaxPutrajayaState<Date, Integer> putrajayastate) {
		this.putrajayastate = putrajayastate;
	}
	
	public void setSabahstate(VaxSabahState<Date, Integer> sabahstate) {
		this.sabahstate = sabahstate;
	}

	public void setSarawakstate(VaxSarawakState<Date, Integer> sarawakstate) {
		this.sarawakstate = sarawakstate;
	}

	public void setSelangorstate(VaxSelangorState<Date, Integer> selangorstate) {
		this.selangorstate = selangorstate;
	}

	public void setTerengganustate(VaxTerengganuState<Date, Integer> terengganustate) {
		this.terengganustate = terengganustate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

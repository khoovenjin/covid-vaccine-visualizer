package dataset;

import java.util.ArrayList;
import java.util.List;

import classes.VaxReg;

// Concept of Singleton
public class VaxRegData {
	private static List<VaxReg> vaxreglist;

	private VaxRegData () {}
	
	public static final List<VaxReg> create () {
		if (vaxreglist == null) {
			vaxreglist = new ArrayList<>();
			System.out.println("VaxRegData is instantiated");
		} else {
			System.out.println("VaxRegData already existed");
		}
		return VaxRegData.vaxreglist;
	}
	
	public static void add (VaxReg record) {
		vaxreglist.add(record);
	}
	
	public static List<VaxReg> getAllVaxRegData () {
		return vaxreglist;
	}

	public static void setVaxRegData(List<VaxReg> vaxreglist) {
		VaxRegData.vaxreglist = vaxreglist;
	}
}

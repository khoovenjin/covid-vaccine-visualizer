package dataset;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import classes.VaxRegistration;

// Concept of Singleton
public class VaxRegData2 {
	private static List<VaxRegistration<Date, String, Integer>> vaxreglist;

	private VaxRegData2 () {}
	
	public static final List<VaxRegistration<Date, String, Integer>> create () {
		if (vaxreglist == null) {
			vaxreglist = new ArrayList<>();
			System.out.println("VaxRegData2 is instantiated");
		} else {
			System.out.println("VaxRegData2 already existed");
		}
		return VaxRegData2.vaxreglist;
	}
	
	public static void add (VaxRegistration<Date, String, Integer> record) {
		vaxreglist.add(record);
	}
	
	public static List<VaxRegistration<Date, String, Integer>> getAllVaxRegData () {
		return vaxreglist;
	}

	public static void setVaxRegData(List<VaxRegistration<Date, String, Integer>> vaxreglist) {
		VaxRegData2.vaxreglist = vaxreglist;
	}
}


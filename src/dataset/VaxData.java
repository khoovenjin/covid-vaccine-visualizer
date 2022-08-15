package dataset;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import classes.Vax;

// Concept of Singleton
public class VaxData {
	private static List<Vax> vaxlist;

	private VaxData () {}
	
	public static final List<Vax> create () {
		if (vaxlist == null) {
			vaxlist = new ArrayList<>();
			System.out.println("VaxData is instantiated");
		} else {
			System.out.println("VaxData already existed");
		}
		return VaxData.vaxlist;
	}
	
	public static void add (Vax record) {
		vaxlist.add(record);
	}
	
	public static List<Vax> getAllVaxData () {
		return vaxlist;
	}
	
	public static List<Vax> getDateVaxData (Date date) {
		// Search in the listdata and take data and return a new list
		
		return vaxlist;
	}

	public static void setVaxData(List<Vax> vaxlist) {
		VaxData.vaxlist = vaxlist;
	}
}

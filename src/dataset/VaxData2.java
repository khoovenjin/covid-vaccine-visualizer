package dataset;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import classesstate.VaxState;

// Concept of Singleton
public class VaxData2 {
    private static List<VaxState<Date, Integer>> vaxlist;

    private VaxData2 () {}

    public static final List<VaxState<Date, Integer>> create () {
        if (vaxlist == null) {
            vaxlist = new ArrayList<>();
            System.out.println("VaxData2 is instantiated");
        } else {
                System.out.println("VaxData2 already existed");
        }
        return VaxData2.vaxlist;
    }

    public static void add (VaxState<Date, Integer> record) {
        vaxlist.add(record);
    }

    public static List<VaxState<Date, Integer>> getAllVaxData () {
        return vaxlist;
    }

    public static List<VaxState<Date, Integer>> getDateVaxData (LocalDate ld) {
        // Search in the listdata and take data and return a new list

        return vaxlist;
    }

    public static void setVaxData(List<VaxState<Date, Integer>> vaxlist) {
        VaxData2.vaxlist = vaxlist;
    }
}

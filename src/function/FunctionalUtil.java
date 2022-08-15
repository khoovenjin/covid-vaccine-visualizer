package function;

import classes.VaxRegistration;
import java.util.Date;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import classesstate.VaxState;

public class FunctionalUtil {
	
    private static final BiPredicate<String, String> equalsReferenceName = (inputParam, reference) -> inputParam.toLowerCase().equals(reference.toLowerCase());
    
    public static List<VaxState<Date, Integer>> getDistinctStates(List<VaxState<Date, Integer>> dataset) {
        return dataset.stream()
            .filter(ConHashMapDistinct.distinctByKey(data -> (String) data.state.value()))
            .collect(Collectors.toList());
    }// Working

    public static List<VaxState<Date, Integer>> getStateEqualsName(List<VaxState<Date, Integer>> dataset, String state) {
        return dataset.stream()
            .filter(data -> equalsReferenceName.test((String) data.state.value(), state))
            .collect(Collectors.toList());
    }// Working
    
    public static List<VaxRegistration<Date, String, Integer>> getStateEqualsNameReg(List<VaxRegistration<Date, String, Integer>> dataset, String state) {
        return dataset.stream()
            .filter(data -> equalsReferenceName.test(data.getState(), state))
            .collect(Collectors.toList());
    }// Working

    public static List<String> getReformattedWeeklyDate(List<VaxState<Date, Integer>> dataset) {
        VaxState<Date, Integer> result = dataset.stream().findAny().orElse(null);
        if (result == null) {
            return null;
        }
        return dataset.stream()
                .map(data -> DateReformat.weekYearFormat.format(data.getDate()))
                .filter(ConHashMapDistinct.distinctByKey(data -> data))
                .collect(Collectors.toList());
    }// Working

    public static List<String> getReformattedMonthlyDate(List<VaxState<Date, Integer>> dataset) {
        VaxState<Date, Integer> result = dataset.stream().findAny().orElse(null);
        if (result == null) {
            return null;
        }
        return dataset.stream()
                .map(data -> DateReformat.monthYearFormat.format(data.getDate()))
                .filter(ConHashMapDistinct.distinctByKey(data -> data))
                .collect(Collectors.toList());
    }// Working

    public static String getReformattedWeeklyBeginDate(List<VaxState<Date, Integer>> dataset, String weekYear) {
        VaxState<Date, Integer> result = dataset.stream().findAny().orElse(null);
        if (result == null) {
            return null;
        }
        return dataset.stream()
                .filter(data -> DateReformat.weekYearFormat.format(data.getDate()).equals(weekYear))
                .sorted(Comparator.comparing(data -> data.getDate()))
                .map(data -> DateReformat.convertDateToShortFormat(data.getDate())).findFirst().orElse(null);
    }// Working

    public static String getReformattedWeeklyLastDate(List<VaxState<Date, Integer>> dataset, String weekYear) {
        VaxState<Date, Integer> result = dataset.stream().findAny().orElse(null);
        if (result == null) {
            return null;
        }
        return dataset.stream()
                .filter(data -> DateReformat.weekYearFormat.format(data.getDate()).equals(weekYear))
                .sorted(Comparator.comparing(data -> data.getDate()))
                .map(data -> DateReformat.convertDateToShortFormat(data.getDate())).reduce((x, y) -> y).orElse(null);
    }// Working
    
    public static Integer getMonthlyFullyVaccineByState(List<VaxState<Date, Integer>> dataset, String state, String monthYear) {
        List<VaxState<Date, Integer>> results = getStateEqualsName(dataset, state);
        if (results == null) {
                return null;
        }
        int[] resArray = results.stream()
                        .filter(data -> DateReformat.monthYearFormat.format(data.getDate()).equals(monthYear)).mapToInt(data -> data.getDailyFull()).toArray();
        return findSum(resArray, resArray.length);
    }// Working

    public static Integer getWeeklyLowestDatabyAdult(List<VaxState<Date,Integer>> dataset, String state, String weekYear) {
        List<VaxState<Date,Integer>> results = getStateEqualsName(dataset, state);
        if (results == null) {
                return null;
        }
        int[] resArray = results.stream()
                        .filter(data -> DateReformat.weekYearFormat.format(data.getDate()).equals(weekYear))
                        .collect(Collectors.groupingBy(VaxState::getDate)).entrySet().stream()
                        .mapToInt(map -> map.getValue().stream().mapToInt(data -> data.getDailyPartialAdult() + data.getDailyFullAdult()).sum()).toArray();
        return findLowestValue(resArray, resArray.length);
    }// Working

    public static Integer getWeeklyHighestDatabyAdult(List<VaxState<Date,Integer>> dataset, String state, String weekYear) {
        List<VaxState<Date,Integer>> results = getStateEqualsName(dataset, state);
        if (results == null) {
                return null;
        }
        int[] resArray = results.stream()
                        .filter(data -> DateReformat.weekYearFormat.format(data.getDate()).equals(weekYear))
                        .collect(Collectors.groupingBy(VaxState::getDate)).entrySet().stream()
                        .mapToInt(map -> map.getValue().stream().mapToInt(data -> data.getDailyPartialAdult() + data.getDailyFullAdult()).sum()).toArray();
        return findHighestValue(resArray, resArray.length);
    }// Working

    public static Integer getWeeklyLowestDatabyChild(List<VaxState<Date,Integer>> dataset, String state, String weekYear) {
        List<VaxState<Date,Integer>> results = getStateEqualsName(dataset, state);
        if (results == null) {
                return null;
        }
        int[] resArray = results.stream()
                        .filter(data -> DateReformat.weekYearFormat.format(data.getDate()).equals(weekYear))
                        .collect(Collectors.groupingBy(VaxState::getDate)).entrySet().stream()
                        .mapToInt(map -> map.getValue().stream().mapToInt(data -> data.getDailyPartialChild() + data.getDailyFullChild()).sum()).toArray();
        return findLowestValue(resArray, resArray.length);
     }// Working

    public static Integer getWeeklyHighestDatabyChild(List<VaxState<Date,Integer>> dataset, String state, String weekYear) {
        List<VaxState<Date,Integer>> results = getStateEqualsName(dataset, state);
        if (results == null) {
                return null;
        }
        int[] resArray = results.stream()
                        .filter(data -> DateReformat.weekYearFormat.format(data.getDate()).equals(weekYear))
                        .collect(Collectors.groupingBy(VaxState::getDate)).entrySet().stream()
                        .mapToInt(map -> map.getValue().stream().mapToInt(data -> data.getDailyPartialChild() + data.getDailyFullChild()).sum()).toArray();
        return findHighestValue(resArray, resArray.length);
     }// Working

     public static Integer getWeeklyTotalVaccinationByVaccineType(List<VaxState<Date,Integer>> dataset, String vaccinetype, String weekYear) {
        List<VaxState<Date,Integer>> results = getStateEqualsName(dataset, "Malaysia");
       if (results == null) {
           return null;
       }
       return results.stream().filter(data -> 
               DateReformat.weekYearFormat.format(data.getDate()).equals(weekYear)).mapToInt(i -> {
               if (vaccinetype.equals("pfizer1")) {
                   return i.getPhizer1();
               } else if (vaccinetype.equals("pfizer2")) {
                   return i.getPhizer2();
               } else if (vaccinetype.equals("pfizer3")) {
                   return i.getPhizer3();
               } else if (vaccinetype.equals("sinovac1")) {
                   return i.getSinovac1();
               } else if (vaccinetype.equals("sinovac2")) {
                   return i.getSinovac2();
               } else if (vaccinetype.equals("sinovac3")) {
                   return i.getSinovac3();
               } else if (vaccinetype.equals("astra1")) {
                   return i.getAstra1();
               } else if (vaccinetype.equals("astra2")) {
                   return i.getAstra2();
               } else if (vaccinetype.equals("astra3")) {
                   return i.getAstra3();
               } else if (vaccinetype.equals("sinopharm1")) {
                   return i.getSinopharm1();
               } else if (vaccinetype.equals("sinopharm2")) {
                   return i.getSinopharm2();
               } else if (vaccinetype.equals("sinopharm3")) {
                   return i.getSinopharm3();
               } else if (vaccinetype.equals("cansino")) {
                   return i.getCansino();
               } else if (vaccinetype.equals("cansino3")) {
                   return i.getCansino3();
               } else if (vaccinetype.equals("pending1")) {
                   return i.getPending1();
               } else if (vaccinetype.equals("pending2")) {
                   return i.getPending2();
               } else if (vaccinetype.equals("pending3")) {
                   return i.getPending3();
               }
                return 0; 
           })
       .sum();
     }// Working
     
     public static Integer getTotalRegistrationbyState(List<VaxRegistration<Date,String,Integer>> dataset, String state) {
        List<VaxRegistration<Date,String,Integer>> results = getStateEqualsNameReg(dataset, state);
        if (results == null) {
            return null;
        }
        return results.stream().mapToInt(data -> data.getTotal()).sum();
     }

     // Currying Technique
     private static final Function<Integer, Function<Integer, Integer>> findMin = x -> (y -> ((x > y) ? y : x));
     private static final Function<Integer, Function<Integer, Integer>> findMax = x -> (y -> ((x > y) ? x : y));

     private static final Calculation<Integer, Integer> calculation = new CalculationImp();

     private static Integer findSum(int[] data, int count) {
        if (count <= 0) {
            return 0;
        }
        return calculation.add(findSum(data, count - 1), data[count - 1]);
     }

    // Tail Recursion
    private static Integer findHighestValue(int[] data, int count) {
        if (count == 1) {
            return data[0];
        }

        return findMax.apply(data[count - 1]).apply(findHighestValue(data, count - 1));
    }

    private static Integer findLowestValue(int[] data, int count) {
        if (count == 1) {
            return data[0];
        }

        return findMin.apply(data[count - 1]).apply(findLowestValue(data, count - 1));
    }
}

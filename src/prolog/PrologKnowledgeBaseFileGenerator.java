package prolog;

import classes.VaxRegistration;
import dataset.env;
import function.FunctionalUtil;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrologKnowledgeBaseFileGenerator {
    
    public static void createKnowledgebaseFile(List<VaxRegistration<Date, String, Integer>> dataset) throws FileNotFoundException {
        PrintWriter plFile = new PrintWriter("VaccineRegistrationKnowledgebaseFile.pl");
        System.out.println("Knowledgebase File created");
        // Generate Facts
        plFile.println("% Facts");
        
        getStateTotalRegistration(dataset, new LinkedHashMap<String, Integer>(), 0).forEach((state, totalregistration) -> {
            String newformatstate = state.toLowerCase().replace(" ", "_").replaceAll("[^A-Za-z0-9_]", "");
            plFile.println("total_registration(" + newformatstate + ", " + totalregistration + ").");
        });

        // Generate Rules
        plFile.println("");
        plFile.println("% Rules");
        plFile.println("merge_cases_to_list(List) :- findall((StateName, Registration), total_registration(StateName, Registration), List).");
        plFile.println("");
        plFile.println("ascending_pivot(_, [], [], []).");
        plFile.println("ascending_pivot((Pivot1, Pivot2), [(Head1, Head2)|Tail], [(Head1, Head2)|List1], List2) :- Pivot2 > Head2, ascending_pivot((Pivot1, Pivot2), Tail, List1, List2).");
        plFile.println("ascending_pivot((Pivot1, Pivot2), [(Head1, Head2)|Tail], List1, [(Head1, Head2)|List2]) :- ascending_pivot((Pivot1, Pivot2), Tail, List1, List2).");
        plFile.println("");
        plFile.println("ascending_quicksort([], []).");
        plFile.println("ascending_quicksort([(Head1, Head2)|Tail], Result) :- ascending_pivot((Head1, Head2), Tail, List1, List2), "
                + "ascending_quicksort(List1, SortedList1), ascending_quicksort(List2, SortedList2), "
                + "append(SortedList1, [(Head1, Head2)|SortedList2], Result).");
        plFile.println("");
        plFile.println("descending_pivot(_, [], [], []).");
        plFile.println("descending_pivot((Pivot1, Pivot2), [(Head1, Head2)|Tail], [(Head1, Head2)|List1], List2) :- Pivot2 < Head2, descending_pivot((Pivot1, Pivot2), Tail, List1, List2).");
        plFile.println("descending_pivot((Pivot1, Pivot2), [(Head1, Head2)|Tail], List1, [(Head1, Head2)|List2]) :- descending_pivot((Pivot1, Pivot2), Tail, List1, List2).");
        plFile.println("");
        plFile.println("descending_quicksort([], []).");
        plFile.println("descending_quicksort([(Head1, Head2)|Tail], Result) :- descending_pivot((Head1, Head2), Tail, List1, List2), "
                + "descending_quicksort(List1, SortedList1), descending_quicksort(List2, SortedList2), "
                + "append(SortedList1, [(Head1, Head2)|SortedList2], Result).");
        plFile.println("");
        plFile.println("printlist([]).");
        plFile.println("printlist([Head|Tail]) :- write(Head), nl, printlist(Tail).");
        plFile.println("");
        plFile.println("ascending_order(Result):- merge_cases_to_list(List), ascending_quicksort(List, Result), printlist(Result).");
        plFile.println("descending_order(Result):- merge_cases_to_list(List), descending_quicksort(List, Result), printlist(Result).");

        plFile.close();
    }

    private static LinkedHashMap<String, Integer> getStateTotalRegistration(List<VaxRegistration<Date, String, Integer>> dataset, LinkedHashMap<String, Integer> result, int count) {
        if (count == env.STATES.length) {
            return result;
        }

        String[] distinctstate = env.STATES.clone();
        String state = distinctstate[count];

        LinkedHashMap<String, Integer> newResult = (LinkedHashMap<String, Integer>) result.entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
        newResult.put(state, FunctionalUtil.getTotalRegistrationbyState(dataset, state));

        return getStateTotalRegistration(dataset, newResult, count + 1);
    }
}

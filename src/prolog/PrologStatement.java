package prolog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;

public class PrologStatement {
    public static final String KNOWLEDGEBASE_FILE = "VaccineRegistrationKnowledgebaseFile.pl";
    
    public static List<String> TotalRegistrationInAscendingOrder() {
        List<String> result = new ArrayList<>();
        
        String queryStatement = "ascending_order(Result).";
        Query query = new Query(queryStatement);
        Map<String, Term> solution = query.oneSolution();
        String[] arrproduct = solution.get("Result").toString().replace("','", "").replace("[(", "").replace(")]", "").split("\\), \\(");
        
        Arrays.asList(arrproduct).forEach(data -> {
            result.add(data);
        });
        return result;
    }
    
    public static List<String> TotalRegistrationInDescendingOrder() {
        List<String> result = new ArrayList<>();
        
        String queryStatement = "descending_order(Result).";
        Query query = new Query(queryStatement);
        Map<String, Term> solution = query.oneSolution();
        String[] arrproduct = solution.get("Result").toString().replace("','", "").replace("[(", "").replace(")]", "").split("\\), \\(");
        Arrays.asList(arrproduct).forEach(data -> {
            result.add(data);
        });
        return result;
    }

    public static String connectPLFile(String plFile) {
        String s = "consult('" + plFile + "')";
        Query q1 = new Query(s);
        return((q1.hasSolution() ? "Success" : "Fail") + "fully connected to " + plFile + " file.");
    }
}

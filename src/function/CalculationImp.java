package function;

public class CalculationImp implements Calculation<Integer, Integer> {

    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
    
}

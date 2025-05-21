package Guias.Guia_6.Ej_5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CompositeFunction implements Function<Double, Double> {
    private List<Function<Double, Double>> functions = new ArrayList<>();

    public void addFunction(Function<Double, Double> function) {
        functions.add(function);
    }

    public Double apply(Double x) {
        for (Function<Double, Double> function : functions) {
            x = function.apply(x);
        }
        return x;
    }

}

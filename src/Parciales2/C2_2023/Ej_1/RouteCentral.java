package Parciales2.C2_2023.Ej_1;

import Guias.Guia_5.Ej_1.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

public class RouteCentral {
    private final Map<Pair<String, String>, Integer> routes = new HashMap<>();
    private final UnaryOperator<Integer> twoWayFunction;

    public RouteCentral(UnaryOperator<Integer> twoWayFunction) {
        this.twoWayFunction = twoWayFunction;
    }

    public void addOneWayRoute(String origin, String destination, int miles) {
        if (miles < 0) throw new IllegalArgumentException();
        routes.putIfAbsent(new Pair<>(origin, destination), miles);
    }

    public void addTwoWayRoute(String origin, String destination, int miles) {
        miles = twoWayFunction.apply(miles);
        addOneWayRoute(origin, destination, miles);
        addOneWayRoute(destination, origin, miles);
    }

    public int getDirectRouteMiles(String origin, String destination) {
        Integer miles = routes.get(new Pair<>(origin, destination));
        if (miles == null) throw new NoSuchElementException("Route does not exists");
        return miles;
    }

    public int getOneStopRouteMiles(String origin, String stop, String destination) {
        return getDirectRouteMiles(origin, stop) + getDirectRouteMiles(stop, destination);
    }

    public void changeRouteCost(String origin, String destination, int miles) {
        Pair<String, String> route = new Pair<>(origin, destination);
        if (!routes.containsKey(route)) throw new NoSuchElementException("Route does not exists");
        routes.put(route, miles);
    }


}

package Parciales2.R1_2023.Ej_3;

import java.util.function.Predicate;


public class SpecialCollectionTester {
    public static void main(String[] args) {
        // Se instancia una colección ordenada sin repetidos
        // donde cada elemento es una instancia de String
        SpecialCollection<String> sCol = new SpecialCollectionImpl<>();


        // Se agrega un elemento a la colección
        System.out.println(sCol.add("hello")); // true
        System.out.println(sCol.add("world")); // true
        // No se agrega el elemento a la colección porque ya existe
        System.out.println(sCol.add("hello")); // false
        System.out.println(sCol.add("hola")); // true
        System.out.println(sCol.add("mundo")); // true


        System.out.println(sCol.isEmpty()); // false
        System.out.println(sCol.size()); // 4
        System.out.println(sCol.contains("adios")); // false


        // Se itera por todos los elementos de la colección con el orden correspondiente
        for(String s : sCol) {
            System.out.println(s);
        }
        /**
         * hello
         * hola
         * mundo
         * world
         */


        Predicate<String> sPred = (s) -> s.startsWith("h");
        // Se obtiene la cantidad de instancias de String que comiencen con la letra h,
        // contabilizando desde el primer al último elemento de la colección
        System.out.println(sCol.count(sPred)); // 2
        // Se obtiene la cantidad de instancias de String que comiencen con la letra h,
        // contabilizando únicamente los elementos mayores o iguales a "a"
        // y menores o iguales a "z"
        System.out.println(sCol.count("a", "z", sPred)); // 2
        System.out.println(sCol.count("hello", "hello", sPred)); // 1
        System.out.println(sCol.count("mundo", "zzz", sPred)); // 0
        System.out.println(sCol.count("Z", "A", sPred)); // 0


        // Se instancia una colección ordenada sin repetidos
        // donde cada elemento es una instancia de Planet
        SpecialCollection<Planet> pCol = new SpecialCollectionImpl<>();


        System.out.println(pCol.add(new Planet("Mars"))); // true
        System.out.println(pCol.add(new Planet("Earth"))); // true
        System.out.println(pCol.add(new Planet("Mars"))); // false


        // Se itera por todos los elementos de la colección con el orden correspondiente
        for(Planet p : pCol) {
            System.out.println(p);
        }
        /**
         * Earth
         * Mars
         */


        Predicate<Planet> pPred = (p) -> p.name.equals("Earth");
        // Se obtiene la cantidad de instancias de Planet que tengan nombre Earth
        // contabilizando desde el primer al último elemento de la colección
        System.out.println(pCol.count(pPred)); // 1
        // Se obtiene la cantidad de instancias de Planet que tengan nombre Earth
        // contabilizando únicamente los elementos con nombre mayores o iguales a Earth
        // y menores o iguales a Neptune
        System.out.println(pCol.count(new Planet("Earth"),new Planet("Neptune"),pPred)); // 1
        System.out.println(pCol.count(new Planet("Earth"),new Planet("Earth"),pPred)); // 1
        System.out.println(pCol.count(new Planet("Mars"),new Planet("Neptune"),pPred)); // 0
        System.out.println(pCol.count(new Planet("Neptune"),new Planet("Earth"),pPred)); // 0
    }


    static abstract class AbstractPlanet implements Comparable<AbstractPlanet> {


        public String name;


        public AbstractPlanet(String name) {
            this.name = name;
        }


        @Override
        public int compareTo(AbstractPlanet o) {
            return name.compareTo(o.name);
        }


        @Override
        public String toString() {
            return name;
        }


    }


    static class Planet extends AbstractPlanet {


        public Planet(String name) {
            super(name);
        }


    }
}



package Parciales2.R2_2024.Ej_3;

import java.util.function.BinaryOperator;

public class MysteryCollectionTester {
    public static void main(String[] args) {
        MysteryCollection<String> mC1 = new MysteryCollection<>();


        mC1.add("One"); mC1.add("Ten"); mC1.add("Dos"); mC1.add("Diez");
        mC1.add("Deux"); mC1.add("Two"); mC1.add("Ten"); mC1.add("Deux");


        System.out.println(mC1.size()); // 6
        System.out.println(mC1.contains("Diez")); // true
        System.out.println(mC1.isEmpty()); // false


        BinaryOperator<String> stringJoinFunction = (s1, s2) -> "%s <> %s".formatted(s1, s2);


// Se reduce la colección retornando un String que será el resultado de invocar
// a la función de join para cada uno de los elementos de la colección
// respetando el orden de los elementos de la colección,
// donde el caso base para la función de join (si no hay dos elementos) es el "###"
        String mC1Reduced = mC1.reduce("###", stringJoinFunction);
        System.out.println(mC1Reduced); // ### <> Deux <> Diez <> Dos <> One <> Ten <> Two


// Se reduce la colección retornando un String que será el resultado de invocar
// a la función de join para cada uno de los elementos de la colección
// respetando el orden INVERSO de los elementos de la colección,
// donde el caso base para la función de join (si no hay dos elementos) es el "@@@"
        String mC1ReduceInverse = mC1.reduceInverse("@@@", stringJoinFunction);
        System.out.println(mC1ReduceInverse); // @@@ <> Two <> Ten <> One <> Dos <> Diez <> Deux


        MysteryCollection<Double> mC2 = new MysteryCollection<>();


        mC2.add(0.5);  mC2.add(1.5); mC2.add(9.9);
        mC2.add(5.4); mC2.add(10.0); mC2.add(10.0);


        BinaryOperator<Double> doubleJoinFunction = (o1, o2) -> o1 + o2;


// El caso base para la función de join (si no hay dos elementos) es el 1.0
        Double mC2Reduced = mC2.reduce(1.0, doubleJoinFunction);
        System.out.println("%.2f".formatted(mC2Reduced)); // 28.30


// Debido a que la función de join es la suma de números
// la salida de reduce y reduceInverse coinciden si se utiliza el mismo caso base
        System.out.println("%.2f".formatted(mC2.reduceInverse(1.0, doubleJoinFunction))); // 28.30


// Invocar a reduce o reduceInverse sobre una colección vacía retorna el caso base
        System.out.println(new MysteryCollection<String>().reduce("foo", null)); // foo
        System.out.println(new MysteryCollection<String>().reduceInverse("foo", null)); // foo


    }
}

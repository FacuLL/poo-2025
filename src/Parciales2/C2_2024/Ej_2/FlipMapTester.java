package Parciales2.C2_2024.Ej_2;

import java.util.Map;
import java.util.function.BinaryOperator;

public class FlipMapTester {

    public static void main(String[] args) {
        // Se instancia un mapa M1 de clave String y valor Integer que puede ser "flippeado"
        FlipMap<String, Integer> m1 = new FlipMap<>();


        m1.put("One", 1); m1.put("Ten", 10); m1.put("Dos", 2); m1.put("Diez", 10);
        m1.put("Deux", 2); m1.put("Two", 2);


        System.out.println(m1.size()); // 6
        System.out.println(m1.containsKey("Diez")); // true
        System.out.println(m1.containsValue(10)); // true


        BinaryOperator<String> joinFunction = new BinaryOperator<String>() {
            @Override
            public String apply(String s1, String s2) {
                return "%s <> %s".formatted(s1, s2);
            }
        };
// Se invoca a flip sobre M1 retornando un mapa M2 de clave Integer y valor String
// que es el "flip" de M1, donde cada valor de M1 aparece como clave en M2
// asociado a un valor que será el resultado de invocar a la función de join
// para cada uno de los valores en M1 respetando el orden de las claves de M1
// donde el caso base para la función de join (si no hay dos elementos) es el "###"
        Map<Integer, String> m2 = m1.flip("###", joinFunction);


// En M1 hay un solo valor "1" así que sólo se invoca a la función de join una vez
        System.out.println(m2.get(1)); // ### <> One
// En M1 hay tres valores "2" así que se invoca a la función de join tres veces,
// respetando el orden de las claves de M1
        System.out.println(m2.get(2)); // ### <> Deux <> Dos <> Two
        System.out.println(m2.get(10)); // ### <> Diez <> Ten


// Se invoca a flipInverse sobre M1 retornando un mapa M3 de clave Integer y valor String
// que es el "flip" de M1, donde cada valor de M1 aparece como clave en M3
// asociado a un valor que será el resultado de invocar a la función de join
// para cada uno de los valores en M1 respetando el orden INVERSO de las claves de M1
// donde el caso base para la función de join (si no hay dos elementos) es el "@@@"
        Map<Integer, String> m3 = m1.flipInverse("@@@", joinFunction);


// En M1 hay un solo valor "1" así sólo se invoca a la función de join una vez
        System.out.println(m3.get(1)); // @@@ <> One
// En M1 hay tres valores "2" así que se invoca a la función de join tres veces,
// respetando el orden INVERSO de las claves de M1
        System.out.println(m3.get(2)); // @@@ <> Two <> Dos <> Deux
        System.out.println(m3.get(10)); // @@@ <> Ten <> Diez


// Se instancia un mapa M4 de clave Double y valor String que puede ser "flippeado"
        FlipMap<Double, String> m4 = new FlipMap<>();
        m4.put(0.5, "Low"); m4.put(1.5, "Low"); m4.put(9.9, "High");
        m4.put(5.4, "Medium"); m4.put(10.0, "High");


// El caso base para la función de join (si no hay dos elementos) es el 1.0
        Map<String, Double> m5 = m4.flip(1.0, (o1, o2) -> o1 + o2);


        System.out.println(m5.get("Low")); // 3.0
        System.out.println(m5.get("Medium")); // 6.4
        System.out.println(m5.get("High")); // 20.9


// Debido a que la función de join es la suma de números
// la salida de flip y flipInverse coinciden mientras se utilice el mismo caso base
        System.out.println(m5.equals(m4.flipInverse(1.0, (o1, o2) -> o1 + o2))); // true


    }
}

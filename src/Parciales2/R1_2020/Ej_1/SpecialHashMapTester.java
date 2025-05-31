package Parciales2.R1_2020.Ej_1;

public class SpecialHashMapTester {

    public static void main(String[] args) {
        SpecialMap<Integer, String> sm1 = new SpecialHashMap<>();

        sm1.put(1, "Uno");
        sm1.put(2, "Dos");
        sm1.put(3, "Tres");
        sm1.put(5, "Cinco");

        System.out.println(sm1.containsKey(1)); // Imprime true
        System.out.println(sm1.containsValue("Cuatro")); // Imprime false
        System.out.println(sm1.size()); // Imprime 4

        SpecialMap<Integer, String> sm2 = sm1.convert(key -> key * 10, value -> value.toUpperCase());

        System.out.println(sm2.get(10)); // Imprime UNO
        System.out.println(sm2.get(20)); // Imprime DOS
        System.out.println(sm2.get(30)); // Imprime TRES
        System.out.println(sm2.get(50)); // Imprime CINCO
        System.out.println(sm2.size()); // Imprime 4

        SpecialMap<Integer, String> sm3 = sm1.convert(key -> key % 2, value -> value);

        System.out.println(sm3.get(0)); // Imprime Dos
        System.out.println(sm3.get(1)); // Puede imprimir Uno, Tres o Cinco
        System.out.println(sm3.size()); // Imprime 2
    }

}


package Parciales2.R2_2020.Ej_1;

public class BucketTester {

    public static void main(String[] args) {
        /**
         * Ejemplo 1: Bucket que agrupará los elementos ingresados (instancias
         * de Integer) en función de los identificadores "Even" y "Odd"
         * según si los elementos son par o impar.
         */
        BucketsCollection<Integer, String> parity =
                new BucketsCollection<>((n) -> (n % 2 == 0 ? "Even" : "Odd"));
        parity.add(3).add(2).add(1).add(4);

        for(String bucketId : parity.bucketIds()) { // Identificadores en orden descendente
            System.out.println(bucketId); // Imprime Odd Even
        }

        for(Integer element : parity.elements("Even")) { // Elementos en orden de inserción
            System.out.println(element); // Imprime 2 4
        }

        for(Integer element : parity.elements("Odd")) {
            System.out.println(element); // Imprime 3 1
        }

        /**
         * Ejemplo 2: Bucket que agrupará los elementos ingresados
         * (Instancias de String) en función de la longitud.
         */
        BucketsCollection<String, Integer> numberOfLetters =
                new BucketsCollection<>((s) -> s.length());
        numberOfLetters.add("One").add("Two").add("Three").add("Four");

        for(Integer bucketId : numberOfLetters.bucketIds()) {
            System.out.println(bucketId); // Imprime 5 4 3
        }

        for(String element : numberOfLetters.elements(3)) {
            System.out.println(element); // Imprime One Two
        }

        for(String element : numberOfLetters.elements(4)) {
            System.out.println(element); // Imprime Four
        }

        for(String element : numberOfLetters.elements(5)) {
            System.out.println(element);  // Imprime Three
        }

        /**
         * Ejemplo 3: Bucket vacío.
         */
        BucketsCollection<Double, String> emptyBucket =
                new BucketsCollection<>((d) -> String.valueOf(d));

        System.out.println(emptyBucket.bucketIds().isEmpty()); // Imprime true
        System.out.println(emptyBucket.elements("Hello").isEmpty()); // Imprime true
    }

}

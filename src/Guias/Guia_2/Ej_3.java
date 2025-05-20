package Guias.Guia_2;

public class Ej_3 {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(String.join("-", arg.split("")));
        }
    }
}

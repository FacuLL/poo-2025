package Guias.Guia_2;

public class Ej_5 {
    public static void main(String[] args) {
        CharSequence[] frase = String.join("", args).toLowerCase().split("");
        for (int i = 0; i < (frase.length / 2); i++) {
            if (!frase[i].equals(frase[frase.length-i-1])) {
                System.out.println("NO ES PALINDROMO");
                return;
            }
        }
        System.out.println("ES PALINDROMO");
    }
}

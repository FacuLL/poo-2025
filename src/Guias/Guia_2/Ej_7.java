package Guias.Guia_2;

import java.util.Arrays;

public class Ej_7 {
    private static int max(int[] values) {
        if (values.length < 1) throw new IllegalArgumentException();
        int result = values[0];
        for (int value: values) {
            if (value > result) result = value;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] apparitions = new int[10];
        for (String arg: args) {
            int value = Integer.parseInt(arg);
            apparitions[value/10]++;
        }
        int max = Ej_7.max(apparitions);
        for (int i = max; i > 0; i--) {
            for (int apparition : apparitions) {
                System.out.printf("| %c ", i <= apparition ? '*' : ' ');
            }
            System.out.print("|\n");
        }
        for (int i = 0; i < apparitions.length; i++) {
            System.out.printf("%d  ", i*10);
        }
    }
}

package es.uvigo.esei.aed1.activity0.exercise16;

import java.util.Scanner;

public class Activity0Exercise16 {

    private static final Scanner input = new Scanner(System.in);

    //exercise 16

    /**
     * Calcula el maximo de los enteros almacenados en el array
     *
     * @param array contiene los enteros
     * @return el valor maximo
     */
    public static int maximum(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Calcula el mínimo de los enteros almacenados en el array
     *
     * @param array contiene los enteros
     * @return el valor mínimo
     */
    public static int minimum(int[] array) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Calcula el promedio de los enteros almacenados en el array
     *
     * @param array contiene los enteros
     * @return el valor promedio
     */
    public static double average(int[] array) {
        int sumaTotal = 0;

        for (int i = 0; i < array.length; i++) {
            sumaTotal += array[i];
        }

        return (double) sumaTotal / array.length;
    }

    public static int readInteger(String message) {
        System.out.print(message);
        return input.nextInt();
    }

    /**
     * almacena enteros en el array haciendo uso del método readInteger
     *
     * @param array que almacenará los enteros
     */
    public static void readArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Introduzca el valor de la posición")
                    .append(" ").append(i).append(": ");
            array[i] = readInteger(sb.toString());
        }
    }

}

package es.uvigo.esei.aed1.activity0.exercise17;

import java.util.Locale;
import java.util.Scanner;

public class Activity0Exercise17 {

    private static final Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);

    //exercise 17
    /**
     * muestra un mensaje por pantalla y lee un número entero de teclado
     *
     * @param message el mensaje a visualizar
     * @return el número entero leido de teclado
     */
    public static int readNumber(String message) {
        System.out.print(message);
        return input.nextInt();
    }

    /**
     * muestra un mensaje por pantalla y lee un número real de teclado
     *
     * @param message el mensaje a visualizar
     * @return el número real leido de teclado
     */
    public static double readDouble(String message) {
        System.out.print(message);
        return input.nextDouble();
    }

    /**
     * muestra un mensaje por pantalla y lee una matriz de números reales
     *
     * @param matrix que almacena números reales
     * @param message el mensaje a visualizar
     */
    public static void readNotes(double[][] matrix, String message) {
        System.out.println(message);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("------ " + "Notas del alumno " + (i + 1) + " ------");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = readDouble("Nota " + (j + 1) + " del alumno: ");
            }
            System.out.println("------ " + "Fin de las notas del alumno " + (i + 1) + " ------");
            System.out.println();
        }
    }

    /**
     * muestra por pantalla un mensaje y el contenido de una matriz de números
     * reales
     *
     * @param matrix que almacena numeros reales
     * @param message el mensaje a visualizar
     */
    public static void printNotes(double[][] matrix, String message) {
        System.out.println(message);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("------ " + "Notas del alumno " + (i + 1) + " ------");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Nota " + (j + 1) + ": " + matrix[i][j]);
            }
            System.out.println("------ " + "Fin de las notas del alumno" + (i + 1) + " ------");
        }
    }
}

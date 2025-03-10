package es.uvigo.esei.aed1.activity10;

public class SortAlgorithms {

    //Exercise 1
    public static void bubbleSort2(int[] aux) {

    }

    // Exercise 2
    public static void shellSort(int[] aux) {

    }

    // Exercise 3
//Produce: el dígito de número, que está en la posición pasada. 
//Para un numero de tres dígitos, pasada tomará los valores 0, 1 y 2, 
//devolviendo las unidades, decenas o centenas respectivamente.
    private static int index(int number, int iteration) {
        return (number / ((int) Math.pow(10, iteration))) % 10;
    }

    public static void radixSort(int[] numbers) {


    }

    // Exercise 4
    public static void selectionSort(int[] aux) {

    }

    //Exercise 5
    public static void countSortDec(int[] aux) {

    }

    // Exercise 6
    public static void beadSort(int[] aux) {

    }

    // Exercise 7
    private static int searchPositionPivot(int[] aux, int beginning, int fin) {
        int first = aux[beginning];
        int k = beginning + 1;

        while (k <= fin) {
            if (aux[k] > first) {
                return k;
            } else if (aux[k] < first) {
                return beginning;
            } else {
                k++;
            }
        }
        //Si llega al final del array y todos los elementos son iguales, o si sólo hay un elemento
        return -1;
    }

    private static void exchange(int[] aux, int i, int j) {
        if (i != j) {
            int temp = aux[i];
            aux[i] = aux[j];
            aux[j] = temp;
        }
    }

    private static int partition(int[] aux, int beginning, int fin, int pivot) {
        int right = beginning;
        int left = fin - 1; // pivote está en la última posición
        do {
            while (aux[right] < pivot) {
                right++;
            }
            while (aux[left] >= pivot) {
                left--;
            }
            // intercambia los valores de las posiciones derecha e izquierda
            if (right < left) {
                exchange(aux, right, left);
            }
        } while (right <= left);

        return right; //primera posición de la segunda mitad
    }

    public static void quickSort(int[] aux, int beginning, int fin) {

    }
}

package es.uvigo.esei.aed1.activity10;

import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

import java.util.ArrayList;
import java.util.List;

public class SortAlgorithms {

    //Exercise 1
    public static void bubbleSort2(int[] aux) {

    }

    // Exercise 2
    public static void shellSort(int[] aux) {

    }

    // Exercise 3
    //Produce: el dígito de número, que está en la posición pasada.
    //Para un número de tres dígitos, pasada tomará los valores 0, 1 y 2,
    //devolviendo las unidades, decenas o centenas respectivamente.
    private static int index(int number, int iteration) {
        return (number / ((int) Math.pow(10, iteration))) % 10;
    }

    public static void radixSort(int[] numbers) {

        Queue<Integer>[] queues = new Queue[10];

        for (int i = 0; i < 10; i++) {
            queues[i] = new LinkedQueue<>();
        }

        for (int i = 0; i < 3; i++) {

            for (int number : numbers) {
                int actualDigit = index(number, i);

                queues[actualDigit].add(number);
            }

            int index = 0;
            for(Queue<Integer> actualQueue : queues) {
                while(!actualQueue.isEmpty()) {
                    numbers[index++] = actualQueue.remove();
                }
            }
        }

    }

    public static void radixSortList(int[] numbers) {

        List<Queue<Integer>> queues = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            queues.add(new LinkedQueue<>());
        }

        for (int i = 0; i < 3; i++) {

            for (int number : numbers) {
                int actualDigit = index(number, i);

                queues.get(actualDigit).add(number);
            }

            int index = 0;
            for (Queue<Integer> actualQueue : queues) {
                while (!actualQueue.isEmpty()) {
                    numbers[index++] = actualQueue.remove();
                }
            }

        }

    }

    // Exercise 4
    public static void selectionSort(int[] aux) {
        int higherPos;

        for (int i = 0; i < aux.length; i++) {
            higherPos = i;
            for (int j = i +1; j < aux.length; j++) {
                if(aux[higherPos] < aux[j]) {
                    higherPos = j;
                }
            }

            if(i != higherPos) {
                int temp = aux[i];
                aux[i] = aux[higherPos];
                aux[higherPos] = temp;
            }
        }
    }

    //Exercise 5
    public static void countSortDec(int[] aux) {

    }

    // Exercise 6
    public static void beadSort(int[] aux) {
        List<List<Character>> abaco = new ArrayList<>();
        int highestNumber = Integer.MIN_VALUE;

        for (int j : aux) {
            if (j > highestNumber) {
                highestNumber = j;
            }
        }

        for (int i = 0; i < highestNumber; i++) {
            abaco.add(new ArrayList<>());
        }

        for(int number : aux) {
            for (int i = number - 1; i >= 0; i--) {
                abaco.get(i).add('*');
            }
        }

        for (int i = 0; i < aux.length; i++) {
            int counter = 0;
            while(counter < abaco.size() && !abaco.get(counter).isEmpty()) {
                abaco.get(counter).removeFirst();
                counter++;
            }
            aux[i] = counter;
        }

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
        //Si llega al final del array y todos los elementos son iguales, o si solo hay un elemento
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

package es.uvigo.esei.aed1.activity10;

import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

import java.util.ArrayList;
import java.util.List;

public class SortAlgorithms {

    //Exercise 1
    public static void bubbleSort2(int[] aux) {
        boolean swapped;            // Indicar si se ha hecho un intercambio
        int start = 0;              // Indicar el inicio del recorrido
        int end = aux.length - 1;   // Indicar el final del recorrido (índice al que se llega)
        // El "-1" es para poder acceder al elemento siguiente sin que tengamos IooBE
        // (IndexOutOfBoundsException)

        do {
            swapped = false;

            // Mover el elemento más grande hacia el final
            for (int i = start; i < end; i++) { // Se tiene en cuenta usando "start" y "end" que ya hay algunos elementos
                // ordenados, reduciendo el número de iteraciones
                int next = i + 1;
                if (aux[i] > aux[next]) { //Si el elemento actual es mayor al siguiente, se intercambian
                    int temp = aux[i];

                    aux[i] = aux[next];
                    aux[next] = temp;

                    swapped = true; // Se ha hecho un intercambio
                }
            }
            end--;  // Se reduce el número de iteraciones, ya que acabamos de ordenar el número en la posición "i"
            // a su posición correcta (en el sentido de la ordenación)

            // Mover el elemento más pequeño hacia el inicio
            for (int i = end; i > start; i--) {
                int prev = i - 1;
                if (aux[i] < aux[prev]) { //Si el elemento actual es menor al anterior, se intercambian
                    int temp = aux[i];

                    aux[i] = aux[prev];
                    aux[prev] = temp;

                    swapped = true; // Se ha hecho un intercambio
                }
            }
            start++; // Se reduce el número de iteraciones, ya que acabamos de ordenar
        } while (swapped);
    }

    // Exercise 2
    public static void shellSort(int[] aux) {
        int distancia = aux.length >> 1;
        int temp;

        while (distancia > 0) {
            for (int i = distancia; i < aux.length; i++) {
                int anterior = i - distancia;

                while (anterior >= 0 && aux[anterior] > aux[anterior + distancia]) {
                    temp = aux[anterior + distancia];
                    aux[anterior + distancia] = aux[anterior];
                    aux[anterior] = temp;
                    anterior -= distancia;
                }

            }
            distancia = distancia >> 1;
        }
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
            for (Queue<Integer> actualQueue : queues) {
                while (!actualQueue.isEmpty()) {
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
            for (int j = i + 1; j < aux.length; j++) {
                if (aux[higherPos] < aux[j]) {
                    higherPos = j;
                }
            }

            if (i != higherPos) {
                int temp = aux[i];
                aux[i] = aux[higherPos];
                aux[higherPos] = temp;
            }
        }
    }

    //Exercise 5
    //No repeated elements.
    public static void countSortDec(int[] aux) {
        int[] cont = new int[aux.length];
        int[] temp = new int[aux.length];
        for (int i = 0; i < aux.length; i++) {

            for (int k : aux) {
                if (aux[i] < k) {
                    cont[i]++;
                }
            }

            temp[cont[i]] = aux[i];
        }

        //Modificar aux según el array cont. Es un mapa con la relacion número-"cantidad de mayores" de forma decreciente
        for (int i = 0; i < aux.length; i++) {
            aux[cont[i]] = aux[i];
        }

        System.arraycopy(temp, 0, aux, 0, aux.length);
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

        for (int number : aux) {
            for (int i = number - 1; i >= 0; i--) {
                abaco.get(i).add('*');
            }
        }

        for (int i = 0; i < aux.length; i++) {
            int counter = 0;
            while (counter < abaco.size() && !abaco.get(counter).isEmpty()) {
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
        if (beginning < fin) {
            int pivotIndex = searchPositionPivot(aux, beginning, fin);
            if (pivotIndex != -1) {
                int pivot = aux[pivotIndex];
                exchange(aux, pivotIndex, fin);

                int partition = partition(aux, beginning, fin, pivot);
                exchange(aux, partition, fin);

                quickSort(aux, beginning, partition - 1);
                quickSort(aux, partition + 1, fin);
            }
        }
    }
}

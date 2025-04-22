package es.uvigo.esei.aed1.activity6;

import es.uvigo.esei.aed1.activity6.implementation.CustomQueue;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class Activity6 {

    //Exercise 1.1
    public static <T> void concat(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {
        if (queue1 == null || queue2 == null) {
            throw new NullPointerException("One of the queues is null");
        }

        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
    }

    public static <T> Queue<T> mix(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {
        if (queue1 == null || queue2 == null) {
            throw new NullPointerException("One of the queues is null");
        }

        Queue<T> result = new LinkedQueue<>();

        // Mientras alguna de las colas tenga elementos
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // Si queue2 tiene elementos, los añadimos
            if (!queue2.isEmpty()) {
                result.add(queue2.remove());
            }

            // Si queue1 tiene elementos, los añadimos
            if (!queue1.isEmpty()) {
                result.add(queue1.remove());
            }
        }

        return result;
    }

    //Exercise 2
    public static <T> Queue<T> copy(Queue<T> queue) throws NullPointerException {
        if (queue == null) {
            throw new NullPointerException("The queue is null");
        }

        Queue<T> copyQueue = new LinkedQueue<>();
        Queue<T> tempQueue = new LinkedQueue<>();

        while (!queue.isEmpty()) {
            T value = queue.remove();
            copyQueue.add(value);
            tempQueue.add(value);
        }

        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.remove());
        }

        return copyQueue;
    }

    //Exercise 3

    /**
     * Mezcla dos colas de enteros en orden, eliminando duplicados consecutivos.
     *
     * @param queue1 la primera cola de enteros
     * @param queue2 la segunda cola de enteros
     * @return una nueva cola que contiene los elementos de ambas colas en orden, sin duplicados consecutivos
     * @throws NullPointerException si alguna de las colas es null
     */
    public static Queue<Integer> mixInOrderly(Queue<Integer> queue1, Queue<Integer> queue2) throws NullPointerException {
        if (queue1 == null || queue2 == null) {
            throw new NullPointerException("One of the queues is null");
        }

        Queue<Integer> result = new LinkedQueue<>();
        Queue<Integer> tempQueue1 = copy(queue1);
        Queue<Integer> tempQueue2 = copy(queue2);

        Integer lastAdded = null;

        while (!tempQueue1.isEmpty() && !tempQueue2.isEmpty()) {
            Integer value1 = tempQueue1.first();
            Integer value2 = tempQueue2.first();

            if (value1.equals(value2)) { // both are equal
                if (!value1.equals(lastAdded)) {
                    result.add(value1);
                    lastAdded = value1;
                }
                tempQueue1.remove();
                tempQueue2.remove();
            } else if (value1 < value2) { // value1 is smaller
                if (!value1.equals(lastAdded)) {
                    result.add(value1);
                    lastAdded = value1;
                }
                tempQueue1.remove();
            } else { // value2 is smaller
                if (!value2.equals(lastAdded)) {
                    result.add(value2);
                    lastAdded = value2;
                }
                tempQueue2.remove();
            }
        }

        while (!tempQueue1.isEmpty()) { // add remaining elements from queue1
            Integer value = tempQueue1.remove();
            if (!value.equals(lastAdded)) {
                result.add(value);
                lastAdded = value;
            }
        }

        while (!tempQueue2.isEmpty()) { // add remaining elements from queue2
            Integer value = tempQueue2.remove();
            if (!value.equals(lastAdded)) {
                result.add(value);
                lastAdded = value;
            }
        }

        return result;
    }

    //Exercise 4

    /**
     * Mueve un elemento específico al frente de la cola.
     *
     * @param queue la cola de la que se moverá el elemento
     * @param value el valor que se moverá al frente de la cola
     * @throws NullPointerException si la cola o el valor son null
     */
    public static <T> void moveToFront(Queue<T> queue, T value) throws NullPointerException {
        if (queue == null || value == null) {
            throw new NullPointerException("The queue or value is null");
        }

        Queue<T> tempQueue = new LinkedQueue<>();
        boolean found = false;

        // Recorre la cola y mueve los elementos a una cola temporal, excepto el valor especificado
        while (!queue.isEmpty()) {
            T currentValue = queue.remove();
            if (currentValue.equals(value)) {
                found = true;
            } else {
                tempQueue.add(currentValue);
            }
        }

        // Si se encontró el valor, se agrega al frente de la cola original
        if (found) {
            queue.add(value);
        }

        // Mueve los elementos de la cola temporal de vuelta a la cola original
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.remove());
        }
    }

    //Exercise 5

    /**
     * Resuelve el problema de Josephus para una cola de soldados.
     *
     * @param soldiers   la cola de soldados representados por enteros
     * @param initialPos la posición inicial desde donde se comienza a contar
     * @param jump       el número de saltos entre eliminaciones
     * @return el último soldado restante en la cola
     * @throws IllegalArgumentException si la cola de soldados es null, la posición inicial es negativa o el número de saltos es menor que 1
     */
    public static Integer josephus(Queue<Integer> soldiers, int initialPos, int jump) {
        if (soldiers == null || initialPos < 0 || jump < 1) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        // Mover los soldados hasta la posición inicial
        for (int i = 0; i < initialPos; i++) {
            soldiers.add(soldiers.remove());
        }

        while (soldiers.size() > 1) {
            for (int i = 0; i < jump - 1; i++) {
                soldiers.add(soldiers.remove());
            }
            soldiers.remove();
        }

        return soldiers.first();
    }

    //Ejercicio 6

    /**
     * Verifica si todos los elementos de la cola son iguales al primer elemento.
     *
     * @param queue la cola de la que se verificarán los elementos
     * @return true si todos los elementos de la cola son iguales al primer elemento, false en caso contrario
     * @throws NullPointerException si la cola es null
     */
    public static <T> boolean equalsValues(CustomQueue<T> queue) throws NullPointerException {
        if (queue == null) {
            throw new NullPointerException("The queue is null");
        }

        if (queue.isEmpty()) {
            return true;
        }

        boolean equals = true;

        T firstValue = queue.first();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            T value = queue.remove();
            if (!value.equals(firstValue)) {
                equals = false;
            }
            queue.add(value);
        }

        return equals;
    }

}
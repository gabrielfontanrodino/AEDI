package es.uvigo.esei.aed1.activity2.linkedWith2References;

import es.uvigo.esei.aed1.commonLinked.Node;

/**
 * Clase que representa una lista enlazada con referencias al primer y último nodo.
 */
public class LinkedWith2References {

    private Node first, last;
    private int elementsCount;

    /**
     * Constructor que inicializa una lista enlazada vacía.
     */
    public LinkedWith2References() {
        this.first = null;
        this.last = null;
        this.elementsCount = 0;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return (first == null && last == null && elementsCount == 0);
    }

    /**
     * Devuelve el tamaño de la lista.
     *
     * @return el número de elementos en la lista
     */
    public int size() {
        return this.elementsCount;
    }

    /**
     * Cuenta el número de ocurrencias de un valor en la lista.
     *
     * @param value el valor a buscar
     * @return el número de ocurrencias del valor en la lista
     */
    public int numberOfOccurrences(int value) {
        int ammount = 0;
        for (Node current = this.first; current != null; current = current.getNext()) {
            if (current.hasValue(value)) {
                ammount++;
            }
        }
        return ammount;
    }

    /**
     * Verifica si un valor está contenido en la lista.
     *
     * @param value el valor a buscar
     * @return true si el valor se encuentra en la lista, false en caso contrario
     */
    public boolean contains(int value) {
        Node current = this.first;
        while (current != null && !current.hasValue(value)) {
            current = current.getNext();
        }
        return current != null;
    }

    /**
     * Añade un nuevo valor al inicio de la lista.
     *
     * @param value el valor a añadir
     */
    public void addFirst(int value) {
        Node newNode = new Node(value, this.first);
        this.first = newNode;
        if (this.elementsCount == 0) {
            this.last = newNode;
        }
        this.elementsCount++;
    }

    /**
     * Añade un nuevo valor al final de la lista.
     *
     * @param value el valor a añadir
     */
    public void addLast(int value) {
        if (this.isEmpty()) {
            this.addFirst(value);
        } else {
            Node newNode = new Node(value, null);
            this.last.setNext(newNode);
            this.last = newNode;
            this.elementsCount++;
        }
    }

    /**
     * Elimina un valor de la lista.
     *
     * @param value el valor a eliminar
     * @throws IllegalAccessException si la lista está vacía o el valor no se encuentra en la lista
     */
    public void remove(int value) throws IllegalAccessException {
        if (this.isEmpty()) {
            throw new IllegalAccessException("La estructura está vacía. No se pueden eliminar valores.");
        }

        if (this.first.hasValue(value)) {
            this.first = this.first.getNext();
            if (this.first == null) {
                this.last = null;
            }
        } else {
            Node current = this.first;
            while (current.getNext() != null && !current.getNext().hasValue(value)) {
                current = current.getNext();
            }

            if (current.getNext() == null) {
                throw new IllegalAccessException("Valor no encontrado en la estructura.");
            }

            current.setNext(current.getNext().getNext());
            if (current.getNext() == null) {
                this.last = current;
            }
        }
        this.elementsCount--;
    }

    /**
     * Devuelve una representación en cadena de la lista.
     *
     * @return una cadena con todos los valores de la lista
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Node current = this.first; current != null; current = current.getNext()) {
            sb.append(current.getValue()).append(" ");
        }

        return sb.toString();
    }
}
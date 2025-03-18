package es.uvigo.esei.aed1.activity3.doublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

/**
 * Clase que representa una lista doblemente enlazada con un nodo ficticio al inicio y al final.
 */
public class DoublyLinkedDummy {

    private final DoubleNode first;
    private final DoubleNode last;
    private int elementsCount;

    /**
     * Constructor que inicializa la lista con nodos ficticios al inicio y al final.
     */
    public DoublyLinkedDummy() {
        this.first = new DoubleNode(null, -0, null);
        this.last = new DoubleNode(this.first, -0, null);
        this.first.setNext(this.last);
        this.elementsCount = 0;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return this.elementsCount == 0;
    }

    /**
     * Devuelve el número de elementos en la lista.
     *
     * @return el número de elementos en la lista.
     */
    public int size() {
        return this.elementsCount;
    }

    /**
     * Cuenta el número de ocurrencias de un valor en la lista.
     *
     * @param value el valor a buscar.
     * @return el número de ocurrencias del valor en la lista.
     */
    public int numberOfOccurrences(int value) {
        int count = 0;

        for (DoubleNode current = this.first.getNext(); current != this.last; current = current.getNext()) {
            if (current.hasValue(value)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Verifica si un valor está presente en la lista.
     *
     * @param value el valor a buscar.
     * @return true si el valor está presente en la lista, false en caso contrario.
     */
    public boolean contains(int value) {
        DoubleNode current = this.first;
        while (current != this.last && !current.hasValue(value)) {
            current = current.getNext();
        }

        return current.hasValue(value);
    }

    /**
     * Añade un valor al inicio de la lista.
     *
     * @param value el valor a añadir.
     */
    public void addFirst(int value) {
        DoubleNode newNode = new DoubleNode(this.first, value, this.first.getNext());
        this.first.setNext(newNode);
        newNode.getNext().setPrevious(newNode);
        this.elementsCount++;
    }

    /**
     * Añade un valor al final de la lista.
     *
     * @param value el valor a añadir.
     */
    public void addLast(int value) {
        DoubleNode newNode = new DoubleNode(this.last.getPrevious(), value, this.last);
        newNode.getPrevious().setNext(newNode); // this.last.getPrevious().setNext(newNode);
        this.last.setPrevious(newNode);
        this.elementsCount++;
    }

    /**
     * Elimina el primer nodo que contiene el valor especificado de la lista.
     *
     * @param value el valor a eliminar de la lista.
     */
    public void remove(int value) {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            DoubleNode current = this.first.getNext();
            while (current.getNext() != null && !current.hasValue(value)) {
                current = current.getNext();
            }

            if (current == this.last) {
                System.out.println("The value " + value + " is not in the list");
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                this.elementsCount--;
            }
        }
    }

    /**
     * Devuelve una representación en cadena de la lista.
     *
     * @return una cadena que representa la lista.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (DoubleNode current = this.first.getNext(); current != this.last; current = current.getNext()) {
            sb.append(current.getValue());
            if (current.getNext() != this.last) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
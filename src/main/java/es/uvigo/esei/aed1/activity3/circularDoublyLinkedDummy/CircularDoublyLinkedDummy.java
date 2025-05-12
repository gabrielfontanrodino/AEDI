package es.uvigo.esei.aed1.activity3.circularDoublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

/**
 * Clase que representa una lista doblemente enlazada circular con nodo ficticio.
 */
public class CircularDoublyLinkedDummy {

    private final DoubleNode first;
    private int elementsCount;

    /**
     * Constructor que inicializa la lista con un nodo ficticio.
     */
    public CircularDoublyLinkedDummy() {
        this.first = new DoubleNode(null, -0, null);
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
        DoubleNode current = this.first.getNext();
        int count = 0;
        while (current != this.first) {
            if (current.hasValue(value)) {
                count++;
            }
            current = current.getNext();
        }

        return count;
    }

    /**
     * Verifica si un valor está presente en la lista.
     *
     * @param value el valor a buscar.
     * @return true si el valor está presente, false en caso contrario.
     */
    public boolean contains(int value) {
        DoubleNode current = this.first.getNext();

        while (current != this.first && !current.hasValue(value)) {
            current = current.getNext();
        }

        return current.hasValue(value);
    }

    /**
     * Añade un nuevo nodo al principio de la lista.
     *
     * @param value el valor a añadir.
     */
    public void addFirst(int value) {
        DoubleNode newNode = new DoubleNode(this.first, value, this.first.getNext());
        this.first.setNext(newNode);
        newNode.getNext().setPrevious(newNode); // this.first.getNext().setPrevious(newNode);
        this.elementsCount++;
    }

    /**
     * Añade un nuevo nodo al final de la lista.
     *
     * @param value el valor a añadir.
     */
    public void addLast(int value) {
        DoubleNode newNode = new DoubleNode(this.first.getPrevious(), value, this.first);
        if (this.isEmpty()) {
            this.first.setNext(newNode);
            this.first.setPrevious(newNode);
        } else {
            newNode.getPrevious().setNext(newNode); // this.first.getPrevious().setNext(newNode);
            this.first.setPrevious(newNode);
        }
        this.elementsCount++;
    }

    /**
     * Elimina el primer nodo que contiene el valor dado.
     *
     * @param value el valor a eliminar.
     */
    public void remove(int value) {
        DoubleNode current = this.first.getNext();
        while (current != this.first && !current.hasValue(value)) {
            current = current.getNext();
        }

        if (current.hasValue(value)) {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            this.elementsCount--;
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
        DoubleNode current = this.first.getNext();
        while (current != this.first) {
            sb.append(current.getValue());
            if (current.getNext() != this.first) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

}
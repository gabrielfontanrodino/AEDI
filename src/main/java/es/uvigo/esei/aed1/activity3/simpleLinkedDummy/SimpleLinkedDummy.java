package es.uvigo.esei.aed1.activity3.simpleLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.Node;

/**
 * Clase que representa una lista enlazada simple con un nodo ficticio.
 */
public class SimpleLinkedDummy {
    private final Node first;
    private int elementsCount;

    /**
     * Constructor que inicializa la lista con un nodo ficticio y sin elementos.
     */
    public SimpleLinkedDummy() {
        this.first = new Node(-0, null);
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

        for(Node current = this.first.getNext(); current != null; current = current.getNext()) {
            if(current.hasValue(value)) {
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
        Node current = this.first.getNext();

        while(current != null && !current.hasValue(value)) {
            current = current.getNext();
        }

        return current != null;
    }

    /**
     * Añade un valor al inicio de la lista.
     *
     * @param value el valor a añadir.
     */
    public void addFirst(int value) {
        Node newNode = new Node(value, this.first.getNext());
        this.first.setNext(newNode);
        this.elementsCount++;
    }

    /**
     * Añade un valor al final de la lista.
     *
     * @param value el valor a añadir.
     */
    public void addLast(int value) {
        Node newNode = new Node(value, null);

        Node current = this.first;
        while(current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
        this.elementsCount++;
    }

    /**
     * Elimina la primera ocurrencia de un valor en la lista.
     *
     * @param value el valor a eliminar.
     */
    public void remove(int value) {
        if(this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node current = this.first;

            while(current.getNext() != null && !current.getNext().hasValue(value)) {
                current = current.getNext();
            }

            if(current.getNext() != null) {
                current.setNext(current.getNext().getNext());
                this.elementsCount--;
            } else {
                System.out.println("The value " + value + " is not in the list");
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
        Node current = this.first.getNext();

        sb.append("[");

        while(current != null) {
            sb.append(current.getValue());
            if(current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        sb.append("]");

        return sb.toString();
    }
}
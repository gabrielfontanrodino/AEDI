package es.uvigo.esei.aed1.activity3.orderedLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.Node;

public class OrderedLinkedDummy {

    private final Node first;
    private int elementsCount;

    public OrderedLinkedDummy() {
        this.first = new Node(-0, null);
        this.elementsCount = 0;
    }

    public boolean contains(int value) {
        Node current = this.first.getNext();

        while (current != null) {
            if (current.hasValue(value)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void add(int value) {
        Node newNode = new Node(value, null);
        Node current = this.first;

        //Mientras el valor sea mayor que el valor del nodo actual
        while (current.getNext() != null && value < current.getValue()) {
            current = current.getNext();
        }

        if (current.getNext() == null) { //Si el siguiente nodo es nulo
            current.setNext(newNode); //Se añade el nuevo nodo al final
        } else { //Si no
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        this.elementsCount++;
    }

    /**
     * Removes the node with the specified value from the list.
     *
     * @param value the value to be removed from the list
     */
    public void remove(int value) {
        // Empezar desde el primer nodo
        Node current = this.first;

        // Recorrer la lista hasta que el siguiente nodo sea nulo o el siguiente nodo tenga el valor especificado
        while (current.getNext() != null && !current.getNext().hasValue(value)) {
            current = current.getNext();
        }

        // Si el siguiente nodo no es nulo, significa que se encontró el nodo con el valor especificado
        if (current.getNext() != null) {
            // Establecer el puntero siguiente del nodo actual para omitir el nodo que se va a eliminar
            current.setNext(current.getNext().getNext());
            // Decrementar el conteo de elementos en la lista
            this.elementsCount--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node current = this.first.getNext();

        sb.append("[");

        while (current != null) {
            sb.append(current.getValue());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        sb.append("]");

        return sb.toString();
    }

}

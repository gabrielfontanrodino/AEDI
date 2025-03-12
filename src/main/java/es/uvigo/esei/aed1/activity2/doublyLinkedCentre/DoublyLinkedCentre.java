package es.uvigo.esei.aed1.activity2.doublyLinkedCentre;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinkedCentre {

    private DoubleNode center;
    private int elementsCount;

    public DoublyLinkedCentre() {
        this.center = null; // Inicializa el último nodo como null
        this.elementsCount = 0; // Inicializa el tamaño de la lista como 0
    }

    public boolean isEmpty() {
        return elementsCount == 0;
    }

    public int size() {
        return this.elementsCount;
    }

    public boolean contains(int value) {
        // Buscamos del centro a la derecha
        DoubleNode current = this.center;
        while (current != null) {
            if (current.hasValue(value)) {
                return true;
            }
            current = current.getNext();
        }

        // Comprobamos desde el centro a la izquierda (excluyendo el centro, ya que lo hemos comprobado antes)
        current = (this.center != null) ? this.center.getPrevious() : null; // se supone que el centro no es null, pero por si acaso xd
        while (current != null) {
            if (current.hasValue(value)) {
                return true;
            }
            current = current.getPrevious();
        }

        return false;
    }

    public void add(int value) {
        DoubleNode newNode = new DoubleNode(null, value, null);
        if (this.isEmpty()) {
            this.center = newNode;
        } else {
            // Encuentra el nodo más a la derecha
            DoubleNode rightmost = this.center;
            while (rightmost.getNext() != null) {
                rightmost = rightmost.getNext();
            }
            // Conecta el nuevo nodo a la derecha del nodo más a la derecha
            rightmost.setNext(newNode);
            newNode.setPrevious(rightmost);

            // Ajustar el centro si el tamaño es par
            if (this.elementsCount % 2 == 0) { // Después de añadir un nuevo nodo, el tamaño de la lista es par
                this.center = this.center.getNext();
            }
        }
        this.elementsCount++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode current = this.center;

        while (current != null) {
            sb.append(current.getValue()).append(" ");
            current = current.getNext();
        }

        current = (this.center != null) ? this.center.getPrevious() : null;
        while (current != null) {
            sb.insert(0, current.getValue() + " ");
            current = current.getPrevious();
        }

        return sb.toString();
    }

}
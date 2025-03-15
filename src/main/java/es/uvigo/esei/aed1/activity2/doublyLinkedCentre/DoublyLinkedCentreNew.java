package es.uvigo.esei.aed1.activity2.doublyLinkedCentre;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

//Lo bueno es que acelera mucho la búsqueda en listas muy grandes, ya que no es necesario

// recorrer toda la lista para encontrar un elemento.

public class DoublyLinkedCentreNew {

    private DoubleNode centre;
    private int leftCount;
    private int rightCount;

    public DoublyLinkedCentreNew() {
        this.centre = null; // Inicializa el último nodo como null
        this.leftCount = 0; // Inicializa el tamaño de la lista a la izquierda del centro como 0
        this.rightCount = 0; // Inicializa el tamaño de la lista a la derecha del centro como 0
    }

    public boolean isEmpty() {
        return centre == null;
    }

    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        return this.leftCount + this.rightCount + 1;
    }

    public boolean contains(int value) {

        if (isEmpty()) {
            return false;
        }

        if (value == centre.getValue()) {
            return true;
        }

        DoubleNode current = this.centre;

        if (current.getValue() > value) {
            while (current != null && current.getValue() > value) {
                current = current.getPrevious();
            }
        } else {
            while (current != null && current.getValue() < value) {
                current = current.getNext();
            }
        }

        if (current == null) {
            return false;
        } else {
            return current.hasValue(value);
        }
    }

    public void add(int value) {
        DoubleNode newNode = new DoubleNode(null, value, null);
        if (this.isEmpty()) {
            this.centre = newNode;
            this.leftCount = 0;
            this.rightCount = 0;
        } else {
            if (value <= this.centre.getValue()) {
                insertLeft(newNode);
            } else {
                insertRight(newNode);
            }
            adjustCentre();
        }
    }

    private void insertLeft(DoubleNode newNode) {
        if (this.centre.getPrevious() == null) {
            newNode.setNext(this.centre);
            this.centre.setPrevious(newNode);
        } else {
            DoubleNode current = this.centre.getPrevious();
            while (current.getPrevious() != null && current.getValue() > newNode.getValue()) {
                current = current.getPrevious();
            }
            insertNode(current, newNode);
        }
        this.leftCount++;
    }

    private void insertRight(DoubleNode newNode) {
        if (this.centre.getNext() == null) {
            newNode.setPrevious(this.centre);
            this.centre.setNext(newNode);
        } else {
            DoubleNode current = this.centre.getNext();
            while (current.getNext() != null && current.getValue() < newNode.getValue()) {
                current = current.getNext();
            }
            insertNode(current, newNode);
        }
        this.rightCount++;
    }

    private void insertNode(DoubleNode current, DoubleNode newNode) {
        if (current.getValue() <= newNode.getValue()) {
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);
            if (current.getNext() != null) {
                current.getNext().setPrevious(newNode);
            }
            current.setNext(newNode);
        } else {
            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());
            if (current.getPrevious() != null) {
                current.getPrevious().setNext(newNode);
            } else {
                current.setPrevious(newNode);
            }
            current.setPrevious(newNode);
        }
    }

    private void adjustCentre() {
        if (Math.abs(this.leftCount - this.rightCount) == 2) {
            if (this.leftCount > this.rightCount) {
                this.centre = this.centre.getPrevious();
                this.leftCount--;
                this.rightCount++;
            } else {
                this.centre = this.centre.getNext();
                this.leftCount++;
                this.rightCount--;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        DoubleNode current = this.centre;

        // Move to the leftmost node
        while (current != null && current.getPrevious() != null) {
            current = current.getPrevious();
        }

        // Print from the leftmost node to the rightmost node
        while (current != null) {
            sb.append(current.getValue()).append(" ");
            current = current.getNext();
        }

        return sb.toString();
    }

}
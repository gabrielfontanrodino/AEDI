package es.uvigo.esei.aed1.activity3.simpleLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.Node;

public class SimpleLinkedDummy {
    private final Node first;
    private int elementsCount;

    public SimpleLinkedDummy() {
        this.first = new Node(-0, null);
        this.elementsCount = 0;
    }

    public boolean isEmpty() {
        return this.elementsCount == 0;
    }

    public int size() {
        return this.elementsCount;
    }

    public int numberOfOccurrences(int value) {
        int count = 0;

        for(Node current = this.first.getNext(); current != null; current = current.getNext()) {
            if(current.hasValue(value)) {
                count++;
            }
        }

        return count;
    }

    public boolean contains(int value) {
//        for(Node current = this.first.getNext(); current != null; current = current.getNext()) {
//            if(current.hasValue(value)) {
//                return true;
//            }
//        }
//
//        return false;
        Node current = this.first.getNext();

        while(current != null && !current.hasValue(value)) {
            current = current.getNext();
        }

        return current != null;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value, this.first.getNext());
        this.first.setNext(newNode);
        this.elementsCount++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value, null);

        Node current = this.first;
        while(current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
        this.elementsCount++;
    }

    public void remove(int value) {
        if(this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node current = this.first;

            while(current.getNext() != null && !current.getNext().hasValue(value)) { //Con un for se puede hacer más fácil
                current = current.getNext();
            }

            if(current.getNext() != null) { //Si el elemento siguiente no es nulo (es decir, si estamos en el último elemento de la lista)
                current.setNext(current.getNext().getNext()); // Desenlazamos el nodo que queremos eliminar y el GC se encargará de eliminarlo
                this.elementsCount--;
            } else {
                System.out.println("The value " + value + " is not in the list");
            }
        }
    }

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

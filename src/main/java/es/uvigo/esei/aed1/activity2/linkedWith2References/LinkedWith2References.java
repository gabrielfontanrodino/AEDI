package es.uvigo.esei.aed1.activity2.linkedWith2References;

import es.uvigo.esei.aed1.commonLinked.Node;

public class LinkedWith2References {

    private Node first, last;

    private int elementsCount;

    public LinkedWith2References() {
        this.first = null;
        this.last = null;
        this.elementsCount = 0;
    }

    public boolean isEmpty() {
        return (this.elementsCount == 0 && first == null && last == null);
    }

    public int size() {
        return this.elementsCount;
    }

    public int numberOfOccurrences(int value) {
        int ammount = 0;
        for (Node current = this.first; current != null; current = current.getNext()) {
            if (current.hasValue(value)) {
                ammount++;
            }
        }
        return ammount;
    }

    public boolean contains(int value) {
        Node current = this.first;
        while (current != null && !current.hasValue(value)) {
            current = current.getNext();
        }
        return current != null;
    }

    public void addFirst(int value) {
        Node nextNode;

        if (this.isEmpty()) {
            nextNode = null;
        } else {
            nextNode = this.first;
        }

        Node newNode = new Node(value, nextNode);
        this.first = newNode;
        if (this.isEmpty()) {
            this.last = newNode;
        }
        this.elementsCount++;

    }

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

    public void remove(int value) throws IllegalAccessException {
        if (this.isEmpty()) {
            throw new IllegalAccessException("The structure is empty. Values cannot be deleted.");
        } else {
            if (this.first.hasValue(value)) { // Eliminamos el primero
                if (this.size() == 1) { // Cuando solo hay un elemento
                    this.elementsCount--;
                    this.first = null;
                    this.last = null;
                } else { // Cuando hay más de un elemento
                    this.first = this.first.getNext();
                    this.elementsCount--;
                }
            } else { // Buscamos el elemento a borrar
                Node current = this.first;
                while (current.getNext() != null && !current.getNext().hasValue(value)) {
                    current = current.getNext();
                }
                
                if(current.getNext() == null) {
                    throw new IllegalAccessException("The value is not contained in the structure");
                } else {
                    //... delete
                }
            }
        }
    }

    @Override
    public String toString() {

        return "";
    }

}

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
        return (first == null && last == null && elementsCount == 0);
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
        Node newNode = new Node(value, this.first);
        this.first = newNode;
        if (this.elementsCount == 0) {
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
                throw new IllegalAccessException("Value not found in the structure.");
            }

            current.setNext(current.getNext().getNext());
            if (current.getNext() == null) {
                this.last = current;
            }
        }
        this.elementsCount--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Node current = this.first; current != null; current = current.getNext()) {
            sb.append(current.getValue()).append(" ");
        }

        return sb.toString();
    }

}

package es.uvigo.esei.aed1.activity2.doublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinked {

    private DoubleNode first, last;
    private int elementsCount;

    public DoublyLinked() {
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
        int counter = 0;
        for (DoubleNode current = this.first; current != null; current = current.getNext()) {
            if (current.hasValue(value)) {
                counter++;
            }
        }
        return counter;
    }

    public boolean contains(int value) {
        DoubleNode current = this.first;

        while (current != null && !current.hasValue(value)) {
            current = current.getNext();
        }

        return current != null;
    }

    public void addFirst(int value) {
        DoubleNode newNode = new DoubleNode(null, value, this.first);

        if (this.isEmpty()) {
            this.last = newNode;
        } else {
            this.first.setPrevious(newNode);
        }

        this.first = newNode;
        this.elementsCount++;
    }

    public void addLast(int value) {
        DoubleNode newNode = new DoubleNode(this.last, value, null);

        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }

        this.last = newNode;
        this.elementsCount++;
    }

    public void remove(int value) throws IllegalAccessException {
        if (this.isEmpty()) {
            throw new IllegalAccessException("The structure is empty");
        }
        if (this.first.hasValue(value)) {
            if (this.elementsCount == 1) {
                this.first = this.last = null;
            } else {
                this.first.getNext().setPrevious(null);
                this.first = this.first.getNext();
            }
            this.elementsCount--;
        } else {
            DoubleNode current = this.first;
            while (current != null && !current.hasValue(value)) {
                current = current.getNext();
            }
            if (current == null) {
                System.out.println("Value is not contained");
            } else if (current == this.last) {
                current.getPrevious().setNext(null);
                this.last = this.last.getPrevious();
                this.elementsCount--;
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                this.elementsCount--;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (DoubleNode current = this.first; current != null; current = current.getNext()) {
            sb.append(current.getValue()).append(" ");
        }

        return sb.toString();
    }

}

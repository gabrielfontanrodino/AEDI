package es.uvigo.esei.aed1.activity3.circularDoublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class CircularDoublyLinkedDummy {

    private final DoubleNode first;
    private int elementsCount;

    public CircularDoublyLinkedDummy() {
        this.first = new DoubleNode(null, -0, null);
        this.elementsCount = 0;
    }

    public boolean isEmpty() {
        return this.elementsCount == 0;
    }

    public int size() {
        return this.elementsCount;
    }

    public int numberOfOccurrences(int value) {
        DoubleNode current = this.first.getNext();
        int count = 0;
        while(current != this.first) {
            if(current.hasValue(value)) {
                count++;
            }
            current = current.getNext();
        }

        return count;
    }

    public boolean contains(int value) {
        DoubleNode current = this.first.getNext();

        while(current != this.first && !current.hasValue(value)) {
            current = current.getNext();
        }

        return current.hasValue(value);
    }

    public void addFirst(int value) {
        DoubleNode newNode = new DoubleNode(this.first, value, this.first.getNext());
        this.first.setNext(newNode);
        newNode.getNext().setPrevious(newNode); // this.first.getNext().setPrevious(newNode);
        this.elementsCount++;
    }

    public void addLast(int value) {
        DoubleNode newNode = new DoubleNode(this.first.getPrevious(), value, this.first);
        if(this.isEmpty()) {
            this.first.setNext(newNode);
            this.first.setPrevious(newNode);
        } else {
            newNode.getPrevious().setNext(newNode); // this.first.getPrevious().setNext(newNode);
            this.first.setPrevious(newNode);
        }
        this.elementsCount++;
    }

    public void remove(int value) {
        DoubleNode current = this.first.getNext();
        while(current != this.first && !current.hasValue(value)) {
            current = current.getNext();
        }

        if(current.hasValue(value)) {
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            this.elementsCount--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        DoubleNode current = this.first.getNext();
        while(current != this.first) {
            sb.append(current.getValue());
            if(current.getNext() != this.first) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

}

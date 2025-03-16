package es.uvigo.esei.aed1.activity3.doublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinkedDummy {

    private final DoubleNode first;
    private final DoubleNode last;
    private int elementsCount;

    public DoublyLinkedDummy() {
        this.first = new DoubleNode(null, -0, null);
        this.last = new DoubleNode(this.first, -0, null);
        this.first.setNext(this.last);
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

        for (DoubleNode current = this.first.getNext(); current != this.last; current = current.getNext()) {
            if (current.hasValue(value)) {
                count++;
            }
        }

        return count;
    }

    public boolean contains(int value) {
        DoubleNode current = this.first;
        while (current != this.last && !current.hasValue(value)) {
            current = current.getNext();
        }

        return current.hasValue(value);
    }

    public void addFirst(int value) {
        DoubleNode newNode = new DoubleNode(this.first, value, this.first.getNext());
        this.first.setNext(newNode);
        newNode.getNext().setPrevious(newNode);
        this.elementsCount++;
    }

    public void addLast(int value) {
        DoubleNode newNode = new DoubleNode(this.last.getPrevious(), value, this.last);
        newNode.getPrevious().setNext(newNode); // this.last.getPrevious().setNext(newNode);
        this.last.setPrevious(newNode);
        this.elementsCount++;
    }

    public void remove(int value) {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            DoubleNode current = this.first.getNext();
            while (current.getNext() != null && !current.hasValue(value)) {
                current = current.getNext();
            }

            if (current == this.last) {
                System.out.println("The value " + value + " is not in the list");
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
        sb.append("[");
        for (DoubleNode current = this.first.getNext(); current != this.last; current = current.getNext()) {
            sb.append(current.getValue());
            if (current.getNext() != this.last) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

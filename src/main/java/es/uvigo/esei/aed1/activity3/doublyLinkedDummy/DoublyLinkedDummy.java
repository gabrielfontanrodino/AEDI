package es.uvigo.esei.aed1.activity3.doublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinkedDummy {

    private DoubleNode first;
    private DoubleNode last;
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
        return 0;
    }

    public boolean contains(int value) {
        return true;
    }

    public void addFirst(int value) {

    }

    public void addLast(int value) {

    }

    public void remove(int value) {
        if(this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            DoubleNode current = this.first.getNext();
            while(current.getNext() != null && !current.hasValue(value)) {
                current = current.getNext();
            }

            if(current == this.last) {
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
        return "";
    }

}

package es.uvigo.esei.aed1.commonLinked;

public class DoubleNode {

    private DoubleNode previous;
    private int value;
    private DoubleNode next;

    public DoubleNode(DoubleNode previous, int value, DoubleNode next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

    public DoubleNode getPrevious() {
        return this.previous;
    }

    public int getValue() {
        return this.value;
    }

    public DoubleNode getNext() {
        return this.next;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public boolean hasValue(int value) {
        return this.value == value;
    }
}
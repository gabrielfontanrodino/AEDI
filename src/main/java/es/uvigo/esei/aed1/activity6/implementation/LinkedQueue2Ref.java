package es.uvigo.esei.aed1.activity6.implementation;

public class LinkedQueue2Ref<T> implements CustomQueue<T> {

    private Node<T> first, last;
    private int size;

    public LinkedQueue2Ref() {
        this.first = this.last = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T first() throws EmptyException {
        if(this.isEmpty()) {
            throw new EmptyException("Queue is empty");
        } else {
            return this.first.getValue();
        }
    }

    @Override
    public void add(T value) throws NullPointerException {
        if(value == null) {
            throw new NullPointerException("Value is null");
        } else {
            Node<T> newNode = new Node<>(value, null);
            if(this.isEmpty()) {
                this.first = this.last = newNode;
            } else {
                this.last.setNext(newNode);
                this.last = newNode;
            }
            this.size++;
        }
    }

    @Override
    public T remove() throws EmptyException {
        if(this.isEmpty()) {
            throw new EmptyException("Queue is empty");
        } else {
            T value = this.first.getValue();
            this.first = this.first.getNext();
            this.size--;
            if(this.isEmpty()) {
                this.last = null;
            }
            return value;
        }
    }

    @Override
    public void clear() {
        this.first = this.last = null;
        this.size = 0;
    }

}

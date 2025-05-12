package es.uvigo.esei.aed1.activity6.implementation;

public class RoundLinkedQueue<T> implements CustomQueue<T> {

    private Node<T> last;
    private int size;

    public RoundLinkedQueue() {
        this.last = null;
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
        if (this.isEmpty()) {
            throw new EmptyException("Queue is empty");
        } else {
            return this.last.getNext().getValue();
        }
    }

    @Override
    public void add(T value) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException("Value is null");
        } else {
            Node<T> newNode = new Node<>(value, null);
            if (this.isEmpty()) {
                this.last = newNode;
                this.last.setNext(newNode);
            } else {
                newNode.setNext(this.last.getNext());
                this.last.setNext(newNode);
                this.last = newNode;
            }
            this.size++;
        }
    }

    @Override
    public T remove() throws EmptyException {
        if (this.isEmpty()) {
            throw new EmptyException("Queue is empty");
        } else {
            T value = this.last.getNext().getValue();
            if (this.size == 1) {
                this.last = null;
            } else {
                this.last.setNext(this.last.getNext().getNext());
            }
            this.size--;
            return value;
        }
    }

    @Override
    public void clear() {
        this.last = null;
        this.size = 0;
    }
}

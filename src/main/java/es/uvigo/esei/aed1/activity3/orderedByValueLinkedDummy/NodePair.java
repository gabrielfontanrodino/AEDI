package es.uvigo.esei.aed1.activity3.orderedByValueLinkedDummy;

public class NodePair {

    private Pair pair;
    private NodePair next;

    public NodePair(Pair pair, NodePair next) {
        this.pair = pair;
        this.next = next;
    }

    public Pair getPair() {
        return this.pair;
    }

    public NodePair getNext() {
        return this.next;
    }

    public void setPair(Pair value) {
        this.pair = value;
    }

    public void setNext(NodePair next) {
        this.next = next;
    }

}

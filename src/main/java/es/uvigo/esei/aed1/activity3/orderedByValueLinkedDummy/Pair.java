package es.uvigo.esei.aed1.activity3.orderedByValueLinkedDummy;


public class Pair {

    private int counter;
    private int value;

    public Pair(int counter, int value) {
        this.counter = counter;
        this.value = value;
    }

    public int getCounter() {
        return this.counter;
    }

    public int getValue() {
        return this.value;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pair(counter=");
        sb.append(this.counter);
        sb.append(", value=");
        sb.append(this.value);

        return sb.toString();
    }
}

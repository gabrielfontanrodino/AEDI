package es.uvigo.esei.aed1.activity7;

import java.util.Objects;

public class Terna<T> {
    private final T value;
    private final int numTimes1, numTimes2;

    public Terna(T t, int n1, int n2) {
        value = t;
        numTimes1 = n1;
        numTimes2 = n2;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Terna) {
            Terna<T> t = (Terna<T>) o;
            return this.value.equals(t.value)
                    && this.numTimes1 == t.numTimes1
                    && this.numTimes2 == t.numTimes2;

        }
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value) + this.numTimes1 + this.numTimes2;
    }
}

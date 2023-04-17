
package es.uvigo.esei.aed1.activity6.implementation;

import static java.util.Objects.requireNonNull;


public class RoundLinkedQueue<T> implements CustomQueue<T> {

    public RoundLinkedQueue() {
        
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T first() throws EmptyException {
      return null;
    }

    @Override
    public void add(T value) throws NullPointerException{

    }

    @Override
    public T remove() throws EmptyException {
      return null;
    }

    @Override
    public void clear() {

    }
}

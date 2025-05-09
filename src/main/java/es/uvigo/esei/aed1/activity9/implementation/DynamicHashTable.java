package es.uvigo.esei.aed1.activity9.implementation;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

public class DynamicHashTable<T> implements HashTable<T> {

    private int numElems;
    private List<T>[] data;

    public DynamicHashTable(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) throw new IllegalArgumentException("The max table capacity mustn't be 0 or negative.");

        this.numElems = 0;
        this.data = new List[capacity];

        for (int i = 0; i < capacity; i++) {
            this.data[i] = new LinkedList<>();
        }
    }

    public DynamicHashTable() {
        this(50);
    }

    private int functionHash(T key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public boolean add(T elem) {
        int index = functionHash(elem);

        if (data[index].contains(elem)) return false;

        data[index].addFirst(elem);
        this.numElems++;

        return true;
    }

    @Override
    public boolean search(T elem) {
        int index = functionHash(elem);

        if(data[index].contains(elem)) {
            data[index].removeValue(elem);
            data[index].addFirst(elem);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(T elem) {
        int index = functionHash(elem);

        List<T> actualList = data[index];

        if (actualList.removeValue(elem)) {
            this.numElems--;
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        return this.numElems;
    }

}

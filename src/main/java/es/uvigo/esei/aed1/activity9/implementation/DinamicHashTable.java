package es.uvigo.esei.aed1.activity9.implementation;

import es.uvigo.esei.aed1.tads.list.List;

public class DinamicHashTable<T> implements HashTable<T> {

    private int numElems;
    private List<T>[] data;

    public DinamicHashTable(int capacity) throws IllegalArgumentException {

    }

    public DinamicHashTable() {
        this(50);
    }

    private int functionHash(T key) {
        return -1;
    }

    @Override
    public boolean add(T elem) {

        return false;
    }

    @Override
    public boolean search(T elem) {

        return false;
    }

    @Override
    public boolean remove(T elem) {

        return false;
    }

    @Override
    public int size() {
        return -1;
    }

}

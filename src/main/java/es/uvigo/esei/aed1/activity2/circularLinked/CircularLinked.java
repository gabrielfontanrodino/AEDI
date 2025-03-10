package es.uvigo.esei.aed1.activity2.circularLinked;

import es.uvigo.esei.aed1.commonLinked.Node;

/**
 * Clase que implementa una lista circular enlazada.
 */
public class CircularLinked {

    private Node last;
    private int size;

    // Constructor que inicializa una lista circular vacía
    public CircularLinked() {
        this.last = null; // Inicializa el último nodo como null
        this.size = 0; // Inicializa el tamaño de la lista como 0
    }

    // Verifica si la lista está vacía
    public boolean isEmpty() {
        return this.size == 0; // Retorna true si el tamaño es 0
    }

    // Devuelve el tamaño de la lista
    public int size() {
        return this.size; // Retorna el número de elementos en la lista
    }

    // Devuelve el primer valor de la lista
    public int firstValue() throws NullPointerException {
        if (this.isEmpty()) { // Verifica si la lista está vacía
            throw new NullPointerException("The list is empty"); // Lanza una excepción si está vacía
        }
        return this.last.getNext().getValue(); // Retorna el valor del primer nodo
    }

    // Verifica si un valor está contenido en la lista
    public boolean contains(int value) {
        if (this.isEmpty()) { // Verifica si la lista está vacía
            return false; // Retorna false si está vacía
        }
        Node current = this.last.getNext(); // Empieza desde el primer nodo
        do {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        } while (current != this.last.getNext()); // Recorre la lista hasta volver al inicio
        return false;
    }

    // Cuenta el número de ocurrencias de un valor en la lista
    public int numberOfOccurrences(int value) {
        if (this.isEmpty()) {
            return 0;
        }
        int count = 0;
        Node current = this.last.getNext(); // Empieza desde el primer nodo
        do {
            if (current.getValue() == value) {
                count++;
            }
            current = current.getNext(); // Avanza al siguiente nodo
        } while (current != this.last.getNext()); // Recorre la lista hasta volver al inicio
        return count;
    }

    // Añade un valor al final de la lista
    public void addLast(int value) {
        Node newNode = new Node(value, null); // Crea un nuevo nodo con el valor dado sin nodo siguiente
        if (this.isEmpty()) {
            newNode.setNext(newNode); // El nuevo nodo se apunta a sí mismo
        } else {
            newNode.setNext(this.last.getNext()); // El nuevo nodo apunta al primer nodo
            this.last.setNext(newNode); // El último nodo apunta al nuevo nodo
        }
        this.last = newNode; // Actualiza el último nodo
        this.size++; // Incrementa el tamaño de la lista
    }

    public void removeFirst() {
        if (!this.isEmpty()) {
            if (this.size == 1) { // Verifica si la lista tiene un solo elemento
                this.last = null; // Vacía la lista
            } else {
                this.last.setNext(this.last.getNext().getNext()); // Elimina el primer nodo de-referenciándolo
            }
            this.size--; // Decrementa el tamaño de la lista
        }
    }

    // Devuelve una representación en cadena de la lista
    @Override
    public String toString() {
        if (this.isEmpty()) { // Verifica si la lista está vacía
            return ""; // Retorna una cadena vacía si está vacía
        }
        StringBuilder sb = new StringBuilder(); // Crea un StringBuilder para construir la cadena
        Node current = this.last.getNext(); // Empieza desde el primer nodo
        do {
            sb.append(current.getValue()).append(" "); // Añade el valor del nodo a la cadena
            current = current.getNext(); // Avanza al siguiente nodo
        } while (current != this.last.getNext()); // Recorre la lista hasta volver al inicio
        return sb.toString().trim(); // Retorna la cadena resultante
    }
}
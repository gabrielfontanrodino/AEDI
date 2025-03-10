package es.uvigo.esei.aed1.activity2.circularDoublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class CircularDoublyLinked {

    private DoubleNode last;
    private int size;

    // Constructor que inicializa una lista circular doblemente enlazada vacía
    public CircularDoublyLinked() {
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

    // Cuenta el número de ocurrencias de un valor en la lista
    public int numberOfOccurrences(int value) {
        if (this.isEmpty()) {
            return 0;
        }
        int count = 0;
        DoubleNode current = this.last.getNext(); // Empieza desde el primer nodo
        do {
            if (current.getValue() == value) {
                count++;
            }
            current = current.getNext(); // Avanza al siguiente nodo
        } while (current != this.last.getNext()); // Recorre la lista hasta volver al inicio
        return count;
    }

    // Verifica si un valor está contenido en la lista
    public boolean contains(int value) {
        if (this.isEmpty()) {
            return false;
        }
        DoubleNode current = this.last.getNext(); // Empieza desde el primer nodo
        do {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext(); // Avanza al siguiente nodo
        } while (current != this.last.getNext()); // Recorre la lista hasta volver al inicio
        return false;
    }

    // Devuelve el primer valor de la lista
    public int firstValue() throws NullPointerException {
        if (this.isEmpty()) {
            throw new NullPointerException("The list is empty"); // Lanza una excepción si está vacía
        }
        return this.last.getNext().getValue(); // Retorna el valor del primer nodo
    }

    // Añade un valor al final de la lista
    public void addLast(int value) {
        DoubleNode newNode = new DoubleNode(this.last, value, null); // Crea un nuevo nodo con el valor dado
        if (this.isEmpty()) {
            newNode.setNext(newNode); // El nuevo nodo se apunta a sí mismo
            newNode.setPrevious(newNode); // El nuevo nodo se apunta a sí mismo
        } else {
            newNode.setNext(this.last.getNext()); // El nuevo nodo apunta al primer nodo
            newNode.setPrevious(this.last); // El nuevo nodo apunta al último nodo
            this.last.getNext().setPrevious(newNode); // El primer nodo apunta al nuevo nodo
            this.last.setNext(newNode); // El último nodo apunta al nuevo nodo
        }
        this.last = newNode; // Actualiza el último nodo
        this.size++; // Incrementa el tamaño de la lista
    }

    // Elimina el primer nodo de la lista
    public void removeFirst() {
        if (!this.isEmpty()) {
            if (this.size == 1) { // Verifica si la lista tiene un solo elemento
                this.last = null; // Vacía la lista desvinculando el último nodo
            } else {
                DoubleNode first = this.last.getNext(); // Obtiene el primer nodo
                this.last.setNext(first.getNext()); // El último nodo apunta al segundo nodo
                first.getNext().setPrevious(this.last); // El segundo nodo apunta al último nodo
            }
            this.size--; // Decrementa el tamaño de la lista
        }
    }

    // Elimina un nodo con un valor específico de la lista
    public void remove(int value) {
        if (this.isEmpty()) {
            return;
        }
        DoubleNode current = this.last.getNext(); // Empieza desde el primer nodo
        do {
            if (current.getValue() == value) {
                if (current == this.last) {
                    if (this.size == 1) {
                        this.last = null; // Vacía la lista
                    } else {
                        this.last = current.getPrevious(); // Actualiza el último nodo
                        this.last.setNext(current.getNext()); // El último nodo apunta al primer nodo
                        current.getNext().setPrevious(this.last); // El primer nodo apunta al último nodo
                    }
                } else {
                    current.getPrevious().setNext(current.getNext()); // El nodo anterior apunta al siguiente nodo
                    current.getNext().setPrevious(current.getPrevious()); // El nodo siguiente apunta al nodo anterior
                }
                this.size--; // Decrementa el tamaño de la lista
                return;
            }
            current = current.getNext(); // Avanza al siguiente nodo
        } while (current != this.last.getNext()); // Recorre la lista hasta volver al inicio
    }

    // Devuelve una representación en cadena de la lista
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return ""; // Retorna una cadena vacía si está vacía
        }
        StringBuilder sb = new StringBuilder(); // Crea un StringBuilder para construir la cadena
        DoubleNode current = this.last.getNext(); // Empieza desde el primer nodo
        do {
            sb.append(current.getValue()).append(" "); // Añade el valor del nodo a la cadena
            current = current.getNext(); // Avanza al siguiente nodo
        } while (current != this.last.getNext()); // Recorre la lista hasta volver al inicio
        return sb.toString().trim(); // Retorna la cadena resultante
    }
}
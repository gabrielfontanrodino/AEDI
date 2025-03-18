package es.uvigo.esei.aed1.activity2.doublyLinkedCentre;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

//Lo bueno es que acelera mucho la búsqueda en listas muy grandes, ya que no es necesario

/**
 * Implementación de una lista doblemente enlazada que mantiene un nodo central.
 * La lista se mantiene ordenada y el nodo central equilibrado para optimizar las búsquedas.
 */
public class DoublyLinkedCentreNew {

    private DoubleNode centre; // Nodo central de la lista
    private int leftCount; // Contador de nodos a la izquierda del centro
    private int rightCount; // Contador de nodos a la derecha del centro

    /**
     * Constructor que inicializa una lista doblemente enlazada vacía con centro.
     */
    public DoublyLinkedCentreNew() {
        this.centre = null; // Inicializa el nodo central como null
        this.leftCount = 0; // Inicializa el tamaño de la lista a la izquierda del centro como 0
        this.rightCount = 0; // Inicializa el tamaño de la lista a la derecha del centro como 0
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return centre == null;
    }

    /**
     * Devuelve el tamaño total de la lista.
     *
     * @return el número de elementos en la lista
     */
    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        return this.leftCount + this.rightCount + 1; // Suma los nodos izquierdos, derechos y el centro
    }

    /**
     * Verifica si un valor está contenido en la lista.
     * Utiliza el nodo central para optimizar la búsqueda.
     *
     * @param value el valor a buscar
     * @return true si el valor se encuentra en la lista, false en caso contrario
     */
    public boolean contains(int value) {
        if (isEmpty()) {
            return false;
        }

        // Primero verifica si el valor está en el nodo central
        if (value == centre.getValue()) {
            return true;
        }

        DoubleNode current = this.centre;

        // Si el valor es menor que el centro, busca hacia la izquierda
        if (current.getValue() > value) {
            while (current != null && current.getValue() > value) {
                current = current.getPrevious();
            }
        } else {
            // Si el valor es mayor que el centro, busca hacia la derecha
            while (current != null && current.getValue() < value) {
                current = current.getNext();
            }
        }

        // Verifica si se encontró el valor
        if (current == null) {
            return false;
        } else {
            return current.hasValue(value);
        }
    }

    /**
     * Añade un nuevo valor a la lista manteniendo el orden.
     *
     * @param value el valor a añadir
     */
    public void add(int value) {
        DoubleNode newNode = new DoubleNode(null, value, null);
        if (this.isEmpty()) {
            this.centre = newNode;
            this.leftCount = 0;
            this.rightCount = 0;
        } else {
            // Inserta a la izquierda o derecha según corresponda
            if (value <= this.centre.getValue()) {
                insertLeft(newNode);
            } else {
                insertRight(newNode);
            }
            // Reajusta el centro si es necesario
            adjustCentre();
        }
    }

    /**
     * Inserta un nuevo nodo a la izquierda del centro.
     * Mantiene el orden de la lista.
     *
     * @param newNode el nuevo nodo a insertar
     */
    private void insertLeft(DoubleNode newNode) {
        if (this.centre.getPrevious() == null) {
            // Si no hay nodos a la izquierda, inserta directamente
            newNode.setNext(this.centre);
            this.centre.setPrevious(newNode);
        } else {
            // Busca la posición correcta para mantener el orden
            DoubleNode current = this.centre.getPrevious();
            while (current.getPrevious() != null && current.getValue() > newNode.getValue()) {
                current = current.getPrevious();
            }
            insertNode(current, newNode);
        }
        this.leftCount++; // Incrementa el contador de nodos izquierdos
    }

    /**
     * Inserta un nuevo nodo a la derecha del centro.
     * Mantiene el orden de la lista.
     *
     * @param newNode el nuevo nodo a insertar
     */
    private void insertRight(DoubleNode newNode) {
        if (this.centre.getNext() == null) {
            // Si no hay nodos a la derecha, inserta directamente
            newNode.setPrevious(this.centre);
            this.centre.setNext(newNode);
        } else {
            // Busca la posición correcta para mantener el orden
            DoubleNode current = this.centre.getNext();
            while (current.getNext() != null && current.getValue() < newNode.getValue()) {
                current = current.getNext();
            }
            insertNode(current, newNode);
        }
        this.rightCount++; // Incrementa el contador de nodos derechos
    }

    /**
     * Inserta un nuevo nodo en la posición adecuada respecto al nodo actual.
     *
     * @param current el nodo de referencia para la inserción
     * @param newNode el nuevo nodo a insertar
     */
    private void insertNode(DoubleNode current, DoubleNode newNode) {
        if (current.getValue() <= newNode.getValue()) {
            // Inserta después del nodo actual
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);
            if (current.getNext() != null) {
                current.getNext().setPrevious(newNode);
            }
            current.setNext(newNode);
        } else {
            // Inserta antes del nodo actual
            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());
            if (current.getPrevious() != null) {
                current.getPrevious().setNext(newNode);
            } else {
                current.setPrevious(newNode);
            }
            current.setPrevious(newNode);
        }
    }

    /**
     * Ajusta la posición del nodo central para mantener el equilibrio.
     * Se activa cuando hay una diferencia de 2 nodos entre los lados.
     */
    private void adjustCentre() {
        if (Math.abs(this.leftCount - this.rightCount) == 2) {
            if (this.leftCount > this.rightCount) {
                // Desplaza el centro hacia la izquierda
                this.centre = this.centre.getPrevious();
                this.leftCount--;
                this.rightCount++;
            } else {
                // Desplaza el centro hacia la derecha
                this.centre = this.centre.getNext();
                this.leftCount++;
                this.rightCount--;
            }
        }
    }

    /**
     * Devuelve una representación en cadena de la lista.
     *
     * @return una cadena con todos los valores de la lista ordenados
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Si la lista está vacía, evitar NullPointerException
        if (isEmpty()) {
            return "";
        }

        DoubleNode current = this.centre;

        // Se mueve al nodo más a la izquierda
        while (current.getPrevious() != null) {
            current = current.getPrevious();
        }

        // Recorre toda la lista de izquierda a derecha
        while (current != null) {
            sb.append(current.getValue()).append(" ");
            current = current.getNext();
        }

        return sb.toString().trim();
    }
}
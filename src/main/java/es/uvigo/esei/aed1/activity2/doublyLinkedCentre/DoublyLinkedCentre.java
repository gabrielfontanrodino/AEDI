package es.uvigo.esei.aed1.activity2.doublyLinkedCentre;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

//Lo bueno es que acelera mucho la búsqueda en listas muy grandes, ya que no es necesario
// recorrer toda la lista para encontrar un elemento.
public class DoublyLinkedCentre {

    private DoubleNode centre;
    private int elementsCount; //TODO: Modificar por 2 atributos, uno que sea del centro a la izquierda y otro del centro a la derecha

    public DoublyLinkedCentre() {
        this.centre = null; // Inicializa el último nodo como null
        this.elementsCount = 0; // Inicializa el tamaño de la lista como 0
    }

    public boolean isEmpty() {
        return elementsCount == 0;
    }

    public int size() {
        return this.elementsCount;
    }

    public boolean contains(int value) {
        // Buscamos del centro a la derecha
        DoubleNode current = this.centre;
        while (current != null) {
            if (current.hasValue(value)) {
                return true;
            }
            current = current.getNext();
        }

        // Comprobamos desde el centro a la izquierda (excluyendo el centro, ya que lo hemos comprobado antes)
        current = (this.centre != null) ? this.centre.getPrevious() : null; // se supone que el centro no es null, pero por si acaso xd
        while (current != null) {
            if (current.hasValue(value)) {
                return true;
            }
            current = current.getPrevious();
        }

        return false;
    }

    public void add(int value) {
        DoubleNode newNode = new DoubleNode(null, value, null);
        if (this.isEmpty()) {
            this.centre = newNode;
        } else {
            // Encuentra el nodo más a la derecha
            DoubleNode rightmost = this.centre;
            while (rightmost.getNext() != null) {
                rightmost = rightmost.getNext();
            }
            // Conecta el nuevo nodo a la derecha del nodo más a la derecha
            rightmost.setNext(newNode);
            newNode.setPrevious(rightmost);

            // Ajustar el centro si el tamaño es par
            if (this.elementsCount % 2 == 0) { // Después de añadir un nuevo nodo, el tamaño de la lista es par
                this.centre = this.centre.getNext();
            }
        }
        this.elementsCount++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode current = this.centre;

        while (current != null) {
            sb.append(current.getValue()).append(" ");
            current = current.getNext();
        }

        current = (this.centre != null) ? this.centre.getPrevious() : null;
        while (current != null) {
            sb.insert(0, current.getValue() + " ");
            current = current.getPrevious();
        }

        return sb.toString();
    }

}
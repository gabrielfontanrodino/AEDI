package es.uvigo.esei.aed1.activity3.orderedByValueLinkedDummy;

public class OrderedByValueLinkedDummy {

    private final NodePair first;
    private int elementsCount;

    public OrderedByValueLinkedDummy() {
        this.first = new NodePair(null, null);
        this.elementsCount = 0;
    }

    public boolean contains(int value) {
        NodePair current = this.first;

        while (current != null) {
            if (current.getPair().getValue() == value) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void add(int value) {
        //1. Vamos a buscar si hay algún nodo con el mismo valor
        NodePair current = this.first;

        //2. Mientras el siguiente nodo no sea nulo y el valor del siguiente nodo sea menor que el valor, avanzamos
        while (current.getNext() != null && current.getNext().getPair().getValue() < value) {
            current = current.getNext();
        }

        //Si salimos de este while estamos ante 2 posibles casos:
        //  - Estamos en el último nodo (si el next es null), lo que significa que el valor es mayor que todos los valores de la lista
        //  - Estamos en el nodo anterior al que queremos insertar

        //3. Comprobamos si ya existe un nodo con el mismo valor
        if (current.getNext() != null && current.getNext().getPair().getValue() == value) {
            // Si el valor ya existe, incrementamos el contador
            current.getNext().getPair().setCounter(current.getNext().getPair().getCounter() + 1);
        } else {
            // Si el valor no existe, creamos un nuevo nodo con contador 1
            Pair newPair = new Pair(1, value);
            NodePair newNode = new NodePair(newPair, current.getNext());
            current.setNext(newNode);
            this.elementsCount++;
        }
    }

    public void remove(int value) {
        NodePair current = this.first;

        while (current.getNext() != null && current.getNext().getPair().getValue() != value) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            Pair currentPair = current.getNext().getPair();
            if (currentPair.getCounter() > 1) {
                currentPair.setCounter(currentPair.getCounter() - 1);
            } else {
                current.setNext(current.getNext().getNext());
                this.elementsCount--;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        NodePair current = this.first.getNext();
        while (current != null) {
            sb.append(current.getPair().getValue());
            sb.append(" (Ammount: ");
            sb.append(current.getPair().getCounter());
            sb.append(")");
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}

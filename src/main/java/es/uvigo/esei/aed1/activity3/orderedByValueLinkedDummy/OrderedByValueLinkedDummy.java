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

    /**
     * Adds a node with the specified value to the linked list.
     * If a node with the same value already exists, increments its counter.
     * Otherwise, inserts a new node in the correct position to maintain order.
     *
     * @param value the value of the node to be added
     */
    public void add(int value) {
        // Step 1: Search for a node with the same value
        NodePair current = this.first;

        // Step 2: Traverse the list until the next node is null or its value is greater than the specified value
        while (current.getNext() != null && current.getNext().getPair().getValue() < value) {
            current = current.getNext();
        }

        // If we exit the while loop, we are in one of two possible cases:
        // - We are at the last node (if next is null), meaning the value is greater than all values in the list
        // - We are at the node before the one we want to insert

        // Step 3: Check if a node with the same value already exists
        if (current.getNext() != null && current.getNext().getPair().getValue() == value) {
            // If the value already exists, increment the counter
            current.getNext().getPair().setCounter(current.getNext().getPair().getCounter() + 1);
        } else {
            // If the value does not exist, create a new node with counter 1
            Pair newPair = new Pair(1, value);
            NodePair newNode = new NodePair(newPair, current.getNext());
            current.setNext(newNode);
            this.elementsCount++;
        }
    }

    /**
     * Removes a node with the specified value from the linked list.
     * If the node's counter is greater than 1, it decrements the counter.
     * If the node's counter is 1, it removes the node from the list.
     *
     * @param value the value of the node to be removed
     */
    public void remove(int value) {
        NodePair current = this.first;

        // Traverse the list to find the node with the specified value
        while (current.getNext() != null && current.getNext().getPair().getValue() != value) {
            current = current.getNext();
        }

        // If the node with the specified value is found
        if (current.getNext() != null) {
            Pair currentPair = current.getNext().getPair();
            if (currentPair.getCounter() > 1) {
                // Decrement the counter if it is greater than 1
                currentPair.setCounter(currentPair.getCounter() - 1);
            } else {
                // Remove the node if the counter is 1
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

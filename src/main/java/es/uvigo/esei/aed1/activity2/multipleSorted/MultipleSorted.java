package es.uvigo.esei.aed1.activity2.multipleSorted;


/**
 * Clase que representa una lista doblemente ordenada de estudiantes.
 * Los estudiantes se pueden ordenar por nombre o por número.
 */
public class MultipleSorted {
    private MultipleNode firstName, firstNumber;

    /**
     * Constructor que inicializa la lista doblemente ordenada.
     */
    public MultipleSorted() {
        this.firstName = null;
        this.firstNumber = null;
    }

    /**
     * Añade un nuevo estudiante a la lista, manteniendo el orden por nombre y por número.
     *
     * @param student el estudiante a añadir
     */
    public void add(Student student) {
        // Crear un nuevo nodo con el estudiante proporcionado
        MultipleNode newNode = new MultipleNode(student, null, null);

        // Insertar el nodo en la lista ordenada por nombre
        if (this.firstName == null) {
            this.firstName = newNode;
        } else {
            MultipleNode current = this.firstName;
            MultipleNode previous = null;

            // Buscar la posición correcta para insertar el nodo basado en el nombre
            // "compareTo" devuelve un valor negativo si el nombre del estudiante es "menor" que el nombre del nodo actual
            while (current != null && current.getStudent().getName().compareTo(student.getName()) < 0) {
                previous = current;
                current = current.getNextName();
            }

            if (previous == null) { // Insertar al principio
                newNode.setNextName(this.firstName);
                this.firstName = newNode;
            } else {
                previous.setNextName(newNode);
                newNode.setNextName(current);
            }
        }

        // Insertar el nodo en la lista ordenada por número
        if (this.firstNumber == null) {
            this.firstNumber = newNode;
        } else {
            MultipleNode current = this.firstNumber;
            MultipleNode previous = null;

            // Buscar la posición correcta para insertar el nodo basado en el número
            while (current != null && current.getStudent().getNumber() < student.getNumber()) {
                previous = current;
                current = current.getNextNumber();
            }

            if (previous == null) { // Insertar al principio
                newNode.setNextNumber(this.firstNumber);
                this.firstNumber = newNode;
            } else { // Insertar en cualquier otro lugar
                previous.setNextNumber(newNode);
                newNode.setNextNumber(current);
            }
        }
    }

    /**
     * Imprime la lista de estudiantes ordenada por nombre.
     *
     * @return una cadena con la lista de estudiantes ordenada por nombre
     */
    public String printOrderedByName() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        for (MultipleNode current = this.firstName; current != null; current = current.getNextName()) {
            sb.append(current.getStudent());
        }

        return sb.toString();
    }

    /**
     * Imprime la lista de estudiantes ordenada por número.
     *
     * @return una cadena con la lista de estudiantes ordenada por número
     */
    public String printOrderedByNumber() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        for (MultipleNode current = this.firstNumber; current != null; current = current.getNextNumber()) {
            sb.append(current.getStudent());
        }

        return sb.toString();
    }

}
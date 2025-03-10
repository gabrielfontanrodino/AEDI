package es.uvigo.esei.aed1.activity2.multipleSorted;


public class MultipleSorted {
    private MultipleNode firstName, firstNumber;

    public MultipleSorted() {

    }

    public void add(Student student) {

    }

    public String printOrderedByName() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        for (MultipleNode current = this.firstName; current != null; current = current.getNextName()) {
            sb.append(current.getStudent());
        }

        return sb.toString();
    }


    public String printOrderedByNumber() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        for (MultipleNode current = this.firstNumber; current != null; current = current.getNextNumber()) {
            sb.append(current.getStudent());
        }

        return sb.toString();
    }

}

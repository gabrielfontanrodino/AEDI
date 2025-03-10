package es.uvigo.esei.aed1.activity2.multipleSorted;

public class Student {

    private final String id;
    private final String name;
    private final int number;

    public Student(String id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student: ");
        sb.append(name).append(", ");
        sb.append(number).append("\n");

        return sb.toString();
    }
}

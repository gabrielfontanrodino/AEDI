package es.uvigo.esei.aed1.activity2.circularLinked;

public class TestCircularLinked {

    public static void main(String[] args) {

        CircularLinked list = new CircularLinked();

        System.out.println("The value 3 is contained:  " + list.numberOfOccurrences(3) + " times");

        for (int i = 1; i <= 5; i++) {
            list.addLast(i);
        }

        System.out.println("is empty?: " + list.isEmpty());
        System.out.println("The number of values is: " + list.size());
        System.out.println("The value 1 is contained:  " + list.numberOfOccurrences(1) + " times");
        System.out.println("Is contained the 15? : " + list.contains(15));
        System.out.println("Removed value 1...");
        list.removeFirst();
        System.out.println("The value 1 is contained:  " + list.numberOfOccurrences(1) + " times");
        System.out.println("The first in the list: " + list.firstValue());
        System.out.println("List: " + list);
    }

}

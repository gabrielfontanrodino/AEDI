package es.uvigo.esei.aed1.activity2.doublyLinked;

public class TestDoublyLinked {

    public static void main(String[] args) {

        DoublyLinked list = new DoublyLinked();

        for (int i = 1; i <= 10; i++) {
            list.addLast(i);
        }

        for (int i = 1; i <= 10; i = i + 2) {
            list.addFirst(i);
        }

        System.out.println("is empty?: " + list.isEmpty());
        System.out.println("The number of values is: " + list.size());
        System.out.println("The value 3 is contained:  " + list.numberOfOccurrences(3) + " times");
        System.out.println("Is contained the 15? : " + list.contains(15));
        System.out.println("Remove value 3...");
        try {
            list.remove(3);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The value 3 is contained:  " + list.numberOfOccurrences(3) + " times");
        System.out.println("Remove value 3... ");
        try {
            list.remove(3);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The value 3 is contained:  " + list.numberOfOccurrences(3) + " times");
        try {
            list.remove(10);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The value 10 is contained:  " + list.numberOfOccurrences(10) + " times");
        System.out.println("List: " + list);

    }

}

package es.uvigo.esei.aed1.activity3.simpleLinkedDummy;

public class TestSimpleLinkedDummy {
    public static void main(String[] args) {
        // Create a new list
        SimpleLinkedDummy list = new SimpleLinkedDummy();

        // Test isEmpty and size
        System.out.println("Is empty: " + list.isEmpty()); // Should be true
        System.out.println("Size: " + list.size());       // Should be 0

        // Test addFirst and toString
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println("After addFirst: " + list);    // Should be [-0, 30, 20, 10]
        System.out.println("Is empty: " + list.isEmpty()); // Should be false
        System.out.println("Size: " + list.size());       // Should be 3

        // Test addLast
        list.addLast(40);
        list.addLast(50);
        System.out.println("After addLast: " + list);     // Should be [-0, 30, 20, 10, 40, 50]
        System.out.println("Size: " + list.size());       // Should be 5

        // Test contains
        System.out.println("Contains 20: " + list.contains(20)); // Should be true
        System.out.println("Contains 60: " + list.contains(60)); // Should be false

        // Test numberOfOccurrences
        list.addFirst(20);
        System.out.println("After adding another 20: " + list); // Should be [-0, 20, 30, 20, 10, 40, 50]
        System.out.println("Number of occurrences of 20: " + list.numberOfOccurrences(20)); // Should be 2
        System.out.println("Number of occurrences of 60: " + list.numberOfOccurrences(60)); // Should be 0

        // Test remove
        list.remove(20);
        System.out.println("After removing 20: " + list); // Should remove first occurrence of 20
        list.remove(40);
        System.out.println("After removing 40: " + list);
        list.remove(60); // Should print error message
        System.out.println("Size: " + list.size());

        // Test remove on empty list
        SimpleLinkedDummy emptyList = new SimpleLinkedDummy();
        emptyList.remove(10); // Should print "The list is empty"
    }
}

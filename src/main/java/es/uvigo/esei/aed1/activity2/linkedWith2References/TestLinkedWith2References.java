package es.uvigo.esei.aed1.activity2.linkedWith2References;

public class TestLinkedWith2References {

    public static void main(String[] args) {
        LinkedWith2References list = new LinkedWith2References();

        for (int i = 1; i <= 10; i++) {
            list.addLast(i);
        }

        for (int i = 0; i <= 12; i = i + 2) {
            list.addFirst(i);
        }

        System.out.println("is empty?: " + list.isEmpty());
        System.out.println("The number of values is: " + list.size());
        System.out.println("The value 10 is contained:  " + list.numberOfOccurrences(10) + " times");
        System.out.println("Is contained the 15? : " + list.contains(15));

        int occurrences = list.numberOfOccurrences(10);
        for(int i = 0; i < occurrences; i++) {
            System.out.println("Removing the value 10...");
            removeValue(list, 10);
            System.out.println("The value 10 is contained:  " + list.numberOfOccurrences(10) + " times");
        }

        System.out.println("List: " + list);
    }

    private static void removeValue(LinkedWith2References list, int value) {
        try {
            list.remove(value);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}


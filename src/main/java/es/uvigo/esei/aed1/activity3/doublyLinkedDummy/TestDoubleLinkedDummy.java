
package es.uvigo.esei.aed1.activity3.doublyLinkedDummy;


public class TestDoubleLinkedDummy {

  public static void main(String[] args) {

    DoublyLinkedDummy list = new DoublyLinkedDummy();

    for (int i = 1; i <= 10; i++) {
      list.addLast(i);
    }

    for (int i = 1; i <= 10; i = i + 2) {
      list.addFirst(i);
    }

    System.out.println("is empty?: " + list.isEmpty());
    System.out.println("The number of values is: " + list.size());
    System.out.println("The value 3 is contained:  " + list.numberOfOccurrences(3) + " times");
    System.out.println("Is the 15 contained? : " + list.contains(15));
    System.out.println("Remove value 3: ");
    list.remove(3);
    System.out.println("The value 3 is contained:  " + list.numberOfOccurrences(3) + " times");
    System.out.println("Remove value 3: ");
    list.remove(3);
    System.out.println("The value 3 is contained:  " + list.numberOfOccurrences(3) + " times");
    list.remove(10);
    System.out.println("The value 10 is contained:  " + list.numberOfOccurrences(10) + " times");
    System.out.println("List: " + list);

  }

}

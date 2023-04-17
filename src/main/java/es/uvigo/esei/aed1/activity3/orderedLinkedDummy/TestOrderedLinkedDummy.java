
package es.uvigo.esei.aed1.activity3.orderedLinkedDummy;


public class TestOrderedLinkedDummy {

  public static void main(String[] args) {

    OrderedLinkedDummy list = new OrderedLinkedDummy();

    for (int i = 1; i <= 10; i++) {
      list.add(i);
    }

    for (int i = 1; i <= 10; i = i + 2) {
      list.add(i);
    }

    System.out.println("List: " + list);
    System.out.println("Is the 3 contained? : " + list.contains(3));
    System.out.println("Is the 15 contained? : " + list.contains(15));
    System.out.println("Remove value 3: ");
    list.remove(3);
    System.out.println("Remove value 3: ");
    list.remove(3);
    System.out.println("Is the 3 contained? : " + list.contains(3));

    System.out.println("List: " + list);

  }

}

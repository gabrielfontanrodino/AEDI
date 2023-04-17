
package es.uvigo.esei.aed1.activity3.orderedByValueLinkedDummy;

public class TestOrderedByValueLinkedDummy {

  public static void main(String[] args) {
    OrderedByValueLinkedDummy list = new OrderedByValueLinkedDummy();
    list.add(1);
    list.add(2);
    list.add(5);
    list.add(5);
    list.add(4);
    list.add(6);
    list.add(4);
    System.out.println("List: " + list);
    list.remove(4);
    list.remove(4);
    System.out.println("List: " + list);
    list.add(4);
    System.out.println("List: " + list);
  }
}

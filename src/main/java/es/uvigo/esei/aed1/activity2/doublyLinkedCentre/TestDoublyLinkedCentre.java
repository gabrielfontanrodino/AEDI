
package es.uvigo.esei.aed1.activity2.doublyLinkedCentre;

public class TestDoublyLinkedCentre {

  public static void main(String[] args) {

    DoublyLinkedCentre list = new DoublyLinkedCentre();
    System.out.println("list: " + list);
    
    for (int i = 10; i <= 20; i += 2) {
      list.add(i);
    }
    System.out.println("list: " + list);
    
    for (int i = 11; i <= 20; i += 2) {
      list.add(i);
    }
    for (int i = 9; i >= 1; i--) {
      list.add(i);
    }
    System.out.println("list: " + list);
    
  }

}

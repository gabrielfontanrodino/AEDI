
package es.uvigo.esei.aed1.activity2.multipleSorted;

public class TestMultipleSorted {
  
  public static void main(String args[]){
    Student student1 = new Student("01", "maria", 10);
    Student student2 = new Student("02", "pablo", 40);
    Student student3 = new Student("03", "ana", 25);
    
    MultipleSorted list = new MultipleSorted();
    list.add(student1);
    list.add(student2);
    list.add(student3);
    
    System.out.println("Ordered by name" + list.printOrderedByName());
    System.out.println("Ordered by number" + list.printOrderedByNumber());  
  } 
}


package es.uvigo.esei.aed1.activity2.multipleSorted;


public class MultipleSorted {
  private MultipleNode firstName, firstNumber;

  public MultipleSorted() {
    
  }
  
  public void add(Student student) {
    
  }
  
  public String printOrderedByName(){
    StringBuilder tostring = new StringBuilder();
    
    tostring.append("\n");
    for(MultipleNode current = this.firstName; current !=  null; current = current.getNextName()){
      tostring.append(current.getStudent());
    }
    
    return tostring.toString();
  }
  
  
  public String printOrderedByNumber(){
    StringBuilder tostring = new StringBuilder();
    
    tostring.append("\n");
    for(MultipleNode current = this.firstNumber; current !=  null; current = current.getNextNumber()){
      tostring.append(current.getStudent());
    }
    
    return tostring.toString();
  }
  
}

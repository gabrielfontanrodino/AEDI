
package es.uvigo.esei.aed1.activity2.multipleSorted;


public class MultipleNode {

  private Student student;
  private MultipleNode nextName, nextNumber;

  public MultipleNode() {
    this(null, null, null);
  }

  public MultipleNode(Student student, MultipleNode nextNodeName, MultipleNode nextNodeNumber) {
    this.student = student;
    this.nextName = nextNodeName;
    this.nextNumber = nextNodeNumber;
  }
  
  public Student getStudent() {
    return this.student;
  }

  public MultipleNode getNextName() {
    return this.nextName;
  }

  public MultipleNode getNextNumber() {
    return this.nextNumber;
  }

  public void setAlumno(Student student) {
    this.student = student;
  }

  public void setNextName(MultipleNode nextNode) {
    nextName = nextNode;
  }

  public void setNextNumber(MultipleNode nextNode) {
    nextNumber = nextNode;
  }
}

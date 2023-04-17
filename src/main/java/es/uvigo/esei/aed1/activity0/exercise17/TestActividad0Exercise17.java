
package es.uvigo.esei.aed1.activity0.exercise17;

import static es.uvigo.esei.aed1.activity0.exercise17.Activity0Exercise17.printNotes;
import static es.uvigo.esei.aed1.activity0.exercise17.Activity0Exercise17.readNotes;
import static es.uvigo.esei.aed1.activity0.exercise17.Activity0Exercise17.readNumber;

public class TestActividad0Exercise17 {
  public static void main(String[] args) {
    
    //exercise 17
    int numberStudents;
    int numberSubjects;
    numberStudents = readNumber("enter the number of students: ");
    numberSubjects = readNumber("enter the number of subjects: ");
    double[][] notes = new double[numberStudents][numberSubjects];

    readNotes(notes, "reading of notes");

    printNotes(notes,"display of notes");
  } 
}

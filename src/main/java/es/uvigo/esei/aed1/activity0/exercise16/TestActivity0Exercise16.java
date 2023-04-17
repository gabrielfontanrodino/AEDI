
package es.uvigo.esei.aed1.activity0.exercise16;

import static es.uvigo.esei.aed1.activity0.exercise16.Activity0Exercise16.average;
import static es.uvigo.esei.aed1.activity0.exercise16.Activity0Exercise16.maximum;
import static es.uvigo.esei.aed1.activity0.exercise16.Activity0Exercise16.minimum;
import static es.uvigo.esei.aed1.activity0.exercise16.Activity0Exercise16.readArray;

public class TestActivity0Exercise16 {
  
  public static void main(String[] args) {
    
    //exercise 16
    final int NUMVALUES = 10;
    int[] array = new int[NUMVALUES];

    readArray(array);

    System.out.println("The maximum value is: " + maximum(array));
    System.out.println("The minimun value is: " + minimum(array));
    System.out.println("The average value is: " + average(array));
  } 
}

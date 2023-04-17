
package es.uvigo.esei.aed1.activity6.implementation;

import static es.uvigo.esei.aed1.activity6.Activity6.equalsValues;
import java.util.function.Supplier;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CustomQueueExerciseTestCase {
  private Supplier<CustomQueue<Integer>> queueSupplier;

  public CustomQueueExerciseTestCase(Supplier<CustomQueue<Integer>> queueSupplier) {
    this.queueSupplier = queueSupplier;
  }
  
  private CustomQueue<Integer> createEqualValuesQueue() {
    CustomQueue<Integer> queue = this.queueSupplier.get();
    
    for (int i = 1; i <= 10; i++) {
      queue.add(1);
    }
    
    return queue;
  }
  
  private CustomQueue<Integer> createNotEqualValuesQueue() {
    CustomQueue<Integer> queue = this.queueSupplier.get();
    
    for (int i = 1; i <= 10; i++) {
      queue.add(i);
    }
    
    return queue;
  }

  /**
   * Test of equalsValues method, of class Activity6.
   */
  @Test
  public void testEqualsValuesNull() {
    assertThrows(NullPointerException.class, () -> {
      equalsValues(null);
    });
  }

  @Test
  public void testNotEqualsValues() {
    CustomQueue<Integer> queue = createNotEqualValuesQueue();
    
    assertThat(equalsValues(queue), is(false));
  }

  @Test
  public void testEqualsValues() {
    CustomQueue<Integer> queue = createEqualValuesQueue();
    
    assertThat(equalsValues(queue), is(true));
  }

}


package es.uvigo.esei.aed1.activity6;

import es.uvigo.esei.aed1.tads.queue.Queue;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class IsEqualToQueue<T> extends TypeSafeMatcher<Queue<T>>{
  private final Queue<T> expected;

  public IsEqualToQueue(Queue<T> expected){
    this.expected = expected;
  }
  @Override
  protected boolean matchesSafely(Queue<T> actual) {
    if (!expected.isEmpty() && !actual.isEmpty()) {
      return expected.remove().equals(actual.remove())
              && matchesSafely(actual);
    } else {
      return expected.isEmpty() && actual.isEmpty();
    }
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("equal queues");
  }
  
  public static <T> IsEqualToQueue<T> equalToQueue(Queue<T> expected){
    return new IsEqualToQueue<>(expected);
  }
  
}

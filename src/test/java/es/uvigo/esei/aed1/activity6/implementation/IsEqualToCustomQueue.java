
package es.uvigo.esei.aed1.activity6.implementation;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class IsEqualToCustomQueue<T> extends TypeSafeMatcher<CustomQueue<T>>{
  private final CustomQueue<T> expected;

  public IsEqualToCustomQueue(CustomQueue<T> expected){
    this.expected = expected;
  }
  
  @Override
  protected boolean matchesSafely(CustomQueue<T> actual) {
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
  
  public static <T> IsEqualToCustomQueue<T> equalToCustomQueue(CustomQueue<T> expected){
    return new IsEqualToCustomQueue<>(expected);
  }
  
}

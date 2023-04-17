
package es.uvigo.esei.aed1.activity5;

import es.uvigo.esei.aed1.tads.stack.Stack;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;


public class IsEqualToStack<T> extends TypeSafeMatcher<Stack<T>> {
  private final Stack<T> expected;
  
  public IsEqualToStack(Stack<T> expected) {
    this.expected = expected;
  }

  @Override
  protected boolean matchesSafely(Stack<T> actual) {
    if (expected.isEmpty() && actual.isEmpty()) {
      return true;
    } else {
      
      while (!expected.isEmpty() && !actual.isEmpty()) {
        if (!expected.pop().equals(actual.pop())) {
          return false;
        }
      }
      return expected.isEmpty() && actual.isEmpty();
    }
    
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("equal stacks");
  }
  
  public static <T> IsEqualToStack<T> equalToStack(Stack<T> expected) {
    return new IsEqualToStack<>(expected);
  }
  
}

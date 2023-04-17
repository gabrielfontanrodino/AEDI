
package es.uvigo.esei.aed1.activity7;

import es.uvigo.esei.aed1.tads.list.List;
import java.util.Iterator;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class IsEqualToList<T> extends TypeSafeMatcher<List<T>> {
  private final List<T> expected;
  
  public IsEqualToList(List<T> expected) {
    this.expected = expected;
  }

  @Override
  protected boolean matchesSafely(List<T> actual) {
    if (expected.size() != actual.size()) {
      return false;
    } else {
      Iterator<T> it1 = expected.iterator();
      Iterator<T> it2 = actual.iterator();
      
      boolean eq = true;
      while (it1.hasNext() && eq) {
        eq = it1.next().equals(it2.next());
      }
      
      return eq;
    }
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("equal lists");
  }
  
  public static <T> IsEqualToList<T> equalToList(List<T> expected) {
    return new IsEqualToList<>(expected);
  }
}

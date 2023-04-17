package es.uvigo.esei.aed1.activity6.implementation;


import static es.uvigo.esei.aed1.activity6.implementation.IsEqualToCustomQueue.equalToCustomQueue;
import java.util.function.Supplier;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public abstract class CustomQueueTestCase {

  private final Supplier<CustomQueue<Integer>> queueSupplier;

  public CustomQueueTestCase(Supplier<CustomQueue<Integer>> queueSupplier) {
    this.queueSupplier = queueSupplier;
  }

  private CustomQueue<Integer> createQueueWith(Integer... values) {
    final CustomQueue<Integer> queue = this.queueSupplier.get();

    for (Integer value : values) {
      queue.add(value);
    }

    return queue;
  }

  @Test
  public void testIsEmptyEmptyQueue() {
    final CustomQueue<Integer> queue = this.queueSupplier.get();

    assertThat(queue.isEmpty(), is(true));
  }

  @Test
  public void testIsEmptyNonEmptyQueue() {
    final CustomQueue<Integer> queue = this.createQueueWith(10, 11, 12, 13, 14, 15);

    assertThat(queue.isEmpty(), is(false));
  }

  @Test
  public void testSizeEmptyQueue() {
    final CustomQueue<Integer> queue = this.queueSupplier.get();

    assertThat(queue.size(), is(0));
  }

  @Test
  public void testSizeNonEmptyQueue() {
    final CustomQueue<Integer> queue = this.createQueueWith(10, 11, 12, 13, 14, 15);

    assertThat(queue.size(), is(6));
  }

  @Test
  public void testFirstEmptyQueue() {
    final CustomQueue<Integer> queue = this.queueSupplier.get();

    assertThrows(EmptyException.class, queue::first);
  }

  @Test
  public void testFirstNonEmptyQueue() {
    final CustomQueue<Integer> queue = this.createQueueWith(10, 11, 12, 13, 14, 15);

    assertThat(queue.first(), is(10));
  }

  @Test
  public void testAddNull() {
    final CustomQueue<Integer> queue = this.queueSupplier.get();

    assertThrows(NullPointerException.class, () -> queue.add(null));
  }

  @Test
  public void testAddEmptyQueue() {
    final CustomQueue<Integer> queue = this.createQueueWith(10);
    final CustomQueue<Integer> queueWithAdd = this.queueSupplier.get();

    queueWithAdd.add(10);

    assertThat(queue, is(equalToCustomQueue(queueWithAdd)));
  }

  @Test
  public void testAddNonEmptyQueue() {
    final CustomQueue<Integer> queue = this.createQueueWith(10, 11, 12, 13, 14, 15);
    final CustomQueue<Integer> queueWithAdd = this.createQueueWith(10, 11, 12, 13, 14);

    queueWithAdd.add(15);

    assertThat(queue, is(equalToCustomQueue(queueWithAdd)));
  }

  @Test
  public void testRemoveEmptyQueue() {
    final CustomQueue<Integer> queue = this.queueSupplier.get();

    assertThrows(EmptyException.class, queue::remove);
  }

  @Test
  public void testRemoveNonEmptyQueue() {
    final CustomQueue<Integer> queue = this.createQueueWith(11, 12, 13, 14, 15);
    final CustomQueue<Integer> queueWithRemove = this.createQueueWith(10, 11, 12, 13, 14, 15);

    assertThat(queueWithRemove.remove(), is(10));
    assertThat(queue, is(equalToCustomQueue(queueWithRemove)));
  }

  @Test
  public void testClear() {
    final CustomQueue<Integer> queue = this.createQueueWith(10, 11, 12, 13, 14, 15);

    queue.clear();

    assertThat(queue.isEmpty(), is(true));
  }

}


package es.uvigo.esei.aed1.activity6.implementation;

class Node<T> {
  private T value;
  private Node<T> next;

  public Node(T value, Node<T> next) {
    this.value = value;
    this.next = next;
  }

  public T getValue() {
    return this.value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getNext() {
    return this.next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  public boolean hasValue(T value) {
    return this.value.equals(value);
  }
  
}

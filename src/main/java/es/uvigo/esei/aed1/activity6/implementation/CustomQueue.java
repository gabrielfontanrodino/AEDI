package es.uvigo.esei.aed1.activity6.implementation;

public interface CustomQueue<T> {

  /**
   * Comprueba si la cola está vacía. Es decir, no tiene elementos.
   *
   * @return <code>true</code> si la cola está vacía. <code>false</code> en caso
   * contrario.
   */
  public boolean isEmpty();

  /**
   * Devuelve el tamaño de la cola.
   *
   * @return El número de elementos de la cola.
   */
  public int size();

  /**
   * Devuelve el objeto que más tiempo lleva en la cola.
   *
   * @return El objeto que está de primero en la cola.
   * @throws EmptyException si la cola no tiene elementos.
   */
  public T first() throws EmptyException;

  /**
   * Añade <code>value</code> a la cola, convirtiéndose en el valor más
   * recientemente introducido.
   *
   * @param value el nuevo valor a añadir a la cola.
   * @throws NullPointerException si <code>value</code> es <code>null</code>.
   */
  public void add(T value) throws NullPointerException;

  /**
   * Elimina y devuelve el objeto que más tiempo lleva en la cola.
   *
   * @return El objeto que está de primero en la cola.
   * @throws EmptyException si la cola no tiene elementos.
   */
  public T remove() throws EmptyException;

  /**
   * Elimina todos los elementos de la cola, convirtiéndola en una cola vacía.
   */
  public void clear();
}

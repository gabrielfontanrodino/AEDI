package es.uvigo.esei.aed1.activity9.implementation;

public interface HashTable<T> {

    /**
     * Añade <code>elem</code> a la tabla hash si no está ya alamacenado.
     *
     * @param elem el nuevo valor a añadir a la tabla hash.
     * @return <code>true</code> si ha insertado <code>elem</code>,
     * <code>false</code> en caso contrario
     */
    public boolean add(T elem);

    /**
     * Busca  <code>elem</code> en la tabla hash, si está realiza un movimiento
     * al frente (es decir, se coloca al principio de la estructura).
     *
     * @param elem el elemento a buscar en la tabla hash.
     * @return <code>true</code> si <code>elem</code> está. <code>false</code>
     * en caso contrario.
     */
    public boolean search(T elem);

    /**
     * Elimina <code>elem</code> de la tabla hash.
     *
     * @param elem el elemento a eliminar en la tabla hash.
     * @return <code>true</code> si <code>elem</code> está. <code>false</code>
     * en caso contrario.
     */
    public boolean remove(T elem);

    /**
     * Devuelve el número de elementos almacenados en la tabla hash.
     *
     * @return El número de elementos.
     */
    public int size();

}

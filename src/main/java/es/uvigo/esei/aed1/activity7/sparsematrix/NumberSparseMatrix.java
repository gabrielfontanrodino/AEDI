
package es.uvigo.esei.aed1.activity7.sparsematrix;


public interface NumberSparseMatrix {

  public int getNumRows();
  // Produce: devuelve el número de filas de la matriz

  public int getNumCols();
  // Produce: devuelve el número de columnas de la matriz

  public Number get(int i, int j) throws IndexOutOfBoundsException;
  // Produce: si i<=0 o i>n o j<=0 o j>m lanza la excepcion IndexOutOfBoundException
  //          en caso contrario devuelve el valor almacenado en la fila i, columna j.

  public void set(int i, int j, Number value) throws IndexOutOfBoundsException;
  // Modifica: this
  // Produce: si i<=0 o i>n o j<=0 o j>m lanza la excepcion IndexOutOfBoundException
  //          en caso contrario asigna value en la posicion dada por la fila i,columna j.

}

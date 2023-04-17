package es.uvigo.esei.aed1.activity7.sparsematrix;

/**
 *Representa un par (número de columna, valor almacenado) 
 * 
 */
public class ValueCol {
  private final int column;
  private Number value;

  public ValueCol(int column, Number value) {
    this.column = column;
    this.value = value;
  }

  public int getColumn() {
    return this.column;
  }

  public Number getValue() {
    return this.value;
  }

  public void setValue(Number value) {
    this.value = value;
  }
  
}

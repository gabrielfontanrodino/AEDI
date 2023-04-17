
package es.uvigo.esei.aed1.activity7.sparsematrix;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

/**
 * Representa un par (número de fila, lista de pares (columna, valor))
 */

public class ValueRow {

  private final int row;
  private final List<ValueCol> columns;

  public ValueRow(int row) {
    this.row = row;
    this.columns = new LinkedList<>();
  }

  public ValueRow(int row, List<ValueCol> list) {
    this.row = row;
    this.columns = list;
  }

  public int getRow() {
    return this.row;
  }

  public List<ValueCol> getColumns() {
    return this.columns;
  }
}

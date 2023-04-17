package es.uvigo.esei.aed1.activity7.sparsematrix;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import java.util.Iterator;

public class ListNumberSparseMatrix implements NumberSparseMatrix {

  private final int numRows;
  private final int numCols;
  private final List<ValueRow> rows;

  public ListNumberSparseMatrix(int n, int m) throws IllegalArgumentException {
    if (n <= 0 || m <= 0) {
      throw new IllegalArgumentException();
    }
    this.numRows = n;
    this.numCols = m;
    rows = new LinkedList<>();
  }

  @Override
  public int getNumRows() {
    return this.numRows;
  }

  @Override
  public int getNumCols() {
    return this.numCols;
  }

  @Override
  public Number get(int i, int j) throws IndexOutOfBoundsException {
    return null;
  }

  @Override
  public void set(int i, int j, Number value) throws IndexOutOfBoundsException {
    
  }
  
  
}

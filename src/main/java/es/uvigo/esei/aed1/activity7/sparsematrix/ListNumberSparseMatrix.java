package es.uvigo.esei.aed1.activity7.sparsematrix;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

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
        if (i <= 0 || i > numRows || j <= 0 || j > numCols) {
            throw new IndexOutOfBoundsException();
        }

        for (ValueRow row : rows) {
            if (row.getRow() == i) {
                for (ValueCol col : row.getColumns()) {
                    if (col.getColumn() == j) {
                        return col.getValue();
                    }
                }
            }
        }

        return 0; // Return 0 if the value is not found
    }

    @Override
    public void set(int i, int j, Number value) throws IndexOutOfBoundsException {
        if (i <= 0 || i > numRows || j <= 0 || j > numCols) {
            throw new IndexOutOfBoundsException();
        }

        for (ValueRow row : rows) {
            if (row.getRow() == i) {
                for(ValueCol col : row.getColumns()) {
                    if (col.getColumn() == j) {
                        col.setValue(value);
                        return;
                    }
                }
            }
        }

        ValueCol newCol = new ValueCol(j, value);
        rows.addLast(new ValueRow(i, new LinkedList<>()));
        rows.get(rows.size() - 1).getColumns().addLast(newCol);
    }

}


package es.uvigo.esei.aed1.activity7.sparsematrix;

import java.util.function.BiFunction;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public abstract class NumberSparseMatrixTestCase {
  private final BiFunction<Integer, Integer, NumberSparseMatrix> numberSparseMatrixBuilder;
  
  public NumberSparseMatrixTestCase(BiFunction<Integer, Integer, NumberSparseMatrix> numberSparceMatrixSupplier){
    this.numberSparseMatrixBuilder = numberSparceMatrixSupplier;
  }
  
  private NumberSparseMatrix createSparseMatrix() {
    final NumberSparseMatrix sparseMatrix = this.numberSparseMatrixBuilder.apply(10, 10);

    sparseMatrix.set(1, 1, 1);
    sparseMatrix.set(2, 2, 5);
    sparseMatrix.set(3, 2, 7);
    sparseMatrix.set(4, 4, 2);
    sparseMatrix.set(5, 6, 5);
    sparseMatrix.set(6, 6, 8);
    sparseMatrix.set(7, 7, 9);

    return sparseMatrix;
  }
  
  @Test
  public void testGetNumRowsTest(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    int result = 10;
    
    int expected = sparseMatrix.getNumRows();
    
    assertThat(expected, is(result));
  }
 

  @Test
  public void testGetNumCols(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    int result = 10;
    
    int expected = sparseMatrix.getNumCols();
    
    assertThat(expected, is(result));
  }
  

  @Test
  public void testGetLowerIndex(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    
    assertThrows(IndexOutOfBoundsException.class, () -> sparseMatrix.get(-1, -1));
  }
  
  @Test
  public void testGetHigherIndex(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    
    assertThrows(IndexOutOfBoundsException.class, () -> sparseMatrix.get(11, 11));
  }
  
  @Test
  public void testGetValueNon0(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    
    assertThat(sparseMatrix.get(3,2), is(7));
  }
  
  @Test
  public void testGetValue0(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    
    assertThat(sparseMatrix.get(5,1), is(0));
  }
  
  @Test
  public void testSetLowerIndex(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    
    assertThrows(IndexOutOfBoundsException.class, () -> sparseMatrix.set(-1, -1, 10));
  }
  
  @Test
  public void testSetHigherIndex(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    
    assertThrows(IndexOutOfBoundsException.class, () -> sparseMatrix.set(11, 11, 10));
  }
  
  @Test
  public void testSetValueNon0(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    
    sparseMatrix.set(3, 2, 10 );
    
    assertThat(sparseMatrix.get(3, 2), is(10));
  }
  
  @Test
  public void testSetValue0(){
    NumberSparseMatrix sparseMatrix = this.createSparseMatrix();
    
    sparseMatrix.set(5, 1, 0 );
    
    assertThat(sparseMatrix.get(5,1), is(0));
  }
}

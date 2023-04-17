
package es.uvigo.esei.aed1.activity8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SearchAlgorithmsTest {
    private final int [] aux1 = {2,8,15,15,15,30,35,45};
    
    private final int [] aux2 = {30,25,18,15,8,2,0,0};
    
    private final int [][] aux3 = {{1,1,1,1,1,1,1,1,1,1},
                        {2,2,2,2,2,2,2,1,2,2},
                        {2,2,2,2,2,1,1,1,1,1},
                        {2,2,2,2,2,2,2,1,2,2},
                        {2,2,2,2,2,2,2,1,2,2}};
    
    private final int [][] magic1 = {{1,14,14,4},
                                    {11,7,6,9},
                                    {8,10,10,5},
                                    {13,2,3,15}};
    
    private final int [][] magic2 = {{4,14,15,1},
                                    {9,7,6,12},
                                    {5,11,10,8},
                                    {16,2,3,13}};
    
    private final int [] aux4 = {-3,0,2,9,10,12,15};
    private final int [] aux5 = {-3,0,1,2,4,12,15};
    private final int [] aux6 = {-3,0,1,2,10,12,15};
 
    private static boolean equalMatrices(int[][] m1, int[][] m2){

           for (int i=0; i<m1.length; i++)
               for (int j=0; j<m1[0].length; j++)
                  if (m1[i][j] != m2[i][j])
                      return false;
              
           return true;
}
    

    /**
     * Test of fillIn method, of class SearchAlgorithms.
     */
    @Test
    public void testFillIn() {
        int xPosition = 2;
        int yPosition = 7;
        int newColor = 3;
        int [][] result = {{1,1,1,1,1,1,1,3,1,1},
        {2,2,2,2,2,2,2,3,2,2},
        {2,2,2,2,2,3,3,3,3,3},
        {2,2,2,2,2,2,2,3,2,2},
        {2,2,2,2,2,2,2,3,2,2}};
        SearchAlgorithms.fillIn(aux3, xPosition, yPosition, newColor);
        assertTrue(equalMatrices(aux3,result));
    }

    /**
     * Test of isMagicSquare method, of class SearchAlgorithms.
     */
    @Test
    public void testIsMagicSquareTrue() {
        int n = magic2.length;
        int magicConstant = (n * ((int) Math.pow(n, 2) + 1)) / 2;
        assertTrue(SearchAlgorithms.isMagicSquare(magic2, magicConstant));
    }
    
    @Test
    public void testIsMagicSquareFalse() {
        int n = magic1.length;
        int magicConstant = (n * ((int) Math.pow(n, 2) + 1)) / 2;
        assertFalse(SearchAlgorithms.isMagicSquare(magic1, magicConstant));
    }

    /**
     * Test of howManyMinors method, of class SearchAlgorithms.
     */
    @Test
    public void testHowManyMinorsIsElem() {
        int elem = 15;
        int expResult = 2;
        int result = SearchAlgorithms.howManyMinors(aux1, elem);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHowManyMinorsNoIsElem() {
        int elem = 22;
        int expResult = 5;
        int result = SearchAlgorithms.howManyMinors(aux1, elem);
        assertEquals(expResult, result);
    }

    /**
     * Test of howManyOlder method, of class SearchAlgorithms.
     */
    @Test
    public void testHowManyOlderIsElem() {
        int elem = 15;
        int expResult = 3;
        int result = SearchAlgorithms.howManyOlder(aux1, elem);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHowManyOlderNoIsElem() {
        int elem = 22;
        int expResult = 3;
        int result = SearchAlgorithms.howManyOlder(aux1, elem);
        assertEquals(expResult, result);
    }

    /**
     * Test of containNumber method, of class SearchAlgorithms.
     */
    @Test
    public void testContainNumberTrue() {
        int beginning = 0;
        int fin = aux4.length-1;
        int expResult = 2;
        int result = SearchAlgorithms.containNumber(aux4, beginning, fin);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testContainNumberTrue2() {
        int beginning = 0;
        int fin = aux5.length-1;
        int expResult = 4;
        int result = SearchAlgorithms.containNumber(aux5, beginning, fin);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testContainNumberFalse() {
        int beginning = 0;
        int fin = aux6.length-1;
        int expResult = -1;
        int result = SearchAlgorithms.containNumber(aux6, beginning, fin);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchInsertionDec method, of class SearchAlgorithms.
     */
    @Test
    public void testSearchInsertionDec() {
        int elem = 14;
        int max = 6;
        int expResult = 4;
        int result = SearchAlgorithms.searchInsertionDec(aux2, elem, max);
        assertEquals(expResult, result);
    }
    
}

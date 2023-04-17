package es.uvigo.esei.aed1.activity10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortAlgorithmsTest {

    /**
     * Test of bubbleSort2 method, of class SortAlgorithms.
     */
    @Test
    public void testBubbleSort2() {
        int[] aux = {4, 17, 6, 2, 8, 5, 12, 15};
        int[] expResult = {2, 4, 5, 6, 8, 12, 15, 17};
        SortAlgorithms.bubbleSort2(aux);
        assertArrayEquals(aux, expResult);
    }

    /**
     * Test of shellSort method, of class SortAlgorithms.
     */
    @Test
    public void testShellSort() {
        int[] aux = {4, 6, 2, 8, 5, 12, 15};
        int[] expResult = {2, 4, 5, 6, 8, 12, 15};
        SortAlgorithms.shellSort(aux);
        assertArrayEquals(aux, expResult);
    }

    /**
     * Test of radixSort method, of class SortAlgorithms.
     */
    @Test
    public void testRadixSort() {
        int[] aux = {4, 6, 2, 8, 5, 12, 15};
        int[] expResult = {2, 4, 5, 6, 8, 12, 15};
        SortAlgorithms.radixSort(aux);
        assertArrayEquals(aux, expResult);
    }

    /**
     * Test of selectionSort method, of class SortAlgorithms.
     */
    @Test
    public void testSelectionSort() {
        int[] aux = {4, 6, 2, 8, 5, 12, 15};
        int[] expResult = {15, 12, 8, 6, 5, 4, 2};
        SortAlgorithms.selectionSort(aux);
        assertArrayEquals(aux, expResult);
    }

    /**
     * Test of countSortDec method, of class SortAlgorithms.
     */
    @Test
    public void testCountSortDec() {
        int[] aux = {4, 6, 2, 8, 5, 12, 15};
        int[] expResult = {15, 12, 8, 6, 5, 4, 2};
        SortAlgorithms.countSortDec(aux);
        assertArrayEquals(aux, expResult);
    }

    /**
     * Test of beadSort method, of class SortAlgorithms.
     */
    @Test
    public void testBeadSort() {
        int[] aux = {4, 6, 2, 8, 5, 12, 15};
        int[] expResult = {15, 12, 8, 6, 5, 4, 2};
        SortAlgorithms.beadSort(aux);
        assertArrayEquals(aux, expResult);
    }

    /**
     * Test of quickSort method, of class SortAlgorithms.
     */
    @Test
    public void testQuickSort() {
        int[] aux = {4, 6, 2, 8, 5, 12, 15};
        int[] expResult = {2, 4, 5, 6, 8, 12, 15};
        int beginning = 0;
        int fin = 6;
        SortAlgorithms.quickSort(aux, beginning, fin);
        assertArrayEquals(aux, expResult);
    }

}

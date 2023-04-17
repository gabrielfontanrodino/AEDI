package es.uvigo.esei.aed1.activity8.pellets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchPelletsTest {

    private final int[][] coastGalician = {{1, 0, 0, 1, 1, 0, 1},
                                            {0, 1, 1, 0, 1, 1, 1},
                                            {1, 0, 1, 1, 0, 0, 0},
                                            {0, 1, 0, 1, 0, 1, 0},
                                            {1, 1, 0, 0, 1, 1, 1}};

  
    /**
     * Test of searchPellets method, of class SearchPellets.
     */
    @Test
    public void testSearchPellets() {
        Position beginning = new Position(2, 0);
        Position fin = new Position(4, 6);
        int expResult = 10;
        int result = SearchPellets.searchPellets(coastGalician, beginning, fin);
        assertEquals(expResult, result);
    }

}


package es.uvigo.esei.aed1.activity8.fireExtinguisher;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


public class WarehouseTest {
    private Warehouse war;
      

    @BeforeEach
    public void setUp() {
        war = new Warehouse(10);
        FireExtinguisher fire0 = new FireExtinguisher(56746, 'a', 23.34, "15/02/2014");
        war.insertFireExtinguisher(fire0);
    }
    

    /**
     * Test of insertFireExtinguisher method, of class Warehouse.
     */
    @Test
    public void testInsertFireExtinguisher() {
        FireExtinguisher fire1 = new FireExtinguisher(12345,'a',23.34,"12/02/2014");
        FireExtinguisher fire2 = new FireExtinguisher(56745,'a',23.34,"15/02/2014");
        FireExtinguisher fire3 = new FireExtinguisher(23445,'a',23.34,"17/02/2014");

        assertTrue(war.insertFireExtinguisher(fire1));
        assertTrue(war.insertFireExtinguisher(fire2));
        assertTrue(war.insertFireExtinguisher(fire3));
    }

    /**
     * Test of searchFireExtinguisher method, of class Warehouse.
     */
    @Test
    public void testSearchFireExtinguisherIs() {
        int referenceNumber = 56746;
        
        FireExtinguisher expResult = new FireExtinguisher(referenceNumber,'a',23.34,"15/02/2014");
        FireExtinguisher result = war.searchFireExtinguisher(referenceNumber);
        
        assertEquals(expResult.toString(), result.toString());
    }
    
    @Test
    public void testSearchFireExtinguisherNotIs() {
        int referenceNumber = 12546;
        
        FireExtinguisher expResult = null;
        FireExtinguisher result = war.searchFireExtinguisher(referenceNumber);
        
        assertEquals(expResult, result);
    }
    
}

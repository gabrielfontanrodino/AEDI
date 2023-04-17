
package es.uvigo.esei.aed1.activity8.wordDictionary;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchListTest {
    private List<WordDictionary> dictionary;

    
  @BeforeEach
    public void setUp() {
        dictionary = new LinkedList<>();
        dictionary.addLast(new WordDictionary('A'));
        dictionary.get(0).getWordsList().addLast("Alberto");
        dictionary.get(0).getWordsList().addLast("Ana");
        dictionary.get(0).getWordsList().addLast("Antonio");
        dictionary.addLast(new WordDictionary('B'));
        dictionary.get(1).getWordsList().addLast("Beatriz");
        dictionary.get(1).getWordsList().addLast("Bolaño");
        dictionary.get(1).getWordsList().addLast("Bueno");
        dictionary.addLast(new WordDictionary('C'));
        dictionary.get(2).getWordsList().addLast("Caserio");
        dictionary.get(2).getWordsList().addLast("Catalizador");
        dictionary.get(2).getWordsList().addLast("Cuento");
        dictionary.addLast(new WordDictionary('D'));
        dictionary.get(3).getWordsList().addLast("Dario");
        dictionary.get(3).getWordsList().addLast("Diamante");
        dictionary.get(3).getWordsList().addLast("Dolar");
    }

    /**
     * Test of dictionarySearch method, of class SearchList.
     */
    @Test
    public void testDictionarySearchTrue() {
        String word = "Bueno";
        assertTrue(SearchList.dictionarySearch(dictionary, word));
    }
    
    @Test
    public void testDictionarySearchFalse() {
        String word = "Anita";
        assertFalse(SearchList.dictionarySearch(dictionary, word));
    }
    
}

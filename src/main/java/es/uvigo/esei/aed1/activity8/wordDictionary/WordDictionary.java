package es.uvigo.esei.aed1.activity8.wordDictionary;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

public class WordDictionary {

    private final char letter;
    private final List<String> wordsList;

    public WordDictionary(char letter) {
        this.letter = letter;
        wordsList = new LinkedList<>();
    }

    public char getLetter() {
        return letter;
    }

    public List<String> getWordsList() {
        return wordsList;
    }

}

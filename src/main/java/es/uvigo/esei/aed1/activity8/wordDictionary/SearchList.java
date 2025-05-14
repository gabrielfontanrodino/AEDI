package es.uvigo.esei.aed1.activity8.wordDictionary;

import es.uvigo.esei.aed1.tads.list.List;

public class SearchList {

    private static boolean binarySearchListContainsWord(List<String> listD, String word) {
        int left = 0;
        int right = listD.size() - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            String midWord = listD.get(mid);

            if (midWord.equals(word)) {
                return true;
            } else if (midWord.compareTo(word) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    private static List<String> binaryDictionarySearch(List<WordDictionary> dictionary, String word) {
        int left = 0;
        int right = dictionary.size() - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            WordDictionary midWordDictionary = dictionary.get(mid);

            if (midWordDictionary.getLetter() == word.charAt(0)) {
                return midWordDictionary.getWordsList();
            } else if (midWordDictionary.getLetter() < word.charAt(0)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return null;
    }

    //Exercise 8
    public static boolean dictionarySearch(List<WordDictionary> dictionary, String word) {
        List<String> wordsList = binaryDictionarySearch(dictionary, word);
        if (wordsList != null) {
            return binarySearchListContainsWord(wordsList, word);
        }
        return false;
    }
}

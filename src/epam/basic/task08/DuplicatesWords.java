package epam.basic.task08;

import java.util.Arrays;
import java.util.Objects;

public class DuplicatesWords {
    private String[] uniqueWords = new String[0];
    private boolean[] isDuplicates = new boolean[0];

    public DuplicatesWords(String[] words) {
        for (String word : words) {
            if (!isWordDuplicate(word)) {
                addUniqueWords(word);
            }
        }
    }

    private void addUniqueWords(String word) {
        uniqueWords = Arrays.copyOf(uniqueWords, uniqueWords.length + 1);
        uniqueWords[uniqueWords.length - 1] = word;
        isDuplicates = Arrays.copyOf(isDuplicates, isDuplicates.length + 1);
        isDuplicates[isDuplicates.length - 1] = false;
    }

    private boolean isWordDuplicate(String word) {
        for (int i = 0; i < uniqueWords.length; i++) {
            if (Objects.equals(word, uniqueWords[i])) {
                isDuplicates[i] = true;
                return true;
            }
        }
        return false;
    }

    public String[] getThreeEarlierDuplication(boolean onInversion, boolean onUpper){
        String[] duplicates = new String[3];
        int index = 0;
        for (int i = 0; i < isDuplicates.length; i++) {
            if(isDuplicates[i]){
                duplicates[index++] = uniqueWords[i];
                if(index == 3){
                    break;
                }
            }
        }

        if(onInversion){
            for (int i = 0; i < duplicates.length; i++) {
                duplicates[i] = new StringBuilder(duplicates[i]).reverse().toString();
            }
        }

        if(onUpper){
            for (int i = 0; i < duplicates.length; i++) {
                duplicates[i] = duplicates[i].toUpperCase();
            }
        }

        return duplicates;
    }
}

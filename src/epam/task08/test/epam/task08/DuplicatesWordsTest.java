package epam.task08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicatesWordsTest {

    @Test
    void getThreeEarlierDuplication() {
        String[] words = "cat mouse cat capybara caterpillar mouse capybara".split(" ");
        DuplicatesWords duplicatesWords = new DuplicatesWords(words);

        assertArrayEquals("TAC ESUOM ARABYPAC".split(" "), duplicatesWords.getThreeEarlierDuplication(true, true));
    }
}
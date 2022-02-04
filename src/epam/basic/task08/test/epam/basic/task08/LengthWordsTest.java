package epam.basic.task08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthWordsTest {

    @Test
    void getUniqueWords() {
        String[] words = "cat mouse cat capybara caterpillar mouse".split(" ");
        LengthWords lengthWords = new LengthWords(words);
        
        assertArrayEquals("cat mouse capybara caterpillar".split(" "), lengthWords.getUniqueWords());
    }

    @Test
    void getThreeMaxLengthWords() {
        String[] words = "cat mouse cat capybara caterpillar mouse".split(" ");
        LengthWords lengthWords = new LengthWords(words);

        assertArrayEquals("caterpillar capybara mouse".split(" "), lengthWords.getThreeMaxLengthWords());
    }
}
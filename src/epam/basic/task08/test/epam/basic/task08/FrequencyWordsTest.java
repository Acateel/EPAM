package epam.basic.task08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyWordsTest {

    @Test
    void getUniqueWords() {
        String[] line = "cat dog cat cat dog mouse elephant elephant".split(" ");
        FrequencyWords frequencyWords = new FrequencyWords(line);
        String[] unique = frequencyWords.getUniqueWords();

        assertArrayEquals("cat dog mouse elephant".split(" "), unique);
    }

    @Test
    void getFrequency() {
        String[] line = "cat dog cat cat dog mouse elephant elephant".split(" ");
        FrequencyWords frequencyWords = new FrequencyWords(line);
        int[] frequency = frequencyWords.getFrequency();

        assertArrayEquals(new int[]{3, 2, 1, 2}, frequency);
    }

    @Test
    void getThreeMaxFrequencyWords() {
        String[] line = "mouse elephant elephant cat dog cat cat dog dog".split(" ");
        FrequencyWords frequencyWords = new FrequencyWords(line);

        Object[][] objects = frequencyWords.getThreeMaxFrequencyWords();

        assertEquals("cat", (String)objects[0][0]);
        assertEquals(3, (int)objects[0][1]);

        assertEquals("dog", (String)objects[1][0]);
        assertEquals(3, (int)objects[1][1]);

        assertEquals("elephant", (String)objects[2][0]);
        assertEquals(2, (int)objects[2][1]);
    }
}
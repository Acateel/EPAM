package epam.task08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileToWordsConverterTest {

    @Test
    void convert() {
        String path = "E:\\Java\\EPAM\\src\\epam\\task08\\test\\epam\\task08\\testinput.txt";
        String[] words = FileToWordsConverter.convert(path, true);

        assertArrayEquals("i am a human".split(" "), words);
    }

    @Test
    void convertFileNotFound() {
        String path = "E:\\Java\\EPAM\\src\\epam\\task08\\test\\epam\\task08\\input.txt";
        String[] words = FileToWordsConverter.convert(path, true);

        assertArrayEquals(new String[0], words);
    }
}
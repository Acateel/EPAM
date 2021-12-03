package epam.task08;

public class Part01 {
    public static void main(String[] args) {

        String[] words = FileToWordsConverter.convert("E:\\Java\\EPAM\\src\\epam\\task08\\input.txt", true);

        FrequencyWords frequencyWords = new FrequencyWords(words);

        showInConsole(frequencyWords.getThreeMaxFrequencyWords());
    }

    public static void showInConsole(Object[][] objects) {
        for (Object[] object : objects) {
            System.out.println((String) object[0] + " ==> " + (int) object[1]);
        }
    }

}

package epam.basic.task08;

public class Part03 {
    public static void main(String[] args) {
        String[] words = FileToWordsConverter.convert("E:\\Java\\EPAM\\src\\epam\\task08\\input.txt", true);
        DuplicatesWords duplicatesWords = new DuplicatesWords(words);

        for(String word: duplicatesWords.getThreeEarlierDuplication(true, true)){
            System.out.println(word);
        }
    }
}

package epam.basic.task08;

public class Part02 {
    public static void main(String[] args){
        String[] words = FileToWordsConverter.convert("E:\\Java\\EPAM\\src\\epam\\task08\\input.txt", true);

        LengthWords lengthWords = new LengthWords(words);

        for (String word : lengthWords.getThreeMaxLengthWords()){
            System.out.println(word + " ==> " + word.length());
        }
    }
}

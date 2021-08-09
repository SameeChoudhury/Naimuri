import java.util.ArrayList;
import java.util.List;

public class WordSquare {

    protected List<String> generateWordSquare(List<String> words, int n){
        List<String> wordSquare = new ArrayList<>();
        for (int i = 0; i < words.size(); i++){
            wordSquare.clear();
            wordSquare.add(words.get(i));
            wordSquare = wordSquareGeneration(words, wordSquare, n);
            if (wordSquare.size() == n){
                return wordSquare;
            }
        }
        return wordSquare;
    }

    private List<String> wordSquareGeneration(List<String> words, List<String> wordSquare, int n){
        String prefix;
        if (wordSquare.size() == n){
            return wordSquare;
        } else if (wordSquare.size() < n){
            prefix = setupPrefix(wordSquare);
            for (String word: words){
                if (wordMatchesPrefix(wordSquare, prefix, word)){
                    wordSquare.add(word);
                    wordSquare = wordSquareGeneration(words, wordSquare, n);
                    if (wordSquare.size() == n){
                        return wordSquare;
                    }
                    wordSquare.remove(wordSquare.size()-1);
                }
            }
        }
        return wordSquare;
    }

    String setupPrefix(List<String> wordSquare) {
        // The length of the prefix to find the next word will be the size of the current word square.
        // Use that amount and the words in teh word square to generate a prefix that can be used for evaluation.
        String prefix = "";
        for (int i = 0; i < wordSquare.size(); i++){
            prefix += wordSquare.get(i).charAt(wordSquare.size());
        }
        return prefix;
    }

    boolean wordMatchesPrefix(List<String> wordSquare, String prefix, String word) {
        // Initially validates that the word does not exist in the word square.
        boolean ifWordDoesntExistInWordSquare = !wordSquare.contains(word);

        // Use the amount of words already in the word square to get the amount of character the prefix will contain.
        // Use that amount to get the first n amount of characters from the word being assessed.
        boolean ifWordPrefixedCorrectly =  prefix.equals(word.substring(0, wordSquare.size()));

        return ifWordDoesntExistInWordSquare && ifWordPrefixedCorrectly;
    }
}

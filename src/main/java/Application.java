import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public void application(Console console){
        String[] input = getUserInput(console);
        int n = Integer.parseInt(input[0]);
        String allCharacterString = input[1];

        List<String> words = filterCharactersThroughDictionary(n, allCharacterString);

        // Return nothing if the value is true to ensure that the application does not evaluate strings which were deemed incorrect.
        // If someone had initially inputted '3 zzzzzzzzz' the application would normally allow this to be processed.
        // However, there are not enough words words in the dictionary to make enough words with these specific letters.
        // By having a return statement, it allows the correct sequence of characters to be analysed and when it comes back to this, it will force the method to stop at this point.
        if (validatedFilteredDictionary(console, n, allCharacterString, words)) return;
        WordSquare wordSquare = new WordSquare();
        List<String> generatedWordSquare = wordSquare.generateWordSquare(words, n);

        System.out.println("\nThe word square generated from your value is:\n");
        for (String word: generatedWordSquare){
            System.out.println(word);
        }
    }

    private boolean validatedFilteredDictionary(Console console, int n, String allCharacterString, List<String> words) {
        if (words.size() < n){
            System.out.println("\nSorry, there are not enough words in the dictionary to facilitate your input!");
            System.out.println("You had requested a " + n + "x" + n + " Word Square with the string: " + allCharacterString);
            System.out.println("Please try again\n");
            application(console);
            return true;
        }
        return false;
    }

    private String[] getUserInput(Console console){
        System.out.println("\nPlease enter an integer, n, followed by n^2 letters. For example \"4 eeeeddoonnnsssrv\" as it has the number 4 followed by a 4^2 (16) character long string\n");
        String input = console.readLine();

        String[] splitInput = input.split(" ");
        try {
            if (splitInput.length == 2 && Integer.parseInt(splitInput[0]) == Math.sqrt(splitInput[1].length())){
                return splitInput;
            } else {
                System.out.println("\nSorry, your input was invalid. Can you please try again\n");
                return getUserInput(console);
            }
        }catch (Exception e){
            System.out.println("\nSorry, your input was invalid. Can you please try again\n");
            return getUserInput(console);
        }
    }

    List<String> filterCharactersThroughDictionary(int n, String allCharacterString){
        List<String> words = new ArrayList<>();

        try {
            File myObj = new File("dictionary.txt");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                //by ensuring that the length can only be a specific amount and using the string inputted as a regex,
                // it will ensure that it will only contain those certain characters and by n characters long
                if(data.length() == n && data.matches("^[" + allCharacterString + "]+$")){
                    words.add(data);
                }
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("\n---------------An error occurred---------------\n");
            e.printStackTrace();
        }

        return words;
    }
}
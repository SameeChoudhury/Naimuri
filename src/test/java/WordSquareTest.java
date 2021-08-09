import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordSquareTest {

    @Test
    public void shouldSetupPrefixCorrectlyForSmallList(){
        // Given
        WordSquare wordSquare = new WordSquare();
        List<String> list = new ArrayList<>();
        list.add("rose");
        list.add("oven");
        String correctPrefix = "se";

        // When
        String prefix = wordSquare.setupPrefix(list);

        //Then
        assertEquals(prefix, correctPrefix);
    }

    @Test
    public void shouldSetupPrefixCorrectlyForLargeList(){
        // Given
        WordSquare wordSquare = new WordSquare();
        List<String> list = new ArrayList<>();
        list.add("bravado");
        list.add("renamed");
        list.add("analogy");
        list.add("valuers");
        list.add("amoebas");
        list.add("degrade");

        String correctPrefix = "odysse";

        // When
        String prefix = wordSquare.setupPrefix(list);

        //Then
        assertEquals(prefix, correctPrefix);
    }

    @Test
    public void shouldReturnTrueForCorrectPrefixForWord(){
        // Given
        WordSquare wordSquare = new WordSquare();
        List<String> list = new ArrayList<>();
        list.add("rose");
        list.add("oven");
        String prefix = "se";
        String word = "send";

        // When
        boolean doesWordMatchPrefix = wordSquare.wordMatchesPrefix(list, prefix, word);

        //Then
        assertTrue(doesWordMatchPrefix);
    }

    @Test
    public void shouldReturnFalseForIncorrectPrefixForWord(){
        // Given
        WordSquare wordSquare = new WordSquare();
        List<String> list = new ArrayList<>();
        list.add("rose");
        list.add("oven");
        String prefix = "se";
        String word = "tend";

        // When
        boolean doesWordMatchPrefix = wordSquare.wordMatchesPrefix(list, prefix, word);

        //Then
        assertFalse(doesWordMatchPrefix);
    }

    @Test
    public void shouldReturnFalseForPrefixCharacterLengthShorterThanExistingListSize(){
        // Given
        WordSquare wordSquare = new WordSquare();
        List<String> list = new ArrayList<>();
        list.add("rose");
        list.add("oven");
        list.add("send");
        String prefix = "en";
        String word = "ends";

        // When
        boolean doesWordMatchPrefix = wordSquare.wordMatchesPrefix(list, prefix, word);

        //Then
        assertFalse(doesWordMatchPrefix);
    }

    @Test
    public void shouldReturnFalseForPrefixCharacterLengthLongerThanExistingListSize(){
        // Given
        WordSquare wordSquare = new WordSquare();
        List<String> list = new ArrayList<>();
        list.add("rose");
        list.add("oven");
        String prefix = "sen";
        String word = "send";

        // When
        boolean doesWordMatchPrefix = wordSquare.wordMatchesPrefix(list, prefix, word);

        //Then
        assertFalse(doesWordMatchPrefix);
    }
}

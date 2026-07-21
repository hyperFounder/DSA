import java.util.Locale;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExerciseOne {

    public static void main(String[] args) {
        ex1("Hello Hello world.");
    }

    public static TreeSet<String> ex1(String s){
        TreeSet<String> set = new TreeSet<>();
        s = s.toLowerCase(Locale.ROOT).replaceAll("[^a-z ]", "");
        System.out.println(s);

        for (String i : s.split(" ")){
            if (!i.isEmpty()) {
                set.add(i);
            }
        }
        System.out.println(set);
        return set;
    }
}

class ExerciseOneUnitTest {

    @Test
    void shouldReturnUniqueWordsInAlphabeticalOrder() {
        TreeSet<String> result = ExerciseOne.ex1("World hello Hello java");

        TreeSet<String> expected = new TreeSet<>();
        expected.add("hello");
        expected.add("java");
        expected.add("world");

        assertEquals(expected, result);
    }

    @Test
    void shouldConvertWordsToLowercase() {
        TreeSet<String> result = ExerciseOne.ex1("HELLO HeLLo hello");

        TreeSet<String> expected = new TreeSet<>();
        expected.add("hello");

        assertEquals(expected, result);
    }

    @Test
    void shouldRemoveDuplicateWords() {
        TreeSet<String> result = ExerciseOne.ex1("apple apple apple banana");

        TreeSet<String> expected = new TreeSet<>();
        expected.add("apple");
        expected.add("banana");

        assertEquals(expected, result);
    }

    @Test
    void shouldRemovePunctuation() {
        TreeSet<String> result = ExerciseOne.ex1("Hello, world! Java.");

        TreeSet<String> expected = new TreeSet<>();
        expected.add("hello");
        expected.add("java");
        expected.add("world");

        assertEquals(expected, result);
    }

    @Test
    void shouldIgnoreExtraSpaces() {
        TreeSet<String> result = ExerciseOne.ex1("   hello     world    ");

        TreeSet<String> expected = new TreeSet<>();
        expected.add("hello");
        expected.add("world");

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnEmptySetForEmptyString() {
        TreeSet<String> result = ExerciseOne.ex1("");

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptySetForSpacesOnly() {
        TreeSet<String> result = ExerciseOne.ex1("       ");

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldHandleSingleWord() {
        TreeSet<String> result = ExerciseOne.ex1("Java");

        TreeSet<String> expected = new TreeSet<>();
        expected.add("java");

        assertEquals(expected, result);
    }

    @Test
    void shouldHandleNumbersByRemovingThem() {
        TreeSet<String> result = ExerciseOne.ex1("Java17 Spring Boot3");

        TreeSet<String> expected = new TreeSet<>();
        expected.add("java");
        expected.add("spring");
        expected.add("boot");

        assertEquals(expected, result);
    }

    @Test
    void shouldHandleOnlyPunctuation() {
        TreeSet<String> result = ExerciseOne.ex1("!!! ,,, ???");

        assertTrue(result.isEmpty());
    }
}
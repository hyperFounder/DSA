import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class ExerciseThree {

    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();

        String paragraph = """
                Java is a powerful language.
                Java is widely used for backend development.
                Developers enjoy Java because Java is reliable and mature.
                Many developers use Spring Boot and Maven.
                """;

        paragraph = paragraph.toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z ]", "");

        for (String word : paragraph.split("\\s+")) {
            if (!word.isEmpty()){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.subMap("d", "m").entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

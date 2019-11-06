package be.ac.umons.exercice4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exercice 4 : Map Reduce example (Word Count).
 *
 * @author Adriano Guttadauria
 * @author Olivier Debauche
 */
public class Exercice4 {

    public static void main(String[] args) {
        System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┣ MAP REDUCE WORD COUNT ┫" );
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        String filePath = null;

        if (args.length == 0)
            filePath = new String("dracula.txt");
        else if (args.length > 0 && args[0] != null && !args[0].isEmpty())
        {
            filePath = args[0];
        }

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            String regex = new String("[ ,\\.;:'\\-_()\\=’\\|\\[\\]\\{\\}\"@\\*#/\\?\\!«»]");

            Map<String, Long> words =
                    stream.flatMap(line -> Arrays.stream(line.split(regex)))  // découpe en utilisant une regex pour trouver les séparateurs
                    .filter(line -> Optional.ofNullable(line).orElse("").length() != 0)  // enlève les lignes vides
                    .filter(word -> word.length() >= 6 && word.length() <= 12)  // garde uniquement les mots d'une longueur de 6 à 12 lettres
                    .map(String::toLowerCase)  // les mets tous en minuscule
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // rassemble dans la map les mots en comptant le nombre d'occurences

            System.out.println("Word count done.");

            System.out.println("Now sorting by value...");

            // préserve l'ordre d'insertion
            LinkedHashMap<String, Long> sortedWords = new LinkedHashMap<>();

            /*
            récupère tous les couples clé, valeur
            les trie par valeur et les insèrent du plus petit au plus grand
             */
            words.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEachOrdered(x -> sortedWords.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, Long> entry : sortedWords.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

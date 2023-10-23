package by.harlap.stream.task.impl;

import by.harlap.stream.task.Task;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task13 implements Task {
    private final String fileName;

    public Task13(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void run() {
        System.out.println("\n13.Прочтите содержимое текстового файла и сделайте из него частотный словарик. (слово -> и какое кол-во раз это слово встречается в нём)\n");
        URL res = Task13.class.getClassLoader().getResource(fileName);
        File file = null;
        try {
            if (res != null) {
                file = Paths.get(res.toURI()).toFile();
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String absolutePath = null;
        if (file != null) {
            absolutePath = file.getAbsolutePath();
        }

        Map<String, Long> result = countWord(absolutePath);
        result.forEach((word, count) -> System.out.println(word + " -> " + count));
    }

    public static Map<String, Long> countWord(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            return lines
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


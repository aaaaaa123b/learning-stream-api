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
import java.util.Optional;
import java.util.function.Function;
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

        Optional.ofNullable(Task13.class.getClassLoader().getResource(fileName))
                .map(this::getFile)
                .orElseThrow(() -> new RuntimeException("Файл не найден"))
                .map(File::getAbsolutePath)
                .map(this::countWord)
                .orElseThrow(() -> new RuntimeException("Ошибка чтения файла"))
                .forEach((word, count) -> System.out.println(word + " -> " + count));
    }

    private Optional<File> getFile(URL resourceUrl) {
        try {
            final File file = Paths.get(resourceUrl.toURI()).toFile();
            return Optional.of(file);
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private Map<String, Long> countWord(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            return lines
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


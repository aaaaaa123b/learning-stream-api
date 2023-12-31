package by.harlap.stream.task.impl;

import by.harlap.stream.task.Task;

import java.util.List;
import java.util.OptionalDouble;

public class Task15 implements Task {

    private final List<String> strings;

    public Task15(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public void run() {
        System.out.println("\n15.Получите список строк, преобразуйте их в числа, и посчитайте среднее значение (не забудьте отфильтровать не валидные строки)\n");

        OptionalDouble average = strings.stream()
                .filter(string -> string.matches("-?\\d+(\\.\\d+)?"))
                .mapToDouble(Double::parseDouble)
                .average();

        if (average.isPresent()) {
            System.out.println("Среднее значение: " + average.getAsDouble());
        } else {
            System.out.println("Все строки не валидные.");
        }
    }

}


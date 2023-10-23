package by.harlap.stream.task.impl;

import by.harlap.stream.task.Task;
import by.harlap.stream.util.DataProvider;

import java.time.LocalDate;
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
                .filter(Task15::isValidNumber)
                .mapToDouble(Double::parseDouble)
                .average();

        if (average.isPresent()) {
            System.out.println("Среднее значение: " + average.getAsDouble());
        } else {
            System.out.println("Все строки не валидные.");
        }
    }

    private static boolean isValidNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }


    }
}


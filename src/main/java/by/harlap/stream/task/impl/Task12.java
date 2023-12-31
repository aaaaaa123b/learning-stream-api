package by.harlap.stream.task.impl;

import by.harlap.stream.enumeration.Gender;
import by.harlap.stream.model.Person;
import by.harlap.stream.task.Task;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task12 implements Task {
    private final List<Person> persons;

    public Task12(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        System.out.println("\n12.Получние список Person, сгруппируйте их по полу и результатом группировки должно быть их кол-во.\n");

        Map<Gender, Long> result = persons.stream()
                .collect(Collectors.groupingBy(Person::gender, Collectors.counting()));
        result.forEach((gender, count) -> {
            System.out.println("Пол: " + gender);
            System.out.println("Количество: " + count);
        });
    }
}

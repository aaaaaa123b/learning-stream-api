package by.harlap.stream.task.impl;

import by.harlap.stream.task.Task;
import by.harlap.stream.util.DataProvider;
import by.harlap.stream.model.Person;

import java.util.List;

public class Task9 implements Task {
    private final List<Person> persons;

    public Task9(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        System.out.println("\n9.Получите список Person и получите их средний вес.\n");
        persons.stream()
                .mapToDouble(Person::weight)
                .average()
                .ifPresent(System.out::println);

    }
}

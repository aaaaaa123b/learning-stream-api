package by.harlap.stream.task.impl;

import by.harlap.stream.task.Task;
import by.harlap.stream.util.DataProvider;
import by.harlap.stream.model.Person;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task10 implements Task {
    @Override
    public void run() {
        List<Person> persons = DataProvider.createPersons();
        System.out.println("\n10.Получние список Person и найдите самого младшего по возрасту.\n");
         persons.stream()
                .collect(Collectors.groupingBy(Person::age))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList())
                .forEach(System.out::println);
    }
}

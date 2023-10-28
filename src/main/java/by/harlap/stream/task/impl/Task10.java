package by.harlap.stream.task.impl;

import by.harlap.stream.collector.CustomListCollector;
import by.harlap.stream.model.Person;
import by.harlap.stream.task.Task;

import java.util.*;
import java.util.stream.Collectors;

public class Task10 implements Task {
    private final List<Person> persons;

    public Task10(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        System.out.println("\n10.Получение список Person и найдите самого младшего по возрасту.\n");

        int minAge = persons.stream()
                .mapToInt(Person::age)
                .min().getAsInt();

        persons.stream()
                .filter(person -> person.age() == minAge)
                .collect(CustomListCollector.toList()).forEach(System.out::println);

//        Optional<Person> result= persons.stream()
//                .min(Comparator.comparingInt(Person::age));
//        System.out.println(result.get());
    }
}

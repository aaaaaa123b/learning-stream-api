package by.harlap.stream.task.impl;

import by.harlap.stream.task.Task;
import by.harlap.stream.collector.CustomListCollector;
import by.harlap.stream.model.Person;

import java.util.List;


public class Task1 implements Task {

    private final List<Person> persons;
    private final int minimalAgeExclusive;

    public Task1(List<Person> persons, int minimalAgeExclusive) {
        this.persons = persons;
        this.minimalAgeExclusive = minimalAgeExclusive;
    }

    @Override
    public void run() {
        System.out.printf("1.Получите список Person и отфильтруйте только те, у которых age > %d и выведите в консоль.\n", minimalAgeExclusive);

        persons.stream()
                .filter(person -> person.age() > minimalAgeExclusive)
                .collect(CustomListCollector.toList())
                .forEach(System.out::println);
    }
}

package by.harlap.stream.task.impl;

import by.harlap.stream.collector.CustomListCollector;
import by.harlap.stream.model.Person;
import by.harlap.stream.task.Task;

import java.util.Comparator;
import java.util.List;

public class Task5 implements Task {

    private final List<Person> persons;

    public Task5(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {

        System.out.println("\n5.Получите список Person и отсортируйте их по возрасту в порядке убывания, если возраст равен, то по именам и выведите в консоль.\n");

        final Comparator<? super Person> personComparator = Comparator.comparing(Person::age)
                .reversed()
                .thenComparing(Person::name);

        persons.stream()
                .sorted(personComparator)
                .collect(CustomListCollector.toList())
                .forEach(System.out::println);
    }
}

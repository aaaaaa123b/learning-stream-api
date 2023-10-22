package by.harlap.stream.task.impl;

import by.harlap.stream.task.Task;
import by.harlap.stream.collector.CustomListCollector;
import by.harlap.stream.model.Person;

import java.util.List;

public class Task2 implements Task {

    private final List<Person> persons;
    private final double minimalWeightExclusive;

    public Task2(List<Person> persons, double minimalWeightExclusive) {
        this.persons = persons;
        this.minimalWeightExclusive = minimalWeightExclusive;
    }

    @Override
    public void run() {
        System.out.printf("\n2.Получите список Person, отфильтруйте только те, у кого weight > %f, преобразуйте в name и выведите в консоль.\n", minimalWeightExclusive);
        persons
                .stream()
                .filter(person -> person.weight() > minimalWeightExclusive)
                .map(Person::name)
                .collect(CustomListCollector.toList())
                .forEach(System.out::println);
    }
}

package by.harlap.stream.task.impl;

import by.harlap.stream.collector.CustomListCollector;
import by.harlap.stream.task.Task;
import by.harlap.stream.model.Person;
import by.harlap.stream.model.Phone;

import java.util.List;

public class Task8 implements Task {
    private final List<Person> persons;
    private final int personOrder;


    public Task8(List<Person> persons,int personOrder) {
        this.persons = persons;
        this.personOrder = personOrder;
    }

    @Override
    public void run() {
        System.out.printf("\n8.Получите список Person, получите %d по порядку человека и получите операторов его телефонов исключая дублирование.\n\n", personOrder);

        persons.stream()
                .skip(personOrder - 1)
                .findFirst()
                .map(person -> person.phones().stream()
                        .map(Phone::operator)
                        .distinct()
                        .collect(CustomListCollector.toList()))
                .ifPresent(operators -> operators.forEach(System.out::println));
    }
}

package by.harlap.stream.task.impl;


import by.harlap.stream.task.Task;
import by.harlap.stream.util.DataProvider;
import by.harlap.stream.collector.CustomListCollector;
import by.harlap.stream.model.Person;
import by.harlap.stream.model.Phone;

import java.util.List;

public class Task3 implements Task {
    private final List<Person> persons;
    private final int phoneNumbersExclusive;

    public Task3(List<Person> persons, int phoneNumbersExclusive) {
        this.persons = persons;
        this.phoneNumbersExclusive = phoneNumbersExclusive;
    }
    @Override
    public void run() {

        System.out.printf("\n3.Получите список Person, отфильтруйте только те, у кого кол-во телефонов > %d, преобразуйте в номера телефонов и выведите в консоль.\n\n", phoneNumbersExclusive);

        persons.stream()
                .filter(person -> person.phones().size() > phoneNumbersExclusive)
                .flatMap(person -> person.phones().stream())
                .map(Phone::number)
                .collect(CustomListCollector.toList())
                .forEach(System.out::println);
    }
}

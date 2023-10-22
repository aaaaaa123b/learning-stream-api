package by.harlap.stream.task.impl;


import by.harlap.stream.task.Task;
import by.harlap.stream.util.DataProvider;
import by.harlap.stream.collector.CustomListCollector;
import by.harlap.stream.model.Person;
import by.harlap.stream.model.Phone;

import java.util.List;

public class Task3 implements Task {
    @Override
    public void run() {
        List<Person> persons = DataProvider.createPersons();
        int numberOfPhones = 1;
        System.out.printf("\n3.Получите список Person, отфильтруйте только те, у кого кол-во телефонов > %d, преобразуйте в номера телефонов и выведите в консоль.\n", numberOfPhones);

        persons.stream()
                .filter(person -> person.phones().size() > numberOfPhones)
                .flatMap(person -> person.phones().stream())
                .map(Phone::number)
                .collect(CustomListCollector.toList())
                .forEach(System.out::println);
    }
}

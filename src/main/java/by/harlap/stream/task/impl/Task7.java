package by.harlap.stream.task.impl;

import by.harlap.stream.task.Task;
import by.harlap.stream.util.DataProvider;
import by.harlap.stream.model.Person;

import java.util.List;

public class Task7 implements Task {
    @Override
    public void run() {
        List<Person> persons = DataProvider.createPersons();
        String n = "2222";
        System.out.printf("\n7.Получите список Person и проверьте есть ли в этом списке человек, у которого номер телефона %s значению.\n", n);

        persons.stream()
                .filter(person -> person.phones()
                        .stream()
                        .anyMatch(phone -> phone.number().equals(n)))
                .findFirst().
                ifPresent(System.out::println);

    }
}

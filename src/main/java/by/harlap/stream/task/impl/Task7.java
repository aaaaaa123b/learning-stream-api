package by.harlap.stream.task.impl;

import by.harlap.stream.collector.CustomListCollector;
import by.harlap.stream.model.Person;
import by.harlap.stream.task.Task;

import java.util.List;
import java.util.Optional;

public class Task7 implements Task {
    private final List<Person> persons;
    private final String phoneNumber;

    public Task7(List<Person> persons, String phoneNumber) {
        this.persons = persons;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void run() {
        System.out.printf("\n7.Получите список Person и проверьте есть ли в этом списке человек, у которого номер телефона %s значению.\n\n", phoneNumber);
        List<Person> personWithPhoneNumber = persons.stream()
                .filter(person -> person.phones()
                        .stream()
                        .anyMatch(phone -> phone.number().equals(phoneNumber)))
                .collect(CustomListCollector.toList());

        if (personWithPhoneNumber != null) {
            System.out.println("Человек с номером телефона " + phoneNumber + " есть в списке.");
            for (Person person : personWithPhoneNumber) {
                System.out.println(person);
            }
        } else {
            System.out.println("Человека с номером телефона " + phoneNumber + " нет в списке.");
        }
    }
}

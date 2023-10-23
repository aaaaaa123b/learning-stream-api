package by.harlap.stream.task.impl;

import by.harlap.stream.model.Person;
import by.harlap.stream.task.Task;

import java.util.List;

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

        boolean personWithPhoneNumberExists = persons.stream()
                .anyMatch(person -> person.phones()
                        .stream()
                        .anyMatch(phone -> phone.number().equals(phoneNumber)));
        if (personWithPhoneNumberExists) {
            System.out.println("Человек с номером телефона " + phoneNumber + " есть в списке.");
        } else {
            System.out.println("Человека с номером телефона " + phoneNumber + " нет в списке.");
        }
    }
}

package by.harlap.stream.task.impl;

import by.harlap.stream.enumeration.Gender;
import by.harlap.stream.task.Task;
import by.harlap.stream.util.DataProvider;
import by.harlap.stream.model.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 implements Task {
    @Override
    public void run() {
        List<Person> persons = DataProvider.createPersons();

        System.out.println("\n6.Получите список Person и сгруппируйте их по полу.");
        Map<Gender, List<Person>> result = persons.stream()
                .collect(Collectors.groupingBy(Person::gender));

        result.forEach((gender, people) -> {
            System.out.println(gender + ":");
            people.forEach(person -> System.out.println(person.name()));
        });
    }
}
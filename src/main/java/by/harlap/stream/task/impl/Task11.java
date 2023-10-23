package by.harlap.stream.task.impl;

import by.harlap.stream.collector.CustomListCollector;
import by.harlap.stream.task.Task;
import by.harlap.stream.util.DataProvider;
import by.harlap.stream.enumeration.Operator;
import by.harlap.stream.model.Person;
import by.harlap.stream.model.Phone;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task11 implements Task {
    private final List<Person> persons;

    public Task11(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run() {
        System.out.println("\n11.Получние список Person, получите их телефоны, сгруппируйте по оператору и рузальтатом группировки должны быть только номера телефонов.\n");
        Map<Operator, List<String>> filtredPersons11 = persons
                .stream()
                .flatMap(person -> person.phones().stream())
                .collect(Collectors.groupingBy(Phone::operator, Collectors.mapping(Phone::number, CustomListCollector.toList())));

        filtredPersons11.forEach((operator, phoneNumbers) -> {
            System.out.println("Оператор: " + operator);
            System.out.println("Номера телефонов: " + phoneNumbers);
        });
    }
}

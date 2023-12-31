package by.harlap.stream.task.impl;

import by.harlap.stream.model.Person;
import by.harlap.stream.task.Task;

import java.util.List;
import java.util.stream.Collectors;

public class Task4 implements Task {

    private final List<Person> persons;

    public Task4(List<Person> persons) {
        this.persons = persons;
    }
    @Override
    public void run() {

        System.out.println("\n4.Получите список Person, преобразуйте в name и затем преобразуйте в строку, что бы имена были через запятую.\n");
        String result = persons
                .stream()
                .map(Person::name)
                .collect(Collectors.joining(","));
        System.out.println(result);
    }
}

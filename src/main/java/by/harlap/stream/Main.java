package by.harlap.stream;

import by.harlap.stream.task.Task;
import by.harlap.stream.task.impl.*;
import static by.harlap.stream.util.DataProvider.createPersons;
import static by.harlap.stream.util.DataProvider.createDates;
import static by.harlap.stream.util.DataProvider.createStrings;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final List<Task> tasks = List.of(
                new Task1(createPersons(), 25),
                new Task2(createPersons(), 70.0),
                new Task3(createPersons(),2),
                new Task4(createPersons()),
                new Task5(createPersons()),
                new Task6(createPersons()),
                new Task7(createPersons(),"2222"),
                new Task8(createPersons(),9),
                new Task9(createPersons()),
                new Task10(createPersons()),
                new Task11(createPersons()),
                new Task12(createPersons()),
                new Task13("test.txt"),
                new Task14(createDates()),
                new Task15(createStrings()),
                new Task16()
        );

        tasks.forEach(Task::run);
    }
}

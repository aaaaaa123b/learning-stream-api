package by.harlap.stream;

import by.harlap.stream.task.Task;
import by.harlap.stream.task.impl.*;
import static by.harlap.stream.util.DataProvider.createPersons;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final List<Task> tasks = List.of(
                new Task1(createPersons(), 25),
                new Task2(createPersons(), 70.0),
                new Task3(),
                new Task4(),
                new Task5(),
                new Task6(), new Task7(), new Task8(),
                new Task9(), new Task10(), new Task11(), new Task12(),
                new Task13(), new Task14(), new Task15(), new Task16()
        );

        tasks.forEach(Task::run);
    }
}

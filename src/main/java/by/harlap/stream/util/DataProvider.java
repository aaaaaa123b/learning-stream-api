package by.harlap.stream.util;

import by.harlap.stream.enumeration.Gender;
import by.harlap.stream.enumeration.Operator;
import by.harlap.stream.model.Person;
import by.harlap.stream.model.Phone;

import java.time.LocalDate;
import java.util.*;

public class DataProvider {

    public static List<Person> createPersons() {
        return Arrays.asList(
                new Person("Ann", 47, 65.5, Gender.FEMALE, List.of(new Phone(Operator.A1, "1111"), new Phone(Operator.A1, "3452"), new Phone(Operator.MTS, "3451"))),
                new Person("Bob", 24, 70.2, Gender.MALE, List.of(new Phone(Operator.MTS, "2222"), new Phone(Operator.A1, "9452"))),
                new Person("Peter", 25, 80.0, Gender.MALE, List.of(new Phone(Operator.LIFE, "3333"))),
                new Person("Jane", 35, 81.3, Gender.FEMALE, List.of(new Phone(Operator.LIFE, "3933"), new Phone(Operator.MTS, "9952"))),
                new Person("Anthony", 22, 72.0, Gender.MALE, List.of(new Phone(Operator.MTS, "5578"), new Phone(Operator.A1, "1056"))),
                new Person("Jacob", 89, 52.6, Gender.MALE, List.of(new Phone(Operator.LIFE, "5238"), new Phone(Operator.LIFE, "1020"))),
                new Person("Liza", 39, 42.6, Gender.FEMALE, List.of(new Phone(Operator.LIFE, "7281"))),
                new Person("Darya", 64, 100.6, Gender.FEMALE, List.of(new Phone(Operator.A1, "5801"))),
                new Person("Ram", 38, 62.6, Gender.MALE, List.of(new Phone(Operator.LIFE, "9021"), new Phone(Operator.LIFE, "9920"), new Phone(Operator.MTS, "9883"))),
                new Person("Kate", 89, 100.6, Gender.FEMALE, List.of(new Phone(Operator.LIFE, "7681")))
        );
    }

    public static List<String> createStrings() {
        return Arrays.asList(
                "101", "dfeif",
                "23", "aabbb",
                "1.2", "12345"
        );
    }

    public static List<LocalDate> createDates() {
        return Arrays.asList(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 2, 5),
                LocalDate.of(2023, 4, 13),
                LocalDate.of(2023, 12, 15)
        );
    }
}
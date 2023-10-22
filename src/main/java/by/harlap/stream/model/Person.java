package by.harlap.stream.model;

import by.harlap.stream.enumeration.Gender;

import java.util.List;

public record Person(String name, int age, double weight, Gender gender, List<Phone> phones) {

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", gender=" + gender +
                ", phones=" + phones +
                '}';
    }
}

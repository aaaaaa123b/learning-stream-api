package by.harlap.stream.model;

import by.harlap.stream.enumeration.Operator;

public record Phone (Operator operator, String number) {

    @Override
    public String toString() {
        return "Phone{" +
                "operator=" + operator +
                ", number='" + number + '\'' +
                '}';
    }

}

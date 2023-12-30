package com.example.sseproducer;

import lombok.*;

@Getter
@Setter
public class Employee {
    private final String firstName;
    private final String lastName;
    private final String uNumber;

    public Employee(String firstName, String lastName, String uNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uNumber = uNumber;
    }

    public String toString() {
        return firstName + " " + lastName + " " + uNumber;
    }
}

package com.example.ssereciever;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String firstName;
    private String lastName;
    private String uNumber;

    public Employee(String firstName, String lastName, String uNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uNumber = uNumber;
    }
}

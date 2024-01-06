package com.example.sseproducer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
public class Employee {
    @JsonProperty("firstName")
    private final String firstName;
    @JsonProperty("lastName")
    private final String lastName;
    @JsonProperty("uNumber")
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

package com.project.payroll.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emnployeeId;

    private String firstName;
    private String lastName;
    private char sex;

    public Employee() {
    };

    @Override
    public String toString() {

        return String.format(
            "Employee[id: %d, FirstName: %s, LastName: %s]",
            emnployeeId, firstName, lastName
        );
        
    }

    public Long getId() {
        return emnployeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getSex() {
        return sex;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

}

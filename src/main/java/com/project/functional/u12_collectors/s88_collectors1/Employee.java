package com.project.functional.u12_collectors.s88_collectors1;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Comparable<Employee>{

    private int id;
    private String name;
    private char gender;
    private Date dob;
    private String city;
    private String designation;
    private Date joiningDate;
    private double salary;

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.salary);
    }


}

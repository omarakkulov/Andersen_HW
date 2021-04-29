package ru.akkulov.model;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String date_of_birth;
    private int experience;
    private String date_of_employment;
    private String skill_level;
    private String eng_level;
    private String skype;
}

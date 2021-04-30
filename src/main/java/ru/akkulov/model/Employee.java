package ru.akkulov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private Date date_of_birth;
    private int experience;
    private Date date_of_employment;
    private Skill_level skill_level;
    private Eng_level eng_level;
    private String skype;

    public enum Skill_level {
        J1, J2, J3, M1, M2, M3, S1, S2, S3;
    }

    public enum Eng_level {
        A1, A2, B1, B2, C1, C2;
    }

}

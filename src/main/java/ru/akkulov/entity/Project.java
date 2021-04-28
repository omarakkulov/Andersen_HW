package ru.akkulov.entity;

import lombok.Data;

@Data
public class Project {
    private int id;
    private String name;
    private String customer;
    private int duration;
    private String methodology;
    private Long employer_id;
    private Long team_id;
}

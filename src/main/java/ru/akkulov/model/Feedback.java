package ru.akkulov.model;

import lombok.Data;

@Data
public class Feedback {
    private Long id;
    private String description;
    private Long employer_id;
    private String date;
}

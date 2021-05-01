package ru.akkulov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private int id;
    private String description;
    private LocalDate date;
    private int employee_id;
}

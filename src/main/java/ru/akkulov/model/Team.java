package ru.akkulov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private int id;
    private Names name;

    public enum Names {
        BACKEND, FRONTEND, MANAGEMENT
    }
}

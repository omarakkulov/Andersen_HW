package ru.akkulov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private int id;
    private String name;
    private Customer customer;
    private int duration;
    private Methodology methodology;
    private int team_id;

    public enum Customer {
        Person, Scientific_Corporation, Ministry_Of_Defence, Police
    }

    public enum Methodology {
        Object_Oriented_Programming,
        Functional_Programming,
        Procedural_Programming,
        Metaprogramming
    }
}

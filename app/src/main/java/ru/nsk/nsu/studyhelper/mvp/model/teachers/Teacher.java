package ru.nsk.nsu.studyhelper.mvp.model.teachers;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Teacher implements Serializable {
    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private String firstName;

    @Setter
    @Getter
    private String middleName;

    @Setter
    @Getter
    private String lastName;

    public String getFullName() {
        final char sep = ' ';
        return firstName + sep + middleName + sep + lastName;
    }
}

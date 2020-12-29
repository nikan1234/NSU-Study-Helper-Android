package ru.nsk.nsu.studyhelper.mvp.model.teachers;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class TeacherDetails implements Serializable {
    @Setter
    @Getter
    private String birthYear;

    @Setter
    @Getter
    private String status;

    @Setter
    @Getter
    private float rating;

    @Setter
    @Getter
    private TeacherRating currentUserRating;
}

package ru.nsk.nsu.studyhelper.mvp.model.teachers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class TeacherRatingToPost {
    @Setter
    @Getter
    private TeacherRating rating;

    @Setter
    @Getter
    Teacher teacher;
}

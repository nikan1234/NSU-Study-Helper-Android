package ru.nsk.nsu.studyhelper.mvp.model.teachers;

import androidx.annotation.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class TeacherRating {
    @Setter
    @Getter
    private Integer rating;

    @NonNull
    @Override
    public String toString() {
        return rating.toString();
    }
}

package ru.nsk.nsu.studyhelper.mvp.model.exam;

import androidx.annotation.NonNull;
import lombok.Getter;
import lombok.Setter;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.EntryYear;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.ExaminationType;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Semester;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Subject;

import java.io.Serializable;

public class Exam implements Serializable {
    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private EntryYear entryYear;

    @Setter
    @Getter
    private Semester semester;

    @Setter
    @Getter
    private Subject subject;

    @Setter
    @Getter
    private ExaminationType examinationType;

    @Override
    public @NonNull String toString() {
        return subject.toString();
    }
}

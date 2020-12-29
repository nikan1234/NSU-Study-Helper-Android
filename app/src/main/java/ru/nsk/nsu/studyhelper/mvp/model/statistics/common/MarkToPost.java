package ru.nsk.nsu.studyhelper.mvp.model.statistics.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;

@AllArgsConstructor
public class MarkToPost {
    @Setter
    @Getter
    private Exam exam;

    @Setter
    @Getter
    private Mark mark;
}

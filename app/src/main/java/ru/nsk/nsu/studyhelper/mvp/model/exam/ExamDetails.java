package ru.nsk.nsu.studyhelper.mvp.model.exam;

import lombok.Getter;
import lombok.Setter;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.Mark;

import java.io.Serializable;
import java.util.List;

public class ExamDetails implements Serializable {
    public static class MarkStatistic implements Serializable {
        @Setter
        @Getter
        private Mark mark;

        @Setter
        @Getter
        private int count;
    }

    @Setter
    @Getter
    private Mark currentUserMark;

    @Setter
    @Getter
    private List<MarkStatistic> markStatistics;
}

package ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.exam.ExamDetails;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.MarkToPost;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.*;

public class ExamStatisticsContract {

    abstract public static class Presenter extends BasePresenter<View> {
        public abstract void loadExaminationStatistics(final Exam exam);
        public abstract void sendUserMark(@NonNull final MarkToPost mark);
        public abstract boolean isAuthorized();
    }

    abstract public static class View extends BaseView {
        public abstract void showExaminationStatistics(final ExamDetails examDetails);
        public abstract void onUserMarkSent();
    }
}

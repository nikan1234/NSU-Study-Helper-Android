package ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.ExamCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BasePresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BaseView;


public class ExamCommentsContract {

    abstract public static class Presenter extends BasePresenter<View> {
        public abstract void loadSubjectComments(final Exam exam);
        public abstract void sendUserComment(@NonNull final ExamCommentToPost comment);

        public abstract boolean isAuthorized();
    }

    abstract public static class View extends BaseView {
        public abstract void showExaminationComments(final CommentStatistics commentStatistics);
        public abstract void onUserCommentSent();
    }
}

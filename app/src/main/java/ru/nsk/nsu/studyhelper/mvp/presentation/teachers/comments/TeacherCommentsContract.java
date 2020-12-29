package ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.TeacherCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BasePresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BaseView;

public class TeacherCommentsContract {

    abstract public static class Presenter extends BasePresenter<View> {
        public abstract void loadTeacherComments(final Teacher teacher);
        public abstract void sendUserComment(@NonNull final TeacherCommentToPost comment);
        public abstract boolean isAuthorized();
    }

    abstract public static class View extends BaseView {
        public abstract void showTeacherComments(final CommentStatistics commentStatistics);
        public abstract void onUserCommentSent();
    }
}

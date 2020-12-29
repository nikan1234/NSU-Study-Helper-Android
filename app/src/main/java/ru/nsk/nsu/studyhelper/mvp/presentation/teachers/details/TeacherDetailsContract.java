package ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details;

import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherDetails;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRatingToPost;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BasePresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BaseView;


public class TeacherDetailsContract {

    abstract public static class Presenter extends BasePresenter<View> {
        public abstract void loadTeacherDetails(final Teacher teacher);
        public abstract void sendTeacherRating(final TeacherRatingToPost rating);
        public abstract boolean isAuthorized();
    }

    abstract public static class View extends BaseView {
        public abstract void showTeacherDetails(final TeacherDetails teacherDetails);
        public abstract void onTeacherRationSent();
    }
}

package ru.nsk.nsu.studyhelper.mvp.presentation.exam.details;

import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.*;

import java.util.List;

public class ExamDetailsContract {

    abstract public static class Presenter extends BasePresenter<View> {
        public abstract void loadExamTeacherList(final Exam exam);
    }

    abstract public static class View extends BaseView {
        public abstract void showExamTeacherList(final List<Teacher> teachers);
    }
}

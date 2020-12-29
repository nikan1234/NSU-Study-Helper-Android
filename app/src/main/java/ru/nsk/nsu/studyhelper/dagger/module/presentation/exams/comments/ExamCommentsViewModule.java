package ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.comments;


import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments.ExamCommentsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments.ExamCommentsFragment;

@Module
public abstract class ExamCommentsViewModule {

    @Binds
    abstract ExamCommentsContract.View bindView(ExamCommentsFragment fragment);
}

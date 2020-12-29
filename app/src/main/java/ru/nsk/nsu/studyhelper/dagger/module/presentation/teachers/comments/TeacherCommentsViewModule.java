package ru.nsk.nsu.studyhelper.dagger.module.presentation.teachers.comments;

import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments.TeacherCommentsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments.TeacherCommentsFragment;

@Module
public abstract class TeacherCommentsViewModule {

    @Binds
    abstract TeacherCommentsContract.View bindView(TeacherCommentsFragment fragment);
}

package ru.nsk.nsu.studyhelper.dagger.module.presentation.teachers.comments;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments.TeacherCommentsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments.TeacherCommentsPresenter;

@Module
public class TeacherCommentsModule {

    @Provides
    TeacherCommentsContract.Presenter providePresenter(final TeacherCommentsContract.View view) {
        return new TeacherCommentsPresenter(view);
    }
}

package ru.nsk.nsu.studyhelper.dagger.module.presentation.teachers.details;


import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details.TeacherDetailsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details.TeacherDetailsPresenter;

@Module
public class TeacherDetailsModule {

    @Provides
    TeacherDetailsContract.Presenter providePresenter(TeacherDetailsContract.View view) {
        return new TeacherDetailsPresenter(view);
    }
}

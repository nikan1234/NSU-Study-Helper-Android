package ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.details;


import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.details.ExamDetailsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.details.ExamDetailsPresenter;

@Module
public class ExamDetailsModule {

    @Provides
    ExamDetailsContract.Presenter providePresenter(ExamDetailsContract.View view) {
        return new ExamDetailsPresenter(view);
    }
}

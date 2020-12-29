package ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.comments;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments.ExamCommentsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments.ExamCommentsPresenter;

@Module
public class ExamCommentsModule {

    @Provides
    ExamCommentsContract.Presenter providePresenter(final ExamCommentsContract.View view) {
        return new ExamCommentsPresenter(view);
    }
}

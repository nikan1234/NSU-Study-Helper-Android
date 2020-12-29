package ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.details;

import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.details.ExamDetailsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.details.ExamDetailsFragment;

@Module
public abstract class ExamDetailsViewModule {

    @Binds
    abstract ExamDetailsContract.View provideView(ExamDetailsFragment examDetailsFragment);
}

package ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.statistics;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.ExamStatisticsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.ExamStatisticsPresenter;

@Module
public class ExamStatisticsModule {

    @Provides
    ExamStatisticsContract.Presenter providePresenter(final ExamStatisticsContract.View view) {
        return new ExamStatisticsPresenter(view);
    }
}

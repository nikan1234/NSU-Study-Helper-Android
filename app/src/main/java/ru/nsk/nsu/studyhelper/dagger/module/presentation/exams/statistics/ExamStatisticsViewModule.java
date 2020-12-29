package ru.nsk.nsu.studyhelper.dagger.module.presentation.exams.statistics;


import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.ExamStatisticsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.ExamStatisticsFragment;

@Module
public abstract class ExamStatisticsViewModule {

    @Binds
    abstract ExamStatisticsContract.View bindView(ExamStatisticsFragment examStatisticsFragment);
}

package ru.nsk.nsu.studyhelper.dagger.module.data.exams;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.data.exams.ExamDetailsRepository;

import javax.inject.Singleton;

@Module
public class ExamDetailsDataSourceModule {
    private final IExamDetailsDataSource examDetailsDataSource;

    public ExamDetailsDataSourceModule() {
        examDetailsDataSource = ExamDetailsRepository.getInstance();
    }

    @Provides
    @Singleton
    IExamDetailsDataSource getExamDetailsDataSource() {
        return examDetailsDataSource;
    }
}

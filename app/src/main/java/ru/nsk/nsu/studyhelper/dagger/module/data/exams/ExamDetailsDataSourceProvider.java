package ru.nsk.nsu.studyhelper.dagger.module.data.exams;

public class ExamDetailsDataSourceProvider {
    private static final ExamDetailsDataSourceComponent appComponent =
            DaggerExamDetailsDataSourceComponent.create();

    static public ExamDetailsDataSourceComponent getAppComponent() {
        return appComponent;
    }
}

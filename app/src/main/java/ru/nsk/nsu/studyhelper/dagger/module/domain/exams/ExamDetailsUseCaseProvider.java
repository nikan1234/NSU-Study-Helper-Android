package ru.nsk.nsu.studyhelper.dagger.module.domain.exams;

public class ExamDetailsUseCaseProvider {
    private static final ExamDetailsUseCaseComponent appComponent =
            DaggerExamDetailsUseCaseComponent.create();

    public static ExamDetailsUseCaseComponent getAppComponent() {
        return appComponent;
    }
}

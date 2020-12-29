package ru.nsk.nsu.studyhelper.dagger.module.domain.teachers;

public class TeacherDetailsUseCaseProvider {
    private static final TeacherDetailsUseCaseComponent appComponent =
            DaggerTeacherDetailsUseCaseComponent.create();

    public static TeacherDetailsUseCaseComponent getAppComponent() {
        return appComponent;
    }
}

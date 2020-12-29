package ru.nsk.nsu.studyhelper.dagger.module.data.teachers;

public class TeacherDetailsDataSourceProvider {

    private static final TeacherDetailsDataSourceComponent appComponent =
            DaggerTeacherDetailsDataSourceComponent.create();

    static public TeacherDetailsDataSourceComponent getAppComponent() {
        return appComponent;
    }
}

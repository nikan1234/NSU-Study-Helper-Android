package ru.nsk.nsu.studyhelper.dagger.module.data.teachers;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.data.teachers.ITeacherDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.data.teachers.TeacherDetailsRepository;

import javax.inject.Singleton;

@Module
public class TeacherDetailsDataSourceModule {
    private final ITeacherDetailsDataSource teachersDetailsDataSource;

    public TeacherDetailsDataSourceModule() {
        teachersDetailsDataSource = TeacherDetailsRepository.getInstance();
    }

    @Provides
    @Singleton
    ITeacherDetailsDataSource getTeacherDetailsDataSource() {
        return teachersDetailsDataSource;
    }
}

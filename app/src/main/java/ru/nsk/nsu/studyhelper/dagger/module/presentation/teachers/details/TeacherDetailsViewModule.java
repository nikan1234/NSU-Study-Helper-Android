package ru.nsk.nsu.studyhelper.dagger.module.presentation.teachers.details;

import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.details.ExamDetailsFragment;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details.TeacherDetailsContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details.TeacherDetailsFragment;

@Module
public abstract class TeacherDetailsViewModule {

    @Binds
    abstract TeacherDetailsContract.View provideView(TeacherDetailsFragment teacherDetailsFragment);
}

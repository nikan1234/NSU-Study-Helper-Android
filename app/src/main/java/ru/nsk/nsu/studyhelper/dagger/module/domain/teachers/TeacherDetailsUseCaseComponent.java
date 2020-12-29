package ru.nsk.nsu.studyhelper.dagger.module.domain.teachers;


import dagger.Component;
import ru.nsk.nsu.studyhelper.dagger.module.data.authToken.AuthTokenHolderModule;
import ru.nsk.nsu.studyhelper.dagger.module.domain.common.UseCaseExecutorModule;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments.TeacherCommentsPresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details.TeacherDetailsPresenter;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AuthTokenHolderModule.class,
        TeacherDetailsUseCaseModule.class,
        UseCaseExecutorModule.class
})
public interface TeacherDetailsUseCaseComponent {
    void inject(TeacherCommentsPresenter presenter);
    void inject(TeacherDetailsPresenter presenter);
}

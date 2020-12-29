package ru.nsk.nsu.studyhelper.dagger.module.domain.exams;


import dagger.Component;
import ru.nsk.nsu.studyhelper.dagger.module.data.authToken.AuthTokenHolderModule;
import ru.nsk.nsu.studyhelper.dagger.module.domain.common.UseCaseExecutorModule;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.details.ExamDetailsPresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.ExamStatisticsPresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments.ExamCommentsPresenter;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AuthTokenHolderModule.class,
        ExamDetailsUseCaseModule.class,
        UseCaseExecutorModule.class
})
public interface ExamDetailsUseCaseComponent {
    void inject(ExamStatisticsPresenter presenter);
    void inject(ExamCommentsPresenter presenter);
    void inject(ExamDetailsPresenter presenter);
}

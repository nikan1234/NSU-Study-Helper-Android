package ru.nsk.nsu.studyhelper.dagger.module.data.exams;

import dagger.Component;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.comments.SendUserCommentUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.details.LoadExamTeacherListUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.statistics.LoadExamDetailsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.comments.LoadExamCommentsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.statistics.SendUserMarkUseCase;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        ExamDetailsDataSourceModule.class
})
public interface ExamDetailsDataSourceComponent {
    void inject(LoadExamDetailsUseCase useCase);
    void inject(LoadExamCommentsUseCase useCase);
    void inject(LoadExamTeacherListUseCase useCase);
    void inject(SendUserMarkUseCase userCase);
    void inject(SendUserCommentUseCase userCase);
}

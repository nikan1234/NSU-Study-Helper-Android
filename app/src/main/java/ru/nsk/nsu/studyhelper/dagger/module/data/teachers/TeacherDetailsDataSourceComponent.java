package ru.nsk.nsu.studyhelper.dagger.module.data.teachers;

import dagger.Component;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.comments.LoadTeacherCommentsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.comments.SendUserCommentUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.statistics.LoadTeacherDetailsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.statistics.SendTeacherRatingUseCase;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        TeacherDetailsDataSourceModule.class
})
public interface TeacherDetailsDataSourceComponent {
    void inject(LoadTeacherDetailsUseCase useCase);
    void inject(LoadTeacherCommentsUseCase useCase);
    void inject(SendUserCommentUseCase useCase);
    void inject(SendTeacherRatingUseCase useCase);
}

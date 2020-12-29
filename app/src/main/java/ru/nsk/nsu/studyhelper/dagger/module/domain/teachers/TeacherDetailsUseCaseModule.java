package ru.nsk.nsu.studyhelper.dagger.module.domain.teachers;


import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.comments.LoadTeacherCommentsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.comments.SendUserCommentUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.statistics.LoadTeacherDetailsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.statistics.SendTeacherRatingUseCase;

import javax.inject.Singleton;

@Module
public class TeacherDetailsUseCaseModule {
    private final LoadTeacherDetailsUseCase loadTeacherDetailsUseCase;
    private final LoadTeacherCommentsUseCase loadTeacherCommentsUseCase;
    private final SendUserCommentUseCase sendUserCommentUseCase;
    private final SendTeacherRatingUseCase sendTeacherRatingUseCase;

    public TeacherDetailsUseCaseModule() {
        loadTeacherDetailsUseCase = new LoadTeacherDetailsUseCase();
        loadTeacherCommentsUseCase = new LoadTeacherCommentsUseCase();
        sendUserCommentUseCase = new SendUserCommentUseCase();
        sendTeacherRatingUseCase = new SendTeacherRatingUseCase();
    }


    @Provides
    @Singleton
    LoadTeacherDetailsUseCase getLoadTeacherDetailsUseCase() {
        return loadTeacherDetailsUseCase;
    }

    @Provides
    @Singleton
    LoadTeacherCommentsUseCase getLoadTeacherCommentsUseCase() {
        return loadTeacherCommentsUseCase;
    }

    @Provides
    @Singleton
    SendUserCommentUseCase getSendUserCommentUseCase() { return sendUserCommentUseCase; }

    @Provides
    @Singleton
    SendTeacherRatingUseCase getSendTeacherRatingUseCase() { return sendTeacherRatingUseCase; }
}

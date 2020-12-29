package ru.nsk.nsu.studyhelper.dagger.module.domain.exams;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.comments.SendUserCommentUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.statistics.LoadExamDetailsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.details.LoadExamTeacherListUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.comments.LoadExamCommentsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.statistics.SendUserMarkUseCase;

import javax.inject.Singleton;

@Module
public class ExamDetailsUseCaseModule {
    private final LoadExamDetailsUseCase loadExamDetailsUseCase;
    private final LoadExamCommentsUseCase loadExamCommentsUseCase;
    private final LoadExamTeacherListUseCase loadExamTeacherListUseCase;
    private final SendUserMarkUseCase sendUserMarkUseCase;
    private final SendUserCommentUseCase sendUserCommentUseCase;

    public ExamDetailsUseCaseModule() {
        loadExamDetailsUseCase = new LoadExamDetailsUseCase();
        loadExamCommentsUseCase = new LoadExamCommentsUseCase();
        loadExamTeacherListUseCase = new LoadExamTeacherListUseCase();
        sendUserMarkUseCase = new SendUserMarkUseCase();
        sendUserCommentUseCase = new SendUserCommentUseCase();
    }

    @Provides
    @Singleton
    LoadExamDetailsUseCase getLoadSubjectStatisticsUseCase() {
        return loadExamDetailsUseCase;
    }

    @Provides
    @Singleton
    LoadExamCommentsUseCase getLoadSubjectCommentsUseCase() {
        return loadExamCommentsUseCase;
    }

    @Provides
    @Singleton
    public LoadExamTeacherListUseCase getLoadTeacherListUseCase() {
        return loadExamTeacherListUseCase;
    }

    @Provides
    @Singleton
    public SendUserMarkUseCase getSendUserMarkUseCase() {
        return sendUserMarkUseCase;
    }

    @Provides
    @Singleton
    public SendUserCommentUseCase getSendUserCommentUseCase() {
        return sendUserCommentUseCase;
    }
}

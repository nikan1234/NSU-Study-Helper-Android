package ru.nsk.nsu.studyhelper.mvp.presentation.exam.comments;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.domain.exams.ExamDetailsUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.IAuthTokenHolder;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.comments.LoadExamCommentsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.comments.SendUserCommentUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.ExamCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;

public class ExamCommentsPresenter extends ExamCommentsContract.Presenter {

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    LoadExamCommentsUseCase loadExamCommentsUseCase;

    @Inject
    SendUserCommentUseCase sendUserCommentUseCase;

    @Inject
    IAuthTokenHolder authTokenHolder;

    public ExamCommentsPresenter(final ExamCommentsContract.View view) {
        ExamDetailsUseCaseProvider.getAppComponent().inject(this);
        linkView(view);
    }

    @Override
    public void loadSubjectComments(Exam exam) {
        useCaseExecutor.execute(loadExamCommentsUseCase, exam,
                new UseCase.IUseCaseCallback<CommentStatistics, DomainLayerError>() {
            @Override
            public void onSuccess(CommentStatistics successResponse) {
                if (getView() != null) {
                    getView().showExaminationComments(successResponse);
                }
            }

            @Override
            public void onError(DomainLayerError error) {
                if (getView() != null) {
                    getView().showError(PresentationLayerErrorCreator.create(error));
                }
            }
        });
    }

    @Override
    public void sendUserComment(final @NonNull ExamCommentToPost mark) {
        useCaseExecutor.execute(sendUserCommentUseCase, mark,
                new UseCase.IUseCaseCallback<Void, DomainLayerError>() {
                    @Override
                    public void onSuccess(Void successResponse) {
                        if (getView() != null) {
                            getView().onUserCommentSent();
                        }
                    }

                    @Override
                    public void onError(DomainLayerError error) {
                        if (getView() != null) {
                            getView().showError(PresentationLayerErrorCreator.create(error));
                        }
                    }
                });
    }

    @Override
    public boolean isAuthorized() {
        return (authTokenHolder.getToken() != null);
    }
}

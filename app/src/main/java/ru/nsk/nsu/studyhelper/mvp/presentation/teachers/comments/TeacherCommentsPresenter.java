package ru.nsk.nsu.studyhelper.mvp.presentation.teachers.comments;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.domain.teachers.TeacherDetailsUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.IAuthTokenHolder;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.comments.LoadTeacherCommentsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.comments.SendUserCommentUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.TeacherCommentToPost;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;

public class TeacherCommentsPresenter extends TeacherCommentsContract.Presenter {

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    LoadTeacherCommentsUseCase loadTeacherCommentsUseCase;

    @Inject
    SendUserCommentUseCase sendUserCommentUseCase;

    @Inject
    IAuthTokenHolder authTokenHolder;

    public TeacherCommentsPresenter(final TeacherCommentsContract.View view) {
        TeacherDetailsUseCaseProvider.getAppComponent().inject(this);
        linkView(view);
    }

    @Override
    public void loadTeacherComments(Teacher teacher) {
        useCaseExecutor.execute(loadTeacherCommentsUseCase, teacher,
                new UseCase.IUseCaseCallback<CommentStatistics, DomainLayerError>() {
            @Override
            public void onSuccess(CommentStatistics successResponse) {
                if (getView() != null) {
                    getView().showTeacherComments(successResponse);
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
    public void sendUserComment(final @NonNull TeacherCommentToPost comment) {
        useCaseExecutor.execute(sendUserCommentUseCase, comment,
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

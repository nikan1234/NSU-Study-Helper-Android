package ru.nsk.nsu.studyhelper.mvp.presentation.teachers.details;

import ru.nsk.nsu.studyhelper.dagger.module.domain.teachers.TeacherDetailsUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.IAuthTokenHolder;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.statistics.LoadTeacherDetailsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.teachers.statistics.SendTeacherRatingUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherDetails;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRatingToPost;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;

public class TeacherDetailsPresenter extends TeacherDetailsContract.Presenter {

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    LoadTeacherDetailsUseCase loadTeacherDetailsUseCase;

    @Inject
    SendTeacherRatingUseCase sendTeacherRatingUseCase;

    @Inject
    IAuthTokenHolder authTokenHolder;

    public TeacherDetailsPresenter(final TeacherDetailsContract.View view) {
        TeacherDetailsUseCaseProvider.getAppComponent().inject(this);
        linkView(view);
    }

    @Override
    public void loadTeacherDetails(Teacher teacher) {
        useCaseExecutor.execute(loadTeacherDetailsUseCase, teacher,
                new UseCase.IUseCaseCallback<TeacherDetails, DomainLayerError>() {
            @Override
            public void onSuccess(TeacherDetails successResponse) {
                if (getView() != null) {
                    getView().showTeacherDetails(successResponse);
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
    public void sendTeacherRating(TeacherRatingToPost rating) {
        useCaseExecutor.execute(sendTeacherRatingUseCase, rating,
                new UseCase.IUseCaseCallback<Void, DomainLayerError>() {
            @Override
            public void onSuccess(Void successResponse) {
                if (getView() != null) {
                    getView().onTeacherRationSent();
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

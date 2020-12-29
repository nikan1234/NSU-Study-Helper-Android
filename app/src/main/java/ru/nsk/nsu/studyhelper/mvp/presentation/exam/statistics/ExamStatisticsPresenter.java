package ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.domain.exams.ExamDetailsUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.IAuthTokenHolder;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.statistics.LoadExamDetailsUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.statistics.SendUserMarkUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.exam.ExamDetails;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.MarkToPost;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;

public class ExamStatisticsPresenter extends ExamStatisticsContract.Presenter {

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    IAuthTokenHolder authTokenHolder;

    @Inject
    LoadExamDetailsUseCase loadExamDetailsUseCase;

    @Inject
    SendUserMarkUseCase sendUserMarkUseCase;

    public ExamStatisticsPresenter(final ExamStatisticsContract.View view) {
        ExamDetailsUseCaseProvider.getAppComponent().inject(this);
        linkView(view);
    }

    @Override
    public void loadExaminationStatistics(Exam exam) {
        useCaseExecutor.execute(loadExamDetailsUseCase, exam,
                new UseCase.IUseCaseCallback<ExamDetails, DomainLayerError>() {
            @Override
            public void onSuccess(ExamDetails successResponse) {
                if (getView() != null) {
                    getView().showExaminationStatistics(successResponse);
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
    public void sendUserMark(final @NonNull MarkToPost mark) {
        useCaseExecutor.execute(sendUserMarkUseCase, mark,
                new UseCase.IUseCaseCallback<Void, DomainLayerError>() {
            @Override
            public void onSuccess(Void successResponse) {
                if (getView() != null) {
                    getView().onUserMarkSent();
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

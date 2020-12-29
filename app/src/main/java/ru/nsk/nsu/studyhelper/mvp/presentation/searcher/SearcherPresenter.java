package ru.nsk.nsu.studyhelper.mvp.presentation.searcher;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.domain.searcher.SearcherUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.searcher.LoadEntryYearListUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.searcher.LoadExamListUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.searcher.LoadSemesterListUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.EntryYear;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Semester;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;
import java.util.List;

public class SearcherPresenter extends SearcherContract.Presenter {

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    LoadEntryYearListUseCase loadEntryYearListUseCase;

    @Inject
    LoadSemesterListUseCase loadSemesterListUseCase;

    @Inject
    LoadExamListUseCase loadExamListUseCase;

    public SearcherPresenter(@NonNull final SearcherContract.View view) {
        SearcherUseCaseProvider.getAppComponent().inject(this);
        linkView(view);
    }

    @Override
    public void loadEntryYearList() {
        useCaseExecutor.execute(loadEntryYearListUseCase, null,
                new UseCase.IUseCaseCallback<List<EntryYear>, DomainLayerError>() {
                    @Override
                    public void onSuccess(List<EntryYear> successResponse) {
                        if (getView() != null) {
                            getView().showEntryYearList(successResponse);
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
    public void loadSemesterList() {
        useCaseExecutor.execute(loadSemesterListUseCase, null,
                new UseCase.IUseCaseCallback<List<Semester>, DomainLayerError>() {
                    @Override
                    public void onSuccess(List<Semester> successResponse) {
                        if (getView() != null) {
                            getView().showSemesterList(successResponse);
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
    public void loadExaminationList(@NonNull final EntryYear year, @NonNull final Semester semester) {
        useCaseExecutor.execute(loadExamListUseCase,
                new LoadExamListUseCase.ExaminationRequestData(year, semester),
                new UseCase.IUseCaseCallback<List<Exam>, DomainLayerError>() {
                    @Override
                    public void onSuccess(List<Exam> successResponse) {
                        if (getView() != null) {
                            getView().showExaminationList(successResponse);
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
}

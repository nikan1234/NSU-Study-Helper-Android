package ru.nsk.nsu.studyhelper.mvp.presentation.exam.details;

import ru.nsk.nsu.studyhelper.dagger.module.domain.exams.ExamDetailsUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.exams.details.LoadExamTeacherListUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;
import java.util.List;

public class ExamDetailsPresenter extends ExamDetailsContract.Presenter {

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    LoadExamTeacherListUseCase loadExamTeacherListUseCase;

    public ExamDetailsPresenter(final ExamDetailsContract.View view) {
        ExamDetailsUseCaseProvider.getAppComponent().inject(this);
        linkView(view);
    }

    @Override
    public void loadExamTeacherList(Exam exam) {
        useCaseExecutor.execute(loadExamTeacherListUseCase, exam,
                new UseCase.IUseCaseCallback<List<Teacher>, DomainLayerError>() {
            @Override
            public void onSuccess(List<Teacher> successResponse) {
                if (getView() != null) {
                    getView().showExamTeacherList(successResponse);
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

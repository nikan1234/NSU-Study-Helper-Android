package ru.nsk.nsu.studyhelper.mvp.domain.exams.statistics;

import org.jetbrains.annotations.NotNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.exams.ExamDetailsDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.UnknownError;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.exam.ExamDetails;

import javax.inject.Inject;

public class LoadExamDetailsUseCase extends UseCase<Exam, ExamDetails> {

    @Inject
    IExamDetailsDataSource subjectsDataSource;

    public LoadExamDetailsUseCase() {
        ExamDetailsDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(Exam requestValues) {
        subjectsDataSource.loadExamStatistics(new IExamDetailsDataSource.ILoadCallback<ExamDetails>() {
            @Override
            public void loadSuccess(final @NotNull ExamDetails subjects) {
                getCallback().onSuccess(subjects);
            }

            @Override
            public void loadFailure(final @NotNull DataLayerError error) {
                getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
            }
        }, requestValues);
    }
}

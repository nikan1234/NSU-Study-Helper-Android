package ru.nsk.nsu.studyhelper.mvp.domain.exams.comments;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.exams.ExamDetailsDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;

import javax.inject.Inject;

public class LoadExamCommentsUseCase extends UseCase<Exam, CommentStatistics> {

    @Inject
    IExamDetailsDataSource subjectsDataSource;

    public LoadExamCommentsUseCase() {
        ExamDetailsDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(Exam requestValues) {
        subjectsDataSource.loadExamComments(new IExamDetailsDataSource.ILoadCallback<CommentStatistics>() {
            @Override
            public void loadSuccess(final @NonNull CommentStatistics data) {
                getCallback().onSuccess(data);
            }

            @Override
            public void loadFailure(final @NonNull DataLayerError error) {
                getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
            }
        }, requestValues);
    }
}

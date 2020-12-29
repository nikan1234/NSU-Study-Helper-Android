package ru.nsk.nsu.studyhelper.mvp.domain.exams.comments;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.exams.ExamDetailsDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.ExamCommentToPost;

import javax.inject.Inject;

public class SendUserCommentUseCase extends UseCase<ExamCommentToPost, Void> {

    @Inject
    IExamDetailsDataSource examDetailsDataSource;

    public SendUserCommentUseCase() {
        ExamDetailsDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(ExamCommentToPost requestValues) {
        examDetailsDataSource.sendUserComment(new IExamDetailsDataSource.ILoadCallback<Void>() {
            @Override
            public void loadSuccess(final @NonNull Void data) {
                getCallback().onSuccess(data);
            }

            @Override
            public void loadFailure(final @NonNull DataLayerError error) {
                getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
            }
        }, requestValues);
    }
}

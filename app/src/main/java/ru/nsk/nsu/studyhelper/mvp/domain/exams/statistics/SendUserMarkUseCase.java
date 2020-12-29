package ru.nsk.nsu.studyhelper.mvp.domain.exams.statistics;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.exams.ExamDetailsDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.Mark;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.common.MarkToPost;

import javax.inject.Inject;

public class SendUserMarkUseCase extends UseCase<MarkToPost, Void> {

    @Inject
    IExamDetailsDataSource examDetailsDataSource;

    public SendUserMarkUseCase() {
        ExamDetailsDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(MarkToPost requestValues) {
        examDetailsDataSource.sendUserMark(new IExamDetailsDataSource.ILoadCallback<Void>() {
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

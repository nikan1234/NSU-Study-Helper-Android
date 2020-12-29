package ru.nsk.nsu.studyhelper.mvp.domain.exams.details;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.exams.ExamDetailsDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;

import javax.inject.Inject;
import java.util.List;

public class LoadExamTeacherListUseCase extends UseCase<Exam, List<Teacher>> {

    @Inject
    IExamDetailsDataSource examDetailsDataSource;

    public LoadExamTeacherListUseCase() {
        ExamDetailsDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(Exam requestValues) {
        examDetailsDataSource.loadExamTeacherList(new IExamDetailsDataSource.ILoadCallback<List<Teacher>>() {
            @Override
            public void loadSuccess(final @NonNull List<Teacher> list) {
                getCallback().onSuccess(list);
            }

            @Override
            public void loadFailure(final @NonNull DataLayerError error) {
                getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
            }
        }, requestValues);
    }
}

package ru.nsk.nsu.studyhelper.mvp.domain.teachers.statistics;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.teachers.TeacherDetailsDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.data.teachers.ITeacherDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherRatingToPost;

import javax.inject.Inject;

public class SendTeacherRatingUseCase extends UseCase<TeacherRatingToPost, Void> {

    @Inject
    ITeacherDetailsDataSource teacherDetailsDataSource;

    public SendTeacherRatingUseCase() {
        TeacherDetailsDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(TeacherRatingToPost requestValues) {
        teacherDetailsDataSource.sendTeacherRating(new IExamDetailsDataSource.ILoadCallback<Void>() {
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

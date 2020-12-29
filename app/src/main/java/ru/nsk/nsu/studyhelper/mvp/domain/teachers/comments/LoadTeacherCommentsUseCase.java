package ru.nsk.nsu.studyhelper.mvp.domain.teachers.comments;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.teachers.TeacherDetailsDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.teachers.ITeacherDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.CommentStatistics;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;

import javax.inject.Inject;


public class LoadTeacherCommentsUseCase extends UseCase<Teacher, CommentStatistics> {

    @Inject
    ITeacherDetailsDataSource teachersDataSource;

    public LoadTeacherCommentsUseCase() {
        TeacherDetailsDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(Teacher requestValues) {
        teachersDataSource.loadTeacherComments(
                new ITeacherDetailsDataSource.ILoadCallback<CommentStatistics>() {
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

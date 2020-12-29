package ru.nsk.nsu.studyhelper.mvp.domain.teachers.comments;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.teachers.TeacherDetailsDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.data.teachers.ITeacherDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.statistics.comments.TeacherCommentToPost;

import javax.inject.Inject;

public class SendUserCommentUseCase extends UseCase<TeacherCommentToPost, Void> {

    @Inject
    ITeacherDetailsDataSource teacherDetailsDataSource;

    public SendUserCommentUseCase() {
        TeacherDetailsDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(TeacherCommentToPost requestValues) {
        teacherDetailsDataSource.sendUserComment(
                new IExamDetailsDataSource.ILoadCallback<Void>() {
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

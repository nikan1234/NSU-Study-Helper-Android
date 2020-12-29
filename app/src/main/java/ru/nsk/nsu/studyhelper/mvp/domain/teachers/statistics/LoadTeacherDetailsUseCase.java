package ru.nsk.nsu.studyhelper.mvp.domain.teachers.statistics;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.teachers.TeacherDetailsDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.teachers.ITeacherDetailsDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.Teacher;
import ru.nsk.nsu.studyhelper.mvp.model.teachers.TeacherDetails;

import javax.inject.Inject;

public class LoadTeacherDetailsUseCase extends UseCase<Teacher, TeacherDetails> {
    @Inject
    ITeacherDetailsDataSource teachersDataSource;

    public LoadTeacherDetailsUseCase() {
        TeacherDetailsDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(Teacher requestValues) {
        teachersDataSource.loadTeacherDetails(
                new ITeacherDetailsDataSource.ILoadCallback<TeacherDetails>() {
                    @Override
                    public void loadSuccess(final @NonNull TeacherDetails data) {
                        getCallback().onSuccess(data);
                    }

                    @Override
                    public void loadFailure(final @NonNull DataLayerError error) {
                        getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
                    }
                }, requestValues);
    }
}

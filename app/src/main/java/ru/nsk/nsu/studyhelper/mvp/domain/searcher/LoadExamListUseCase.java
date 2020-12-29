package ru.nsk.nsu.studyhelper.mvp.domain.searcher;

import androidx.annotation.NonNull;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.searcher.SearcherDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.searcher.ISearcherDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.UnknownError;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.EntryYear;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Semester;

import javax.inject.Inject;
import java.util.List;

public class LoadExamListUseCase
        extends UseCase<LoadExamListUseCase.ExaminationRequestData, List<Exam>> {

    public static class ExaminationRequestData {
        @Getter final EntryYear entryYear;
        @Getter final Semester semester;

        public ExaminationRequestData(EntryYear entryYear, Semester semester) {
            this.entryYear = entryYear;
            this.semester = semester;
        }
    }

    @Inject
    ISearcherDataSource searcherDataSource;

    public LoadExamListUseCase() {
        SearcherDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(ExaminationRequestData requestValues) {
        searcherDataSource.loadExaminationList(new ISearcherDataSource.ILoadCallback<Exam>() {
            @Override
            public void loadSuccess(final @NonNull List<Exam> entryYears) {
                getCallback().onSuccess(entryYears);
            }

            @Override
            public void loadFailure(final @NonNull DataLayerError error) {
                getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
            }
        }, requestValues.getEntryYear(), requestValues.getSemester());
    }
}

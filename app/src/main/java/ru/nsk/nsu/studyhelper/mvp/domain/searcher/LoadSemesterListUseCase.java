package ru.nsk.nsu.studyhelper.mvp.domain.searcher;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.searcher.SearcherDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.searcher.ISearcherDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.UnknownError;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.Semester;

import javax.inject.Inject;
import java.util.List;

public class LoadSemesterListUseCase extends UseCase<Void, List<Semester>> {

    @Inject
    ISearcherDataSource searcherDataSource;

    public LoadSemesterListUseCase() {
        SearcherDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(Void requestValues) {
        searcherDataSource.loadSemesterList(new ISearcherDataSource.ILoadCallback<Semester>() {
            @Override
            public void loadSuccess(@NonNull @NotNull List<Semester> entryYears) {
                getCallback().onSuccess(entryYears);
            }

            @Override
            public void loadFailure(@NonNull @NotNull DataLayerError error) {
                getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
            }
        });
    }
}

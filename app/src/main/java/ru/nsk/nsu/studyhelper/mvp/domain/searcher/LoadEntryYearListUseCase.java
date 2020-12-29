package ru.nsk.nsu.studyhelper.mvp.domain.searcher;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.searcher.SearcherDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.searcher.ISearcherDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.UnknownError;
import ru.nsk.nsu.studyhelper.mvp.model.searcher.EntryYear;

import javax.inject.Inject;
import java.util.List;

public class LoadEntryYearListUseCase extends UseCase<Void, List<EntryYear>> {

    @Inject
    ISearcherDataSource searcherDataSource;

    public LoadEntryYearListUseCase() {
        SearcherDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(Void requestValues) {
        searcherDataSource.loadEntryYearList(new ISearcherDataSource.ILoadCallback<EntryYear>() {
            @Override
            public void loadSuccess(@NonNull final List<EntryYear> entryYears) {
                getCallback().onSuccess(entryYears);
            }

            @Override
            public void loadFailure(@NonNull final DataLayerError error) {
                getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
            }
        });
    }
}

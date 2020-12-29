package ru.nsk.nsu.studyhelper.dagger.module.data.searcher;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.data.searcher.ISearcherDataSource;
import ru.nsk.nsu.studyhelper.mvp.data.searcher.SearcherRepository;

import javax.inject.Singleton;

@Module
public class SearcherDataSourceModule {
    private final ISearcherDataSource repository;

    public SearcherDataSourceModule() {
        repository = SearcherRepository.getInstance();
    }

    @Provides
    @Singleton
    ISearcherDataSource getSearcherDataSource() {
        return repository;
    }
}

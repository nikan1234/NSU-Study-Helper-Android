package ru.nsk.nsu.studyhelper.dagger.module.presentation.searcher;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.searcher.SearcherContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.searcher.SearcherPresenter;

@Module
public class SearcherModule {
    @Provides
    SearcherContract.Presenter providePresenter(SearcherContract.View view) {
        return new SearcherPresenter(view);
    }
}
package ru.nsk.nsu.studyhelper.dagger.module.presentation.searcher;

import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.searcher.SearcherContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.searcher.SearcherFragment;

@Module
public abstract class SearcherViewModule {

    @Binds
    abstract SearcherContract.View provideView(SearcherFragment searcherFragment);
}

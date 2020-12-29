package ru.nsk.nsu.studyhelper.dagger.module.domain.searcher;

import dagger.Component;
import ru.nsk.nsu.studyhelper.dagger.module.domain.common.UseCaseExecutorModule;
import ru.nsk.nsu.studyhelper.mvp.presentation.searcher.SearcherPresenter;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        SearcherUseCaseModule.class,
        UseCaseExecutorModule.class
})
public interface SearcherUseCaseComponent {
    void inject(SearcherPresenter presenter);
}

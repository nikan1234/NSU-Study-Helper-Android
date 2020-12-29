package ru.nsk.nsu.studyhelper.dagger.module.data.searcher;

import dagger.Component;
import ru.nsk.nsu.studyhelper.mvp.domain.searcher.LoadEntryYearListUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.searcher.LoadExamListUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.searcher.LoadSemesterListUseCase;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        SearcherDataSourceModule.class
})
public interface SearcherDataSourceComponent {

    void inject(LoadEntryYearListUseCase useCase);
    void inject(LoadSemesterListUseCase useCase);
    void inject(LoadExamListUseCase useCase);
}

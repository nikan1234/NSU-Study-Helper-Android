package ru.nsk.nsu.studyhelper.dagger.module.domain.searcher;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.domain.searcher.LoadEntryYearListUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.searcher.LoadExamListUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.searcher.LoadSemesterListUseCase;

import javax.inject.Singleton;

@Module
public class SearcherUseCaseModule {
    private final LoadEntryYearListUseCase loadEntryYearListUseCase;
    private final LoadSemesterListUseCase loadSemesterListUseCase;
    private final LoadExamListUseCase loadExamListUseCase;

    public SearcherUseCaseModule() {
        loadEntryYearListUseCase = new LoadEntryYearListUseCase();
        loadSemesterListUseCase = new LoadSemesterListUseCase();
        loadExamListUseCase = new LoadExamListUseCase();
    }

    @Provides
    @Singleton
    public LoadEntryYearListUseCase getLoadEntryYearListUseCase() {
        return loadEntryYearListUseCase;
    }

    @Provides
    @Singleton
    public LoadSemesterListUseCase getLoadSemesterListUseCase() {
        return loadSemesterListUseCase;
    }

    @Provides
    @Singleton
    public LoadExamListUseCase getLoadExaminationListUseCase() {
        return loadExamListUseCase;
    }
}

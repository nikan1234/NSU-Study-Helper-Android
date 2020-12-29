package ru.nsk.nsu.studyhelper.dagger.module.data.security;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.data.searcher.ISearcherDataSource;
import ru.nsk.nsu.studyhelper.mvp.data.searcher.SearcherRepository;
import ru.nsk.nsu.studyhelper.mvp.data.security.ISecurityDataSource;
import ru.nsk.nsu.studyhelper.mvp.data.security.SecurityRepository;

import javax.inject.Singleton;

@Module
public class SecurityDataSourceModule {
    private final ISecurityDataSource repository;

    public SecurityDataSourceModule() {
        repository = SecurityRepository.getInstance();
    }

    @Provides
    @Singleton
    ISecurityDataSource getSecurityDataSource() {
        return repository;
    }
}

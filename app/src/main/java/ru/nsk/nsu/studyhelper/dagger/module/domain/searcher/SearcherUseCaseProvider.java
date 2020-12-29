package ru.nsk.nsu.studyhelper.dagger.module.domain.searcher;

public class SearcherUseCaseProvider {
    private static final SearcherUseCaseComponent appComponent =
            DaggerSearcherUseCaseComponent.create();

    public static SearcherUseCaseComponent getAppComponent() {
        return appComponent;
    }
}

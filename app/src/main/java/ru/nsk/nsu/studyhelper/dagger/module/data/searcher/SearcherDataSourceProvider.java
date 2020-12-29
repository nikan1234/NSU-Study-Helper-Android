package ru.nsk.nsu.studyhelper.dagger.module.data.searcher;

public class SearcherDataSourceProvider {
    private static final SearcherDataSourceComponent appComponent =
            DaggerSearcherDataSourceComponent.create();

    public static SearcherDataSourceComponent getAppComponent() {
        return appComponent;
    }
}

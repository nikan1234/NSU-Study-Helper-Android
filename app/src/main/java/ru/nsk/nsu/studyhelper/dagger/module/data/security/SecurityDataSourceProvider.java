package ru.nsk.nsu.studyhelper.dagger.module.data.security;

public class SecurityDataSourceProvider {
    private static final SecurityDataSourceComponent appComponent =
            DaggerSecurityDataSourceComponent.create();

    public static SecurityDataSourceComponent getAppComponent() {
        return appComponent;
    }
}

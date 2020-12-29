package ru.nsk.nsu.studyhelper.dagger.module.domain.reset_password;

public class ResetPasswordUseCaseProvider {
    private static final ResetPasswordUseCaseComponent appComponent =
            DaggerResetPasswordUseCaseComponent.create();

    static public ResetPasswordUseCaseComponent getAppComponent() {
        return appComponent;
    }
}

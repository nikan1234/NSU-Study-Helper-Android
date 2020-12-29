package ru.nsk.nsu.studyhelper.dagger.module.domain.sign_up;

public class SignUpUseCaseProvider {
    private static final SignUpUseCaseComponent appComponent =
            DaggerSignUpUseCaseComponent.create();

    public static SignUpUseCaseComponent getAppComponent() {
        return appComponent;
    }
}

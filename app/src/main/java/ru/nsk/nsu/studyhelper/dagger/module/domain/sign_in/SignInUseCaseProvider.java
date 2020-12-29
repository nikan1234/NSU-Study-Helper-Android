package ru.nsk.nsu.studyhelper.dagger.module.domain.sign_in;

public class SignInUseCaseProvider {
    private static final SignInUseCaseComponent appComponent =
            DaggerSignInUseCaseComponent.create();

    public static SignInUseCaseComponent getAppComponent() {
        return appComponent;
    }
}

package ru.nsk.nsu.studyhelper.dagger.module.domain.sign_in;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.domain.sign_in.SignInUseCase;

import javax.inject.Singleton;

@Module
public class SignInUseCaseModule {
    private final SignInUseCase signInUseCase;

    public SignInUseCaseModule() {
        signInUseCase = new SignInUseCase();
    }

    @Provides
    @Singleton
    public SignInUseCase getSignInUseCase() {
        return signInUseCase;
    }
}

package ru.nsk.nsu.studyhelper.dagger.module.domain.sign_up;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.domain.sign_up.SignUpUseCase;

import javax.inject.Singleton;

@Module
public class SignUpUseCaseModule {
    private final SignUpUseCase signUpUseCase;

    public SignUpUseCaseModule() {
        signUpUseCase = new SignUpUseCase();
    }

    @Provides
    @Singleton
    public SignUpUseCase getSignUpUseCase() {
        return signUpUseCase;
    }
}

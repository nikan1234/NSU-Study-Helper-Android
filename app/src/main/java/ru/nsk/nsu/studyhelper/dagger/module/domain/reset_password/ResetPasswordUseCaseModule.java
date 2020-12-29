package ru.nsk.nsu.studyhelper.dagger.module.domain.reset_password;


import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.domain.reset_password.RequestPasswordResetUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.reset_password.ResetPasswordUseCase;

import javax.inject.Singleton;

@Module
public class ResetPasswordUseCaseModule {
    private final RequestPasswordResetUseCase requestPasswordResetUseCase;
    private final ResetPasswordUseCase resetPasswordUseCase;

    public ResetPasswordUseCaseModule() {
        requestPasswordResetUseCase = new RequestPasswordResetUseCase();
        resetPasswordUseCase = new ResetPasswordUseCase();
    }

    @Provides
    @Singleton
    RequestPasswordResetUseCase getRequestPasswordResetUseCase() {
        return requestPasswordResetUseCase;
    }

    @Provides
    @Singleton
    ResetPasswordUseCase getResetPasswordUseCase() {
        return resetPasswordUseCase;
    }
}

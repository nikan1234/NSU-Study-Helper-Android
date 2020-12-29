package ru.nsk.nsu.studyhelper.dagger.module.data.security;

import dagger.Component;
import ru.nsk.nsu.studyhelper.mvp.domain.reset_password.RequestPasswordResetUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.reset_password.ResetPasswordUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.sign_in.SignInUseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.sign_up.SignUpUseCase;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        SecurityDataSourceModule.class
})
public interface SecurityDataSourceComponent {
    void inject(SignInUseCase useCase);
    void inject(SignUpUseCase useCase);
    void inject(RequestPasswordResetUseCase useCase);
    void inject(ResetPasswordUseCase useCase);
}

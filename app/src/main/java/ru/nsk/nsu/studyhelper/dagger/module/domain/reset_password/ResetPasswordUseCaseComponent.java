package ru.nsk.nsu.studyhelper.dagger.module.domain.reset_password;


import dagger.Component;
import ru.nsk.nsu.studyhelper.dagger.module.data.authToken.AuthTokenHolderModule;
import ru.nsk.nsu.studyhelper.dagger.module.domain.common.UseCaseExecutorModule;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.NewPasswordPresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.RequestPasswordResetPresenter;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        ResetPasswordUseCaseModule.class,
        AuthTokenHolderModule.class,
        UseCaseExecutorModule.class
})
public interface ResetPasswordUseCaseComponent {
    void inject(RequestPasswordResetPresenter presenter);
    void inject(NewPasswordPresenter presenter);
}

package ru.nsk.nsu.studyhelper.dagger.module.domain.sign_up;

import dagger.Component;
import ru.nsk.nsu.studyhelper.dagger.module.data.authToken.AuthTokenHolderModule;
import ru.nsk.nsu.studyhelper.dagger.module.domain.common.UseCaseExecutorModule;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_up.SignUpPresenter;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        SignUpUseCaseModule.class,
        AuthTokenHolderModule.class,
        UseCaseExecutorModule.class
})
public interface SignUpUseCaseComponent {
    void inject(SignUpPresenter presenter);
}

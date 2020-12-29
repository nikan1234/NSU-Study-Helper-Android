package ru.nsk.nsu.studyhelper.dagger.module.domain.sign_in;

import dagger.Component;
import ru.nsk.nsu.studyhelper.dagger.module.data.authToken.AuthTokenHolderModule;
import ru.nsk.nsu.studyhelper.dagger.module.domain.common.UseCaseExecutorModule;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_in.SignInPresenter;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        SignInUseCaseModule.class,
        AuthTokenHolderModule.class,
        UseCaseExecutorModule.class
})
public interface SignInUseCaseComponent {
    void inject(SignInPresenter presenter);
}

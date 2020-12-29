package ru.nsk.nsu.studyhelper.dagger.module.presentation.reset_password;


import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.RequestPasswordResetContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.RequestPasswordResetPresenter;

@Module
public class RequestPasswordResetModule {

    @Provides
    RequestPasswordResetContract.Presenter providePresenter(final RequestPasswordResetContract.View view) {
        return new RequestPasswordResetPresenter(view);
    }
}

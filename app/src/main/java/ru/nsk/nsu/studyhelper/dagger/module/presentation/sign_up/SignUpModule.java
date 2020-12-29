package ru.nsk.nsu.studyhelper.dagger.module.presentation.sign_up;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_up.SignUpContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_up.SignUpPresenter;

@Module
public class SignUpModule {
    @Provides
    SignUpContract.Presenter providePresenter(SignUpContract.View view) {
        return new SignUpPresenter(view);
    }
}
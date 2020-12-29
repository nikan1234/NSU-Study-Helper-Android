package ru.nsk.nsu.studyhelper.dagger.module.presentation.sign_in;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_in.SignInContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_in.SignInPresenter;

@Module
public class SignInModule {
    @Provides
    SignInContract.Presenter providePresenter(SignInContract.View view) {
        return new SignInPresenter(view);
    }
}
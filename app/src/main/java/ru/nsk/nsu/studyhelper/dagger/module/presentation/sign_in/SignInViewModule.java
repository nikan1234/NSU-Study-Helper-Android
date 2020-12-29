package ru.nsk.nsu.studyhelper.dagger.module.presentation.sign_in;

import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_in.SignInContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_in.SignInFragment;

@Module
public abstract class SignInViewModule {

    @Binds
    abstract SignInContract.View provideView(SignInFragment signInFragment);
}

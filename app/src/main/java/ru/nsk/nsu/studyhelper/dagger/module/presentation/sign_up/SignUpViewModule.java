package ru.nsk.nsu.studyhelper.dagger.module.presentation.sign_up;

import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_up.SignUpContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.sign_up.SignUpFragment;

@Module
public abstract class SignUpViewModule {

    @Binds
    abstract SignUpContract.View provideView(SignUpFragment signUpFragment);
}

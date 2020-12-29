package ru.nsk.nsu.studyhelper.dagger.module.presentation.reset_password;


import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.RequestPasswordResetContract;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.RequestPasswordResetFragment;

@Module
public abstract class RequestPasswordResetViewModule {

    @Binds
    abstract RequestPasswordResetContract.View provideView(RequestPasswordResetFragment fragment);
}

package ru.nsk.nsu.studyhelper.dagger.module.presentation.reset_password;

import dagger.Binds;
import dagger.Module;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.NewPasswordContact;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.NewPasswordFragment;

@Module
public abstract class NewPasswordViewModule {

    @Binds
    abstract NewPasswordContact.View provideView(NewPasswordFragment fragment);
}

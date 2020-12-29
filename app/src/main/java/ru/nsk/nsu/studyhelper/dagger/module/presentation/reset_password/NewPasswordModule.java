package ru.nsk.nsu.studyhelper.dagger.module.presentation.reset_password;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.NewPasswordContact;
import ru.nsk.nsu.studyhelper.mvp.presentation.reset_password.NewPasswordPresenter;

@Module
public class NewPasswordModule {

    @Provides
    NewPasswordContact.Presenter providePresenter(final NewPasswordContact.View view) {
        return new NewPasswordPresenter(view);
    }
}

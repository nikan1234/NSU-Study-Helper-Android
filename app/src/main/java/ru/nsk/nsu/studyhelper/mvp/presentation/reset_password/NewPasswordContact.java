package ru.nsk.nsu.studyhelper.mvp.presentation.reset_password;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.model.security.NewPasswordData;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BasePresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BaseView;

public class NewPasswordContact {

    abstract public static class Presenter extends BasePresenter<View> {
        abstract void resetPassword(final @NonNull NewPasswordData data);
    }

    abstract public static class View extends BaseView {
        abstract void onPasswordResetSuccess();
    }
}

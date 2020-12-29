package ru.nsk.nsu.studyhelper.mvp.presentation.reset_password;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.model.security.ResetPasswordData;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BasePresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BaseView;

public class RequestPasswordResetContract {


    abstract public static class Presenter extends BasePresenter<View> {
        abstract void requestResetPassword(@NonNull final ResetPasswordData data);
    }

    abstract public static class View extends BaseView {
        abstract void showSuccessMessage();
    }
}

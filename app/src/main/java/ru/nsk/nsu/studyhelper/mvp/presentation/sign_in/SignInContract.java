package ru.nsk.nsu.studyhelper.mvp.presentation.sign_in;

import ru.nsk.nsu.studyhelper.mvp.model.security.AuthData;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BasePresenter;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.BaseView;

public class SignInContract {

    abstract public static class Presenter extends BasePresenter<View> {
        public abstract void signIn(AuthData authData);
    }

    abstract public static class View extends BaseView {
        public abstract void onSignInComplete();
    }
}

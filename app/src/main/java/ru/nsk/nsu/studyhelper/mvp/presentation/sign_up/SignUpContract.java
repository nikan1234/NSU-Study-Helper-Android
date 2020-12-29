package ru.nsk.nsu.studyhelper.mvp.presentation.sign_up;

import ru.nsk.nsu.studyhelper.mvp.model.security.RegisterData;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.*;

public class SignUpContract {

    abstract public static class Presenter extends BasePresenter<View> {
        public abstract void signUp(RegisterData registerData);
    }

    abstract public static class View extends BaseView {
        public abstract void onSignUpComplete();
    }
}

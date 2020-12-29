package ru.nsk.nsu.studyhelper.mvp.presentation.sign_in;


import android.os.Bundle;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.presentation.Screens;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.navigation.MenuProvider;
import ru.nsk.nsu.studyhelper.mvp.model.security.AuthData;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import java.util.Objects;

public class SignInFragment extends SignInContract.View {

    @Inject
    Router router;

    @Inject
    MenuProvider menuProvider;

    @Inject
    SignInContract.Presenter presenter;

    @BindView(R.id.sign_in_email_edit_text)
    EditText emailEditText;

    @BindView(R.id.sign_in_password_edit_text)
    EditText passwordEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        presenter.unlinkView();
        super.onDestroy();
    }

    @OnClick(R.id.sign_in_button)
    public void onSignInButtonClicked() {
        final String email = emailEditText.getText().toString();
        final String password = passwordEditText.getText().toString();

        final AuthData authData = new AuthData(email, password);
        presenter.signIn(authData);
    }

    @OnClick(R.id.sign_in_forgot_password)
    public void onForgotPasswordButtonClicked() {
        router.navigateTo(new Screens.RequestPasswordResetScreen());
    }

    @OnClick(R.id.sign_in_register)
    public void onSignUpButtonClicked() {
        Objects.requireNonNull(menuProvider.getMenu()
                .findItem(R.id.navigation_sign_up))
                .setChecked(true);
        router.newRootScreen(new Screens.SignUpScreen());
    }

    @Override
    public void onSignInComplete() {
        Objects.requireNonNull(menuProvider.getMenu()
                .findItem(R.id.navigation_start))
                .setChecked(true);
        router.newRootScreen(new Screens.SearcherScreen());
    }
}
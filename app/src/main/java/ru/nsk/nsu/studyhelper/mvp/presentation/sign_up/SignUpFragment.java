package ru.nsk.nsu.studyhelper.mvp.presentation.sign_up;

import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.model.security.RegisterData;
import ru.nsk.nsu.studyhelper.mvp.presentation.Screens;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.navigation.MenuProvider;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerError;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import java.util.Objects;


public class SignUpFragment extends SignUpContract.View {

    @Inject
    Router router;

    @Inject
    MenuProvider menuProvider;

    @Inject
    SignUpContract.Presenter presenter;

    @BindView(R.id.sign_up_name_edit_text)
    EditText nameEditText;

    @BindView(R.id.sign_up_email_edit_text)
    EditText emailEditText;

    @BindView(R.id.sign_up_password_edit_text)
    EditText passwordEditText;

    @BindView(R.id.sign_up_repeat_password_edit_text)
    EditText repeatPasswordEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        presenter.unlinkView();
        super.onDestroy();
    }

    @OnClick(R.id.sign_up_button)
    public void onSignUpButtonClicked() {
        final String name = nameEditText.getText().toString();
        final String email = emailEditText.getText().toString();
        final String password = passwordEditText.getText().toString();
        final String repeatPassword = repeatPasswordEditText.getText().toString();
        if (!password.equals(repeatPassword)) {
            showError(new PresentationLayerError(getResources().getString(R.string.sign_up_different_passwords_message)));
            return;
        }
        final RegisterData registerData = new RegisterData(name, email, password);
        presenter.signUp(registerData);
    }

    @OnClick(R.id.sign_up_already_registered)
    public void onSignInButtonClicked() {
        Objects.requireNonNull(menuProvider.getMenu()
                .findItem(R.id.navigation_sign_in))
                .setChecked(true);
        router.newRootScreen(new Screens.SignInScreen());
    }

    @Override
    public void onSignUpComplete() {
        Objects.requireNonNull(menuProvider.getMenu()
                .findItem(R.id.navigation_start))
                .setChecked(true);
        router.newRootScreen(new Screens.SignInScreen());
        Toast.makeText(getActivity(), R.string.sign_in_after_register_message, Toast.LENGTH_LONG).show();
    }
}
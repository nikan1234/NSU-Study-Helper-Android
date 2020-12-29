package ru.nsk.nsu.studyhelper.mvp.presentation.reset_password;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.navigation.MenuProvider;
import ru.nsk.nsu.studyhelper.mvp.model.exam.Exam;
import ru.nsk.nsu.studyhelper.mvp.model.security.NewPasswordData;
import ru.nsk.nsu.studyhelper.mvp.model.security.UserToken;
import ru.nsk.nsu.studyhelper.mvp.presentation.Screens;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerError;
import ru.nsk.nsu.studyhelper.mvp.presentation.exam.statistics.ExamStatisticsFragment;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;
import java.util.Objects;

public class NewPasswordFragment extends NewPasswordContact.View {

    @Inject
    Router router;

    @Inject
    MenuProvider menuProvider;

    @Inject
    NewPasswordContact.Presenter presenter;

    @BindView(R.id.new_password_edit_text)
    EditText newPasswordEditText;

    @BindView(R.id.repeat_new_password_edit_text)
    EditText repeatNewPasswordEditText;

    private static final String ARG_PARAM = "TOKEN";
    private String token;

    public static NewPasswordFragment newInstance(final String token) {
        NewPasswordFragment fragment = new NewPasswordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, token);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            return;
        }
        token = getArguments().getString(ARG_PARAM);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_new_password, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.new_password_button)
    void onNewPasswordButtonClicked() {
        String password = newPasswordEditText.getText().toString();
        String repeatedPassword = repeatNewPasswordEditText.getText().toString();
        if (!password.equals(repeatedPassword)) {
            showError(new PresentationLayerError(getString(R.string.error_password_not_match)));
            return;
        }
        if (password.isEmpty()) {
            showError(new PresentationLayerError(getString(R.string.error_password_empty)));
            return;
        }

        NewPasswordData data = new NewPasswordData(password, new UserToken(token));
        presenter.resetPassword(data);
    }

    @Override
    public void onDestroy() {
        presenter.unlinkView();
        super.onDestroy();
    }

    @Override
    void onPasswordResetSuccess() {
        Toast.makeText(getActivity(), R.string.new_password_success_message, Toast.LENGTH_LONG).show();
        Objects.requireNonNull(menuProvider.getMenu()
                .findItem(R.id.navigation_sign_in))
                .setChecked(true);
        router.newRootScreen(new Screens.SignInScreen());
    }
}
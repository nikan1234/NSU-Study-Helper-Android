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
import ru.nsk.nsu.studyhelper.mvp.model.security.ResetPasswordData;
import ru.terrakok.cicerone.Router;

import javax.inject.Inject;

public class RequestPasswordResetFragment extends RequestPasswordResetContract.View {

    @Inject
    Router router;

    @Inject
    RequestPasswordResetContract.Presenter presenter;

    @BindView(R.id.request_email_edit_text)
    EditText emailEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_request_password_reset, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        presenter.unlinkView();
        super.onDestroy();
    }

    @OnClick(R.id.request_password_button)
    void onRequestResetPasswordButtonClicked() {
        String email = emailEditText.getText().toString();

        presenter.requestResetPassword(new ResetPasswordData(email));
    }

    @Override
    void showSuccessMessage() {
        final Toast toast = Toast.makeText(
                getActivity(),
                getString(R.string.request_password_success_message),
                Toast.LENGTH_LONG);
        toast.show();
    }
}
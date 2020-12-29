package ru.nsk.nsu.studyhelper.mvp.presentation.reset_password;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.domain.reset_password.ResetPasswordUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.reset_password.ResetPasswordUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.security.NewPasswordData;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;

public class NewPasswordPresenter extends NewPasswordContact.Presenter {

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    ResetPasswordUseCase resetPasswordUseCase;

    public NewPasswordPresenter(final NewPasswordContact.View view) {
        ResetPasswordUseCaseProvider.getAppComponent().inject(this);
        linkView(view);
    }


    @Override
    void resetPassword(final @NonNull NewPasswordData data) {
        useCaseExecutor.execute(resetPasswordUseCase, data,
                new UseCase.IUseCaseCallback<Void, DomainLayerError>() {
                    @Override
                    public void onSuccess(Void successResponse) {
                        if (getView() != null) {
                            getView().onPasswordResetSuccess();
                        }
                    }

                    @Override
                    public void onError(DomainLayerError error) {
                        if (getView() != null) {
                            getView().showError(PresentationLayerErrorCreator.create(error));
                        }
                    }
                });
    }
}

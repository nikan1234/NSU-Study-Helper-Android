package ru.nsk.nsu.studyhelper.mvp.presentation.reset_password;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.domain.reset_password.ResetPasswordUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.reset_password.RequestPasswordResetUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.security.ResetPasswordData;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;

public class RequestPasswordResetPresenter extends RequestPasswordResetContract.Presenter {

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    RequestPasswordResetUseCase requestPasswordResetUseCase;

    public RequestPasswordResetPresenter(final RequestPasswordResetContract.View view) {
        ResetPasswordUseCaseProvider.getAppComponent().inject(this);
        linkView(view);
    }

    @Override
    void requestResetPassword(final @NonNull ResetPasswordData data) {
        useCaseExecutor.execute(requestPasswordResetUseCase, data,
                new UseCase.IUseCaseCallback<Void, DomainLayerError>() {
                    @Override
                    public void onSuccess(Void successResponse) {
                        if (getView() != null) {
                            getView().showSuccessMessage();
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

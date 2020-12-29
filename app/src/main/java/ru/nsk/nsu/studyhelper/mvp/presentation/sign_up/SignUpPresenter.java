package ru.nsk.nsu.studyhelper.mvp.presentation.sign_up;

import ru.nsk.nsu.studyhelper.dagger.module.domain.sign_up.SignUpUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.IAuthTokenHolder;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.sign_up.SignUpUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.security.RegisterData;
import ru.nsk.nsu.studyhelper.mvp.model.security.UserToken;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;

public class SignUpPresenter extends SignUpContract.Presenter {

    @Inject
    IAuthTokenHolder authTokenHolder;

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    SignUpUseCase signUpUseCase;

    public SignUpPresenter(SignUpContract.View view) {
        SignUpUseCaseProvider.getAppComponent().inject(this);
        linkView(view);
    }

    @Override
    public void signUp(RegisterData regData) {
        useCaseExecutor.execute(signUpUseCase, regData,
                new UseCase.IUseCaseCallback<Void, DomainLayerError>() {
                    @Override
                    public void onSuccess(Void successResponse) {
                        if (getView() != null) {
                            getView().onSignUpComplete();
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

package ru.nsk.nsu.studyhelper.mvp.presentation.sign_in;

import ru.nsk.nsu.studyhelper.dagger.module.domain.sign_in.SignInUseCaseProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.IAuthTokenHolder;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.sign_in.SignInUseCase;
import ru.nsk.nsu.studyhelper.mvp.model.security.AuthData;
import ru.nsk.nsu.studyhelper.mvp.model.security.UserToken;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerError;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerErrorCreator;

import javax.inject.Inject;

public class SignInPresenter extends SignInContract.Presenter {

    @Inject
    IAuthTokenHolder authTokenHolder;

    @Inject
    IUseCaseExecutor useCaseExecutor;

    @Inject
    SignInUseCase signInUseCase;

    public SignInPresenter(final SignInContract.View view) {
        SignInUseCaseProvider.getAppComponent().inject(this);
        if (authTokenHolder.getToken() != null) {
            view.showError(new PresentationLayerError(authTokenHolder.getToken()));
        }
        linkView(view);
    }

    @Override
    public void signIn(AuthData authData) {
        useCaseExecutor.execute(signInUseCase, authData,
                new UseCase.IUseCaseCallback<UserToken, DomainLayerError>() {
                    @Override
                    public void onSuccess(UserToken successResponse) {
                        authTokenHolder.setToken(successResponse.getToken());
                        if (getView() != null) {
                            getView().onSignInComplete();
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

package ru.nsk.nsu.studyhelper.mvp.domain.sign_in;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.security.SecurityDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.security.ISecurityDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.IDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.BadCredentialsError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.InvalidArgsError;
import ru.nsk.nsu.studyhelper.mvp.domain.common.errors.UnknownError;
import ru.nsk.nsu.studyhelper.mvp.model.security.AuthData;
import ru.nsk.nsu.studyhelper.mvp.model.security.UserToken;

import javax.inject.Inject;

public class SignInUseCase extends UseCase<AuthData, UserToken> {

    @Inject
    ISecurityDataSource securityDataSource;

    public SignInUseCase() {
        SecurityDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(AuthData requestValues) {
        securityDataSource.doSignIn(
                new ISecurityDataSource.ILoadCallback<UserToken>() {
                    @Override
                    public void loadSuccess(final @NonNull UserToken data) {
                        getCallback().onSuccess(data);
                    }

                    @Override
                    public void loadFailure(final @NonNull DataLayerError error) {
                        ChainDomainLayerErrorCreator errorCreator = new ChainDomainLayerErrorCreator();
                        errorCreator.addDomainLayerErrorCreator(dataLayerError -> {
                            final int FORBIDDEN_ERROR_CODE = 403;
                            if (dataLayerError.getStatus() == FORBIDDEN_ERROR_CODE) {
                                return new BadCredentialsError();
                            }
                            return null;
                        });
                        getCallback().onError(errorCreator.process(error));
                    }
                }, requestValues);
    }
}

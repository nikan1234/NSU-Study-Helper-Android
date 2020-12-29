package ru.nsk.nsu.studyhelper.mvp.domain.sign_up;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.security.SecurityDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.security.ISecurityDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.security.RegisterData;
import ru.nsk.nsu.studyhelper.mvp.model.security.UserToken;

import javax.inject.Inject;

public class SignUpUseCase extends UseCase<RegisterData, Void> {

    @Inject
    ISecurityDataSource securityDataSource;

    public SignUpUseCase() {
        SecurityDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(RegisterData requestValues) {
        securityDataSource.doSignUp(
                new ISecurityDataSource.ILoadCallback<Void>() {
                    @Override
                    public void loadSuccess(final @NonNull Void data) {
                        getCallback().onSuccess(data);
                    }

                    @Override
                    public void loadFailure(final @NonNull DataLayerError error) {
                        getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
                    }
                }, requestValues);
    }
}

package ru.nsk.nsu.studyhelper.mvp.domain.reset_password;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.security.SecurityDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.security.ISecurityDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.security.ResetPasswordData;

import javax.inject.Inject;

public class RequestPasswordResetUseCase extends UseCase<ResetPasswordData, Void> {

    @Inject
    ISecurityDataSource securityDataSource;

    public RequestPasswordResetUseCase() {
        SecurityDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(ResetPasswordData requestValues) {
        securityDataSource.doRequestNewPassword(new ISecurityDataSource.ILoadCallback<Void>() {
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

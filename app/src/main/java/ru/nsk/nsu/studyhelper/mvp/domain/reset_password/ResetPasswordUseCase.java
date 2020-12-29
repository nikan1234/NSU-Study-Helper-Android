package ru.nsk.nsu.studyhelper.mvp.domain.reset_password;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;
import ru.nsk.nsu.studyhelper.dagger.module.data.security.SecurityDataSourceProvider;
import ru.nsk.nsu.studyhelper.mvp.data.common.DataLayerError;
import ru.nsk.nsu.studyhelper.mvp.data.security.ISecurityDataSource;
import ru.nsk.nsu.studyhelper.mvp.domain.common.UseCase;
import ru.nsk.nsu.studyhelper.mvp.domain.common.creator.ChainDomainLayerErrorCreator;
import ru.nsk.nsu.studyhelper.mvp.model.security.NewPasswordData;

import javax.inject.Inject;

public class ResetPasswordUseCase extends UseCase<NewPasswordData, Void> {

    @Inject
    ISecurityDataSource securityDataSource;

    public ResetPasswordUseCase() {
        SecurityDataSourceProvider.getAppComponent().inject(this);
    }

    @Override
    protected void execute(NewPasswordData requestValues) {
        securityDataSource.doResetPassword(new ISecurityDataSource.ILoadCallback<Void>() {
            @Override
            public void loadSuccess(final @NonNull Void data) {
                getCallback().onSuccess(data);
            }

            @Override
            public void loadFailure(@NonNull DataLayerError error) {
                getCallback().onError(new ChainDomainLayerErrorCreator().process(error));
            }
        }, requestValues);
    }
}

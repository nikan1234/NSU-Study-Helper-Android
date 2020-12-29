package ru.nsk.nsu.studyhelper.mvp.data.security;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.data.common.IDataLoadCallback;
import ru.nsk.nsu.studyhelper.mvp.model.security.*;

public interface ISecurityDataSource {

    interface ILoadCallback<DataType> extends IDataLoadCallback<DataType> {}

    void doSignUp(@NonNull final ILoadCallback<Void> callback,
                  @NonNull final RegisterData registerData);

    void doSignIn(@NonNull final ILoadCallback<UserToken> callback,
                  @NonNull final AuthData authData);

    void doRequestNewPassword(@NonNull final ILoadCallback<Void> callback,
                              @NonNull final ResetPasswordData resetPasswordData);

    void doResetPassword(@NonNull final ILoadCallback<Void> callback,
                         @NonNull final NewPasswordData newPasswordData);
}

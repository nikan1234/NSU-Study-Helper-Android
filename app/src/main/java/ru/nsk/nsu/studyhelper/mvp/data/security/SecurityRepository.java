package ru.nsk.nsu.studyhelper.mvp.data.security;

import android.util.Log;
import androidx.annotation.NonNull;

import ru.nsk.nsu.studyhelper.mvp.data.common.BaseRepository;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.ServiceGenerator;
import ru.nsk.nsu.studyhelper.mvp.data.security.remote.RemoteSecurityAPI;
import ru.nsk.nsu.studyhelper.mvp.model.security.*;

public class SecurityRepository extends BaseRepository implements ISecurityDataSource {

    private static volatile SecurityRepository INSTANCE;

    private final RemoteSecurityAPI api;

    private SecurityRepository() {
        api = ServiceGenerator.createService(RemoteSecurityAPI.class);
    }

    public static SecurityRepository getInstance() {
        SecurityRepository localInstance = INSTANCE;
        if (localInstance == null) {
            synchronized (SecurityRepository.class) {
                localInstance = INSTANCE;
                if (localInstance == null) {
                    INSTANCE = localInstance = new SecurityRepository();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void doSignUp(@NonNull final ILoadCallback<Void> callback,
                         @NonNull final RegisterData registerData) {
        loadData(api.signUp(registerData), callback);
    }

    @Override
    public void doSignIn(@NonNull final ILoadCallback<UserToken> callback,
                         @NonNull final AuthData authData) {
        loadData(api.signIn(authData), callback);
    }

    @Override
    public void doRequestNewPassword(final @NonNull ISecurityDataSource.ILoadCallback<Void> callback,
                                     final @NonNull ResetPasswordData resetPasswordData) {
        loadData(api.requestResetPassword(resetPasswordData), callback);
    }

    @Override
    public void doResetPassword(final @NonNull ISecurityDataSource.ILoadCallback<Void> callback,
                                final @NonNull NewPasswordData newPasswordData) {
        Log.e("Reset", "Reset");
        loadData(api.setNewPassword(newPasswordData.getToken().getToken(), newPasswordData), callback);
    }
}

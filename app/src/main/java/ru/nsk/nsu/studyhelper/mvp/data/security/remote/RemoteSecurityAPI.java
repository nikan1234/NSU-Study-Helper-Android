package ru.nsk.nsu.studyhelper.mvp.data.security.remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.nsk.nsu.studyhelper.mvp.model.security.*;

public interface RemoteSecurityAPI {

    @POST("/api/v1/auth/sign-up")
    Call<Void> signUp(@Body RegisterData registerData);

    @POST("/api/v1/auth/sign-in")
    Call<UserToken> signIn(@Body AuthData authData);

    @POST("/api/v1/auth/restore")
    Call<Void> requestResetPassword(@Body ResetPasswordData resetPasswordData);

    @POST("api/v1/auth/restore/{token}")
    Call<Void> setNewPassword(@Path(value = "token", encoded = true) String token,
                              @Body NewPasswordData data);
}

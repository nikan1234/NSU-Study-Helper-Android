package ru.nsk.nsu.studyhelper.mvp.data.common.remote;

import android.widget.Toast;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthTokenInterceptor implements Interceptor, IAuthTokenHolder {
    private static volatile AuthTokenInterceptor instance;
    private String token;

    public static AuthTokenInterceptor getInstance() {
        AuthTokenInterceptor localInstance = instance;
        if (localInstance == null) {
            synchronized (AuthTokenInterceptor.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new AuthTokenInterceptor();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .header("Authorization", "Bearer " + token).build();
        return chain.proceed(request);
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }
}

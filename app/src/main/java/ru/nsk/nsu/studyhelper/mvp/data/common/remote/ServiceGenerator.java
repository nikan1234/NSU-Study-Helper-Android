package ru.nsk.nsu.studyhelper.mvp.data.common.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String BASE_URL = "http://10.0.2.2:8443/";

    private static final OkHttpClient.Builder httpClientBuilder =
            new OkHttpClient.Builder();

    private static final OkHttpClient httpClient = httpClientBuilder
            .addInterceptor(AuthTokenInterceptor.getInstance()).build();

    private static final Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = builder.build();

    public static Retrofit retrofit() {
        return retrofit;
    }

    public static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
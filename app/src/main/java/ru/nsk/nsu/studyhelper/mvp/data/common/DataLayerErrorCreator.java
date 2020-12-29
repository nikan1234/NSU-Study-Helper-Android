package ru.nsk.nsu.studyhelper.mvp.data.common;

import androidx.annotation.NonNull;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.ServiceGenerator;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class DataLayerErrorCreator {
    public static final int RETROFIT_FAIL_STATUS_CODE = -1;

    public static DataLayerError create(@NonNull final Response<?> response) {
        Converter<ResponseBody, DataLayerError> converter =
                ServiceGenerator.retrofit()
                        .responseBodyConverter(DataLayerError.class, new Annotation[0]);

        DataLayerError error;
        try {
            //String kekw = new String(response.errorBody().bytes());
            error = converter.convert(response.errorBody());
            error.setStatus(response.code());
        } catch (IOException e) {
            return new DataLayerError(response.code(), "");
        }
        return error;
    }

    public static DataLayerError create(@NonNull final Throwable throwable) {
        return new DataLayerError(RETROFIT_FAIL_STATUS_CODE, throwable.getLocalizedMessage());
    }
}

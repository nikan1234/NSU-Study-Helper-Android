package ru.nsk.nsu.studyhelper.mvp.data.common;

import android.util.Log;
import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseRepository {

    protected <DataType> void loadData(final @NonNull Call<DataType> call,
                                       final @NonNull IDataLoadCallback<DataType> callback) {
        call.enqueue(new Callback<DataType>() {
            @Override
            public void onResponse(Call<DataType> call, Response<DataType> response) {
                if (response.isSuccessful()) {
                    callback.loadSuccess(response.body());
                    return;
                }
                callback.loadFailure(DataLayerErrorCreator.create(response));
            }

            @Override
            public void onFailure(Call<DataType> call, Throwable t) {
                Log.e("Hi", t.getLocalizedMessage());
                callback.loadFailure(DataLayerErrorCreator.create(t));
            }
        });
    }
}

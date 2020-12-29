package ru.nsk.nsu.studyhelper.mvp.data.common;

import androidx.annotation.NonNull;

import java.util.List;

public interface IDataLoadCallback<DataType> {
    void loadSuccess(@NonNull final DataType data);
    void loadFailure(@NonNull final DataLayerError error);
}
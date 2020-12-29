package ru.nsk.nsu.studyhelper.mvp.presentation.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface IBasePresenter<ViewType extends IBaseView> {
    void linkView(@NonNull final ViewType view);
    void unlinkView();

    @Nullable
    ViewType getView();
}

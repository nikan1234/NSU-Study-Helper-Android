package ru.nsk.nsu.studyhelper.mvp.presentation.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BasePresenter<ViewType extends BaseView> implements IBasePresenter<ViewType> {
    private ViewType view;


    @Override
    public void linkView(final @NonNull ViewType view) {
        this.view = view;
    }

    @Override
    public void unlinkView() {
        view = null;
    }

    @Nullable
    @Override
    public ViewType getView() {
        return view;
    }
}

package ru.nsk.nsu.studyhelper.mvp.presentation.common;

import androidx.annotation.NonNull;

public class PresentationLayerError {
    private final String message;

    public PresentationLayerError(final String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public String toString() {
        return message;
    }
}

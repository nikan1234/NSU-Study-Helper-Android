package ru.nsk.nsu.studyhelper.mvp.domain.common;

import androidx.annotation.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerError;

@AllArgsConstructor
public abstract class DomainLayerError {
    @Getter
    private final String message;
}
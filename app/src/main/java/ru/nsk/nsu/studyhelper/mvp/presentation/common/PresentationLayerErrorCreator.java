package ru.nsk.nsu.studyhelper.mvp.presentation.common;

import androidx.annotation.NonNull;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;

public class PresentationLayerErrorCreator {
    public static PresentationLayerError create(@NonNull final DomainLayerError domainLayerError) {
        return new PresentationLayerError(domainLayerError.getMessage());
    }
}


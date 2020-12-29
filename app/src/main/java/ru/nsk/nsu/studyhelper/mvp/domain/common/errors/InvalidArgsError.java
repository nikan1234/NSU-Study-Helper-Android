package ru.nsk.nsu.studyhelper.mvp.domain.common.errors;

import lombok.NonNull;
import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;

public class InvalidArgsError extends DomainLayerError {
    public InvalidArgsError(@NonNull final String message) {
        super(message);
    }
}

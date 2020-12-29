package ru.nsk.nsu.studyhelper.mvp.domain.common.errors;


import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;
import ru.nsk.nsu.studyhelper.mvp.presentation.common.PresentationLayerError;

public class UnknownError extends DomainLayerError {
    public UnknownError() {
        super("WTF error");
    }
}

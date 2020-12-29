package ru.nsk.nsu.studyhelper.mvp.domain.common.errors;

import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;

public class NetworkError extends DomainLayerError {
    public NetworkError() {
        super("Проблемы с сетью :(");
    }
}

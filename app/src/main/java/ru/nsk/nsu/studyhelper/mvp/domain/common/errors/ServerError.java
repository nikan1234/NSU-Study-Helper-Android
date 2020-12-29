package ru.nsk.nsu.studyhelper.mvp.domain.common.errors;

import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;

public class ServerError extends DomainLayerError {
    public ServerError() {
        super("Сервер упал с лестницы");
    }
}

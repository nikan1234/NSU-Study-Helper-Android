package ru.nsk.nsu.studyhelper.mvp.domain.common.errors;

import ru.nsk.nsu.studyhelper.mvp.domain.common.DomainLayerError;

public class BadCredentialsError extends DomainLayerError {
    public BadCredentialsError() {
        super("Неверный логин и/или пароль");
    }
}

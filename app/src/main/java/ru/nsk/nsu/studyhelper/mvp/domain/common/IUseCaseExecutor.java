package ru.nsk.nsu.studyhelper.mvp.domain.common;

public interface IUseCaseExecutor {

    <R, S> void execute(final UseCase<R, S> useCase,
                        final R requestValues,
                        final UseCase.IUseCaseCallback<S, DomainLayerError> callback);
}

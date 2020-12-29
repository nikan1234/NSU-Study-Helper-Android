package ru.nsk.nsu.studyhelper.mvp.domain.common;


public abstract class UseCase <RequestValuesType, ResponseValuesType> {

    private RequestValuesType requestValues;
    private IUseCaseCallback<ResponseValuesType, DomainLayerError> callback;


    protected abstract void execute(final RequestValuesType requestValues);

    public void run() {
        execute(requestValues);
    }

    public void setRequestValues(RequestValuesType requestValues) {
        this.requestValues = requestValues;
    }

    public void setCallback(IUseCaseCallback<ResponseValuesType, DomainLayerError> callback) {
        this.callback = callback;
    }

    public IUseCaseCallback<ResponseValuesType, DomainLayerError> getCallback() {
        return callback;
    }


    public interface IUseCaseCallback<DataType, ErrorType> {
        void onSuccess(final DataType successResponse);
        void onError(final ErrorType error);
    }
}

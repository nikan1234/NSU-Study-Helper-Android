package ru.nsk.nsu.studyhelper.mvp.domain.common;

import android.os.AsyncTask;
import androidx.annotation.NonNull;

public class SingleUseCaseExecutor implements IUseCaseExecutor {

    private static volatile SingleUseCaseExecutor instance;

    private SingleUseCaseExecutor() {}

    public static SingleUseCaseExecutor getInstance() {
        SingleUseCaseExecutor localInstance = instance;
        if (localInstance == null) {
            synchronized (SingleUseCaseExecutor.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingleUseCaseExecutor();
                }
            }
        }
        return localInstance;
    }

    @Override
    public <R, S> void execute(@NonNull final UseCase<R, S> useCase,
                               @NonNull final R requestValues,
                               @NonNull final UseCase.IUseCaseCallback<S, DomainLayerError> callback) {
        useCase.setRequestValues(requestValues);
        useCase.setCallback(callback);
        new ExecutionTask(useCase).execute();
    }


    private static class ExecutionTask extends AsyncTask<Void, Void, Void> {
        private final UseCase<?, ?> useCase;

        public ExecutionTask(final UseCase<?, ?> useCase) {
            this.useCase = useCase;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            useCase.run();
            return null;
        }
    }
}

package ru.nsk.nsu.studyhelper.dagger.module.domain.common;

import android.util.Log;
import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.domain.common.IUseCaseExecutor;
import ru.nsk.nsu.studyhelper.mvp.domain.common.SingleUseCaseExecutor;
import javax.inject.Singleton;

@Module
public class UseCaseExecutorModule {
    private final IUseCaseExecutor executor;

    public UseCaseExecutorModule() {
        executor = SingleUseCaseExecutor.getInstance();
    }

    @Provides
    @Singleton
    IUseCaseExecutor provideUseCaseExecutor() {
        return executor;
    }
}
package ru.nsk.nsu.studyhelper.dagger.module.data.authToken;

import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.AuthTokenInterceptor;
import ru.nsk.nsu.studyhelper.mvp.data.common.remote.IAuthTokenHolder;
import ru.nsk.nsu.studyhelper.mvp.data.exams.ExamDetailsRepository;
import ru.nsk.nsu.studyhelper.mvp.data.exams.IExamDetailsDataSource;

import javax.inject.Singleton;

@Module
public class AuthTokenHolderModule {
    private final IAuthTokenHolder authTokenHolder;

    public AuthTokenHolderModule() {
        authTokenHolder = AuthTokenInterceptor.getInstance();
    }

    @Provides
    @Singleton
    IAuthTokenHolder getAuthTokenHolder() {
        return authTokenHolder;
    }
}

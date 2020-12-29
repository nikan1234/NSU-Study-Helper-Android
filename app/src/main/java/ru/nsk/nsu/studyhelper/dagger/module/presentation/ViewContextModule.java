package ru.nsk.nsu.studyhelper.dagger.module.presentation;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import ru.nsk.nsu.studyhelper.StudyHelperApplication;

@Module
public class ViewContextModule {

    @Provides
    Context provideContext(StudyHelperApplication application) {
        return application.getApplicationContext();
    }
}
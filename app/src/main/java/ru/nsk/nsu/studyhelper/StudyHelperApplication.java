package ru.nsk.nsu.studyhelper;

import android.app.Application;
import javax.inject.Inject;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.DaggerViewComponent;

public class StudyHelperApplication extends Application implements HasAndroidInjector {
    public static StudyHelperApplication INSTANCE;

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        DaggerViewComponent
                .builder()
                .application(this)
                .build().inject(this);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}
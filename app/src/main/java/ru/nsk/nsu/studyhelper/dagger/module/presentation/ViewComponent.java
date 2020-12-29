package ru.nsk.nsu.studyhelper.dagger.module.presentation;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import ru.nsk.nsu.studyhelper.StudyHelperApplication;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.navigation.NavigationModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ViewBindersModule.class,
        ViewContextModule.class,
        NavigationModule.class
})
public interface ViewComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(StudyHelperApplication application);
        ViewComponent build();
    }
    void inject(StudyHelperApplication app);
}
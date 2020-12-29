package ru.nsk.nsu.studyhelper.dagger.module.presentation.navigation;

import android.view.Menu;
import androidx.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

import javax.inject.Singleton;

@Module
public class NavigationModule {
    private final Cicerone<Router> cicerone;
    private final MenuProvider menuProvider;

    public NavigationModule() {
        cicerone = Cicerone.create();
        menuProvider = new MenuProvider();
    }

    @Provides
    @Singleton
    Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @Singleton
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    @Provides
    @Singleton
    MenuProvider provideMenuProvider() {
        return menuProvider;
    }
}
package ru.nsk.nsu.studyhelper.dagger.module.presentation.navigation;

import android.view.Menu;
import androidx.annotation.NonNull;

public class MenuProvider {
    private Menu menu = null;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(@NonNull final Menu menu) {
        this.menu = menu;
    }
}
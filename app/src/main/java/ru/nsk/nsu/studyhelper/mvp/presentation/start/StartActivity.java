package ru.nsk.nsu.studyhelper.mvp.presentation.start;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import butterknife.BindView;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import dagger.android.support.DaggerAppCompatActivity;
import ru.nsk.nsu.studyhelper.R;
import ru.nsk.nsu.studyhelper.mvp.presentation.Screens;
import ru.nsk.nsu.studyhelper.dagger.module.presentation.navigation.MenuProvider;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

import javax.inject.Inject;
import java.util.Objects;

public class StartActivity extends DaggerAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String LOG_TAG = StartActivity.class.getCanonicalName();

    @Inject
    Router router;

    @Inject
    NavigatorHolder navigatorHolder;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Inject
    MenuProvider menuProvider;

    private ActionBarDrawerToggle toggle;

    private final Navigator navigator = new SupportAppNavigator(
            this, R.id.nav_host_fragment);

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupComponents();
        setupFragmentManager();

        if (savedInstanceState == null) {
            onNavigationItemSelected(menuProvider.getMenu().findItem(
                    R.id.navigation_start
            ));
        }

        deepLinkHandling();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        item.setChecked(true);

        final int id = item.getItemId();
        if (id == R.id.navigation_start) {
            router.newRootScreen(new Screens.SearcherScreen());
        }
        else if (id == R.id.navigation_sign_in) {
            router.newRootScreen(new Screens.SignInScreen());
        }
        else if (id == R.id.navigation_sign_up) {
            router.newRootScreen(new Screens.SignUpScreen());
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupComponents() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        toggle  = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.app_name, R.string.app_name);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        menuProvider.setMenu(navigationView.getMenu());
    }

    private void setupFragmentManager() {
        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                toggle.setDrawerIndicatorEnabled(false);
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
                toggle.setToolbarNavigationClickListener(v -> onBackPressed());
            } else {
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
                toggle.setDrawerIndicatorEnabled(true);
                toggle.setToolbarNavigationClickListener(null);
            }
        });
    }

    private void deepLinkHandling() {
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null) {
            String token = data.getLastPathSegment();
            router.navigateTo(new Screens.NewPasswordScreen(token));
        }
    }
}
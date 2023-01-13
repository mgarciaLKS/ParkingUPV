package com.lksnext.parking.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.lksnext.parking.R;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find views
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        //Set material toolbar as action bar
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Find the NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //Setup the NavigationView
        NavigationUI.setupWithNavController(navigationView, navController);
        //Create and AppBarConfiguration with the NavGraph and DrawerLayout
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
            .setOpenableLayout(drawerLayout).build();
        //Setup the Toolbar and NavControllerwith the specified configuration
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //Delegate the up navigation to the NavController
        return NavigationUI.navigateUp(navController, drawerLayout);
    }
}

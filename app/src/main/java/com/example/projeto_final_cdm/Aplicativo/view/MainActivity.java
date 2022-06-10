package com.example.projeto_final_cdm.Aplicativo.view;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.databinding.tool.store.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.projeto_final_cdm.R;
import com.example.projeto_final_cdm.Aplicativo.viewmodel.GPSViewModel;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private GPSViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView coord = (TextView)findViewById(R.id.txtLatLong);

        drawerLayout = findViewById(R.id.MainDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        model = new ViewModelProvider(this).get(GPSViewModel.class);
        final Observer<? super Location> observerpos = new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                coord.setText((CharSequence) location);
            }
        };
        model.getLocation().observe(this, (Observer<? super android.location.Location>) observerpos);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void goToCadastro(View view) {
        Intent intent = new Intent(MainActivity.this,FormCadastro.class);
        startActivity(intent);
        finish();
    }
}




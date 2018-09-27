package com.example.spongetoobog.cs3270a5;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm = getSupportFragmentManager();
    private FragmentChangeResults fragmentChangeResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fm.beginTransaction().replace(R.id.fragOne, new FragmentChangeResults(), "fragCR")
                .replace(R.id.fragTwo, new FragmentChangeButtons(), "fragCB").commit();

        Button btnShow = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new DialogFragment();
                dialog.setCancelable(false);
                dialog.show(fm, "delete_dialog");
            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();

        fragmentChangeResults = (FragmentChangeResults)fm.findFragmentByTag("fragCR");
        fragmentChangeResults.startTimer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                //User pressed done
                zeroCorrectCount();
                return true;
            case R.id.action_settings1:
                DialogFragment dialog = new DialogFragment();
                dialog.setCancelable(true);
                dialog.show(fm, "delete_dialog");
                setChangeMax();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void zeroCorrectCount() {
        //code method to change correct count
    }

    private void setChangeMax(){

    }
}

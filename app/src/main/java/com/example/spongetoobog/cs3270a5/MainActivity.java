package com.example.spongetoobog.cs3270a5;

import android.content.Context;
import android.content.DialogInterface;
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

public class MainActivity extends AppCompatActivity implements DialogFragment.setChangeMax {

    private FragmentManager fm = getSupportFragmentManager();
    private FragmentChangeResults fragmentChangeResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fm.beginTransaction().replace(R.id.fragOne, new FragmentChangeResults(), "fragCR")
                .replace(R.id.fragTwo, new FragmentChangeButtons(), "fragCB")
                .replace(R.id.fragThree, new FragmentChangeActions(), "fragCA").commit();

        fragmentChangeResults = (FragmentChangeResults)fm.findFragmentByTag("fragCR");

        Button btnShow = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new DialogFragment();
                dialog.setCancelable(false);
                dialog.show(fm, "change_dialog");
            }
        });

        Button startOver = (Button) findViewById(R.id.startOver);
        startOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragmentChangeResults != null) {
                    fragmentChangeResults.randomChange();
                }
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
                dialog.show(fm, "change_dialog");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void zeroCorrectCount() {
        //code method to change correct count
    }


    @Override
    public void setChangeMax(double x) {
        fragmentChangeResults = (FragmentChangeResults)fm.findFragmentByTag("fragCR");
        fragmentChangeResults.changeMax(x);
    }
}

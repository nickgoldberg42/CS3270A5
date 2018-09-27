package com.example.spongetoobog.cs3270a5;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentChangeResults extends Fragment {

    private View root;
    private TextView timeRemaining;
    private TextView changeToMake;
    private TextView changeSoFar;
    private double max = 100.00;
    private long time = 30000;
    private double changeNum;

    public FragmentChangeResults() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragement_change_results, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor spEdit = sp.edit();
        spEdit.putLong("maxValue", Double.doubleToLongBits(max));
        spEdit.putString("changeToMake", (String) changeToMake.getText());
        spEdit.putLong("timeRemaining", time);
        //spEdit.putString("changeSoFar", (String) changeSoFar.getText());
        spEdit.putLong("changeValue", Double.doubleToLongBits((changeNum)));
        spEdit.commit();
    }

    @Override
    public void onResume() {
        super.onResume();

        randomChange();

        SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);

        double getMax = Double.longBitsToDouble(sp.getLong("maxValue", 100));
        if (root != null) {
            changeToMake = (TextView) root.findViewById(R.id.ctmNum);
        }
        if (changeToMake != null) {
            changeToMake.setText(sp.getString("changeToMake", (String)changeToMake.getText()));
        }

        time = sp.getLong("timeRemaining", 30000);
        changeNum = Double.longBitsToDouble(sp.getLong("changeValue", 100));
        changeMax(getMax);
    }



    public void startTimer() {

        if (root != null)
            timeRemaining = (TextView) root.findViewById(R.id.trNum);

        Log.d("test", "Made it to method");
        new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (timeRemaining != null)
                    timeRemaining.setText("" + millisUntilFinished / 1000);
                time = time - 1000;
            }

            @Override
            public void onFinish() {
                if (timeRemaining != null)
                    timeRemaining.setText("done!");
                time = 30000;
            }
        }.start();
    }

    public void randomChange() {
        if (root != null) {
            changeToMake = (TextView) root.findViewById(R.id.ctmNum);
        }
        Random r = new Random();
        double change = max * r.nextDouble();

        changeNum = change;

        BigDecimal bdAmount = new BigDecimal(change);

        NumberFormat numFormat = NumberFormat.getCurrencyInstance(Locale.US);
        if (changeToMake != null) {
            changeToMake.setText(numFormat.format(bdAmount.doubleValue()));
        }
    }

    public void changeMax(double inputMax) {
        max = inputMax;
    }
}

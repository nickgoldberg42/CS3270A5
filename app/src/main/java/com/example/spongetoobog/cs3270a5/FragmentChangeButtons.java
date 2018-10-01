package com.example.spongetoobog.cs3270a5;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentChangeButtons extends Fragment {

    private View root;
    private addToTotal mCallback;

    public interface addToTotal {
        void addAmountToTotal(BigDecimal input);
    }

    public FragmentChangeButtons() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_change_buttons, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (addToTotal) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString());
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final BigDecimal fifty = new BigDecimal(50);
        final BigDecimal twenty = new BigDecimal(20);
        final BigDecimal ten = new BigDecimal(10);
        final BigDecimal five = new BigDecimal(5);
        final BigDecimal one = new BigDecimal(1);
        final BigDecimal fiftyC = new BigDecimal(.50);
        final BigDecimal twentyFiveC = new BigDecimal(.25);
        final BigDecimal tenC = new BigDecimal(.10);
        final BigDecimal fiveC = new BigDecimal(.05);
        final BigDecimal oneC = new BigDecimal(.01);
        final BigDecimal zero = new BigDecimal(0);

        View.OnClickListener listen = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        mCallback.addAmountToTotal(fifty);
                        break;
                    case R.id.button2:
                        mCallback.addAmountToTotal(twenty);
                        break;
                    case R.id.button3:
                        mCallback.addAmountToTotal(ten);
                        break;
                    case R.id.button4:
                        mCallback.addAmountToTotal(five);
                        break;
                    case R.id.button5:
                        mCallback.addAmountToTotal(one);
                        break;
                    case R.id.button6:
                        mCallback.addAmountToTotal(fiftyC);
                        break;
                    case R.id.button7:
                        mCallback.addAmountToTotal(twentyFiveC);
                        break;
                    case R.id.button8:
                        mCallback.addAmountToTotal(tenC);
                        break;
                    case R.id.button9:
                        mCallback.addAmountToTotal(fiveC);
                        break;
                    case R.id.button10:
                        mCallback.addAmountToTotal(oneC);
                        break;
                    default:
                        mCallback.addAmountToTotal(zero);
                        break;
                }
            }
        };

        Button moneyBtn1 = (Button) root.findViewById(R.id.button1);
        Button moneyBtn2 = (Button) root.findViewById(R.id.button2);
        Button moneyBtn3 = (Button) root.findViewById(R.id.button3);
        Button moneyBtn4 = (Button) root.findViewById(R.id.button4);
        Button moneyBtn5 = (Button) root.findViewById(R.id.button5);
        Button moneyBtn6 = (Button) root.findViewById(R.id.button6);
        Button moneyBtn7 = (Button) root.findViewById(R.id.button7);
        Button moneyBtn8 = (Button) root.findViewById(R.id.button8);
        Button moneyBtn9 = (Button) root.findViewById(R.id.button9);
        Button moneyBtn10 = (Button) root.findViewById(R.id.button10);


        moneyBtn1.setOnClickListener(listen);
        moneyBtn2.setOnClickListener(listen);
        moneyBtn3.setOnClickListener(listen);
        moneyBtn4.setOnClickListener(listen);
        moneyBtn5.setOnClickListener(listen);
        moneyBtn6.setOnClickListener(listen);
        moneyBtn7.setOnClickListener(listen);
        moneyBtn8.setOnClickListener(listen);
        moneyBtn9.setOnClickListener(listen);
        moneyBtn10.setOnClickListener(listen);
    }
}

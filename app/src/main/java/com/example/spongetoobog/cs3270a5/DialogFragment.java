package com.example.spongetoobog.cs3270a5;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragment extends android.support.v4.app.DialogFragment {

    private setChangeMax mCallback;

    public interface setChangeMax{
        void setChangeMax(double x);
    }


    public DialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            mCallback = (setChangeMax) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(e.toString());
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final EditText input = new EditText(getActivity());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setLayoutParams(lp);
        builder.setView(input);
        input.setVisibility(View.VISIBLE);

        builder.setMessage("Set Change Max").setPositiveButton(getString(R.string.setChange), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                double d = Double.parseDouble(input.getText().toString());
                mCallback.setChangeMax(d);
            }
        }).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }

}

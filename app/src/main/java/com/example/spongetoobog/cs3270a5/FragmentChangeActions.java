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


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentChangeActions extends Fragment {

    private View root;
    private setNewChangeAmount mCallback;

    public interface setNewChangeAmount {
        void setNewAmount();
        void resetThisGame();
    }

    public FragmentChangeActions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.fragment_change_actions, container, false);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (setNewChangeAmount) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString());
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button newAmount = (Button) root.findViewById(R.id.newAmount);
        newAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("got here", "got here");
                mCallback.setNewAmount();
            }
        });

        Button startOver = (Button) root.findViewById(R.id.startOver);
        startOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("got here", "got here");
                mCallback.resetThisGame();
            }
        });
    }

}

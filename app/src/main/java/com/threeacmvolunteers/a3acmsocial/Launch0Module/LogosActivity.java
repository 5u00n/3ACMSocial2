package com.threeacmvolunteers.a3acmsocial.Launch0Module;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.threeacmvolunteers.a3acmsocial.R;

public class LogosActivity extends Fragment {

    int position;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            // Get back arguments
            if(getArguments() != null) {
                position = getArguments().getInt("position", 0);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        // Inflate the xml file for the fragment
        return inflater.inflate(R.layout.fragment_logos, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Set values for view here

        Button nextbutton = (Button)view.findViewById(R.id.logos_button_next);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getActivity().getFragmentManager().popBackStack();
                AgreementActivity nffA = new AgreementActivity();
                FragmentManager fragmentManager4 = getFragmentManager();
                android.app.FragmentTransaction ft1 = fragmentManager4.beginTransaction().replace(R.id.container, nffA);
                ft1.commit();
            }
        });

    }

    // Activity is calling this to update view on Fragment
    public void updateView(int position){

    }
}


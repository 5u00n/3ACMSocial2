package com.threeacmvolunteers.a3acmsocial.Launch0Module;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.threeacmvolunteers.a3acmsocial.R;

public class ControllerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loader_layout);

        LogosActivity nffA = new LogosActivity();
        FragmentManager fragmentManager4 = getFragmentManager();
        android.app.FragmentTransaction ft1 = fragmentManager4.beginTransaction().replace(R.id.container, nffA);
        ft1.commit();

    }
}

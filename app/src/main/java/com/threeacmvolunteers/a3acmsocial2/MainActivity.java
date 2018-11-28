package com.threeacmvolunteers.a3acmsocial2;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.threeacmvolunteers.a3acmsocial2.Activities.UploadVideo;
import com.threeacmvolunteers.a3acmsocial2.SupportClasses.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    Button upButton,profileButton,searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
         mViewPager.setAdapter(mSectionsPagerAdapter);




         //Button Declaration....
        upButton =(Button) findViewById(R.id.id_main_upload);
        profileButton = (Button) findViewById(R.id.id_main_profile);
        searchButton =(Button) findViewById(R.id.id_main_search);




        //Button Clicks

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mSectionsPagerAdapter.getItem()
                Intent i = new Intent(MainActivity.this,UploadVideo.class);
                startActivity(i);

            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     mSectionsPagerAdapter.getItem(2);
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSectionsPagerAdapter.getItem(1);
            }
        });
      /*  ViewFragment nffA = new ViewFragment();
        android.app.FragmentManager fragmentManager4 = getFragmentManager();
       android.app.FragmentTransaction ft1 = fragmentManager4.beginTransaction().replace(R.id.flContainer, nffA);
       ft1.commit();*/

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mSectionsPagerAdapter.getPos()!= 0)
        {
            mSectionsPagerAdapter.getItem(0);
        }
        else
        {
            finish();
        }
    }


}





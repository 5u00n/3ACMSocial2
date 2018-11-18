package com.threeacmvolunteers.a3acmsocial2.SupportClasses;

import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.threeacmvolunteers.a3acmsocial2.Frags.ProfileFragment;
import com.threeacmvolunteers.a3acmsocial2.Frags.SearchFragment;
import com.threeacmvolunteers.a3acmsocial2.Frags.ViewFragment;
import com.threeacmvolunteers.a3acmsocial2.MainActivity;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
     int pos=0;
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
      // return ViewFragment.newInstance();


        switch(position) {

            case 0: pos=0; return ViewFragment.newInstance();
            case 1:pos=1; return ProfileFragment.newInstance(1);
            case 2:pos=3; return SearchFragment.newInstance(1);
            default: pos=0;return ViewFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    public int getPos()
    {
        return pos;
    }

}

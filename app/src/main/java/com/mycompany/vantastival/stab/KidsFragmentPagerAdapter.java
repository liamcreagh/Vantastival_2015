package com.mycompany.vantastival.stab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.info.InfoKidsDance;
import com.mycompany.vantastival.info.InfoKidsGeneral;

import com.mycompany.vantastival.info.InfoKidsMusic;


public class KidsFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] checkoutTitles = new String[] {"Kids", "Music Workshop", "Dance Workshop"};
    private Context context;


    public KidsFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new InfoKidsGeneral();
        } else if(position == 1) {
            return new InfoKidsMusic();
        }
        else if(position == 2) {
            return new InfoKidsDance();
        }

        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return checkoutTitles[position];
    }
}

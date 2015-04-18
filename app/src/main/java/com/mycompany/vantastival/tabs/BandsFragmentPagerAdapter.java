package com.mycompany.vantastival.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.frag.BandsAtoj;
import com.mycompany.vantastival.frag.BandsKtos;
import com.mycompany.vantastival.frag.BandsTtoz;

// Creates a Sliding Tab Layout for Bands Activity

public class BandsFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] bandsTitles = new String[] {"A - J", "K - S", "T - Z"};
    private Context context;


    public BandsFragmentPagerAdapter(FragmentManager fm, Context context) {
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
            return new BandsAtoj();
        }         else if(position == 1) {
            return new BandsKtos();
        } else if(position == 2) {
            return new BandsTtoz();
        }


        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return bandsTitles[position];
    }
}

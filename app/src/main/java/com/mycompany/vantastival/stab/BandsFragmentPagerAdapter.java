package com.mycompany.vantastival.stab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.frag.BandsAtoz;
import com.mycompany.vantastival.frag.BandsYourbands;
import com.mycompany.vantastival.info.InfoCampingBell;
import com.mycompany.vantastival.info.InfoCampingCaravans;
import com.mycompany.vantastival.info.InfoCampingGeneral;
import com.mycompany.vantastival.info.InfoCampingYurts;


public class BandsFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] bandsTitles = new String[] {"A to Z", "Your Bands"};
    private Context context;


    public BandsFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new BandsAtoz();
        }         else if(position == 1) {
            return new BandsYourbands();
        }


        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return bandsTitles[position];
    }
}

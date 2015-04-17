package com.mycompany.vantastival.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.info.InfoCampingBell;
import com.mycompany.vantastival.info.InfoCampingCaravans;
import com.mycompany.vantastival.info.InfoCampingGeneral;
import com.mycompany.vantastival.info.InfoCampingYurts;


public class CampingFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] campingTitles = new String[] {"General Camping", "Caravans & Campervans", "Yurts", "Bell Tents"};
    private Context context;


    public CampingFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new InfoCampingGeneral();
        }         else if(position == 1) {
            return new InfoCampingCaravans();
        } else if(position == 2) {
            return new InfoCampingYurts();
        }else if(position == 3) {
            return new InfoCampingBell();
        }


        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return campingTitles[position];
    }
}

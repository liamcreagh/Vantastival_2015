package com.mycompany.vantastival.stab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.info.InfoVenueDirections;
import com.mycompany.vantastival.info.InfoVenueGeneral;
import com.mycompany.vantastival.info.InfoVenueMap;
import com.mycompany.vantastival.stages.StagesMainstageFriday;
import com.mycompany.vantastival.stages.StagesMainstageSaturday;
import com.mycompany.vantastival.stages.StagesMainstageSunday;


public class VenueFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] venueTitles = new String[] {"About", "Directions", "Map"};
    private Context context;


    public VenueFragmentPagerAdapter(FragmentManager fm, Context context) {
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
            return new InfoVenueGeneral();
        } else if(position == 1) {
            return new InfoVenueDirections();
        } else if(position == 2) {
            return new InfoVenueMap();
        }


        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return venueTitles[position];
    }
}

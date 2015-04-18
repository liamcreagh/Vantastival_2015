package com.mycompany.vantastival.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.info.InfoVenueCookoff;
import com.mycompany.vantastival.info.InfoVenueDirections;
import com.mycompany.vantastival.info.InfoVenueGeneral;
import com.mycompany.vantastival.info.InfoVenueGrotto;
import com.mycompany.vantastival.info.InfoVenueMelomania;
import com.mycompany.vantastival.info.InfoVenueVantastibar;


// Creates a Sliding Tab Layout for Venue Section in Info Activity

public class VenueFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] venueTitles = new String[] {"About", "Directions", "Vantastibar", "Cook-off", "Melomania Stage", "Grotto Stage"};
    private Context context;


    public VenueFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
    }


    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new InfoVenueGeneral();
        } else if(position == 1) {
            return new InfoVenueDirections();
        } else if(position == 2) {
            return new InfoVenueVantastibar();
        } else if(position == 3) {
            return new InfoVenueCookoff();
        } else if(position == 4) {
            return new InfoVenueGrotto();
        }else if(position == 5) {
            return new InfoVenueMelomania();
        }




        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return venueTitles[position];
    }
}

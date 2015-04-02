package com.mycompany.vantastival.stab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.info.InfoFestivalAboutus;
import com.mycompany.vantastival.info.InfoFestivalAlcohol;
import com.mycompany.vantastival.info.InfoFestivalCarpark;
import com.mycompany.vantastival.info.InfoFestivalCharge;
import com.mycompany.vantastival.info.InfoFestivalChecklist;
import com.mycompany.vantastival.info.InfoFestivalFacilities;
import com.mycompany.vantastival.info.InfoFestivalFood;
import com.mycompany.vantastival.info.InfoFestivalGreen;
import com.mycompany.vantastival.info.InfoFestivalOpentimes;
import com.mycompany.vantastival.info.InfoFestivalTransport;
import com.mycompany.vantastival.stages.StagesMainstageFriday;
import com.mycompany.vantastival.stages.StagesMainstageSaturday;
import com.mycompany.vantastival.stages.StagesMainstageSunday;


public class FestivalFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] festivalTitles = new String[] {"About", "Open Times", "Transport", "Alcohol", "Car Park", "Facilities", "Charging", "Food & Drink", "Checklist", "Green Policy"};
    private Context context;


    public FestivalFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }


    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new InfoFestivalAboutus();
        } else if(position == 1) {
            return new InfoFestivalOpentimes();
        } else if(position == 2) {
            return new InfoFestivalTransport();
        } else if(position == 3) {
            return new InfoFestivalAlcohol();
        } else if(position == 4) {
            return new InfoFestivalCarpark();
        } else if(position == 5) {
            return new InfoFestivalFacilities();
        } else if(position == 6) {
            return new InfoFestivalCharge();
        } else if(position == 7) {
            return new InfoFestivalFood();
        } else if(position == 8) {
            return new InfoFestivalChecklist();
        } else if(position == 9) {
            return new InfoFestivalGreen();
        }


        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return festivalTitles[position];
    }
}

package com.mycompany.vantastival.stab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.stages.StagesMainstageFriday;
import com.mycompany.vantastival.stages.StagesMainstageSaturday;
import com.mycompany.vantastival.stages.StagesMainstageSunday;
import com.mycompany.vantastival.stages.StagesVanhallaFriday;
import com.mycompany.vantastival.stages.StagesVanhallaSaturday;
import com.mycompany.vantastival.stages.StagesVanhallaSunday;


public class VanhallaFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] dayTitles = new String[] {"Friday", "Saturday", "Sunday"};
    private Context context;


    public VanhallaFragmentPagerAdapter(FragmentManager fm, Context context) {
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
            return new StagesVanhallaFriday();
        } else if(position == 1) {
            return new StagesVanhallaSaturday();
        } else if(position == 2) {
            return new StagesVanhallaSunday();
        }

        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return dayTitles[position];
    }
}

package com.mycompany.vantastival.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.stages.StagesGoldFriday;
import com.mycompany.vantastival.stages.StagesGoldSaturday;
import com.mycompany.vantastival.stages.StagesGoldSunday;


public class GoldFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] dayTitles = new String[] {"Friday", "Saturday", "Sunday"};
    private Context context;


    public GoldFragmentPagerAdapter(FragmentManager fm, Context context) {
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
            return new StagesGoldFriday();
        } else if(position == 1) {
            return new StagesGoldSaturday();
        } else if(position == 2) {
            return new StagesGoldSunday();
        }

        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return dayTitles[position];
    }
}

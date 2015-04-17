package com.mycompany.vantastival.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.stages.StagesBallFriday;
import com.mycompany.vantastival.stages.StagesBallSaturday;
import com.mycompany.vantastival.stages.StagesBallSunday;


public class BallFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] dayTitles = new String[] {"Friday", "Saturday", "Sunday"};
    private Context context;


    public BallFragmentPagerAdapter(FragmentManager fm, Context context) {
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
            return new StagesBallFriday();
        } else if(position == 1) {
            return new StagesBallSaturday();
        } else if(position == 2) {
            return new StagesBallSunday();
        }

        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return dayTitles[position];
    }
}

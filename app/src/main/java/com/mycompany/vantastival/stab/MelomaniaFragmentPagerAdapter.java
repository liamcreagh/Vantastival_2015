package com.mycompany.vantastival.stab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.stages.StagesMainstageFriday;
import com.mycompany.vantastival.stages.StagesMainstageSaturday;
import com.mycompany.vantastival.stages.StagesMainstageSunday;
import com.mycompany.vantastival.stages.StagesMelomaniaFriday;
import com.mycompany.vantastival.stages.StagesMelomaniaSunday;


public class MelomaniaFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] dayTitles = new String[] {"Friday", "Saturday", "Sunday"};
    private Context context;


    public MelomaniaFragmentPagerAdapter(FragmentManager fm, Context context) {
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
            return new StagesMelomaniaFriday();
        } else if(position == 1) {
            return new StagesMainstageSaturday();
        } else if(position == 2) {
            return new StagesMelomaniaSunday();
        }

        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return dayTitles[position];
    }
}

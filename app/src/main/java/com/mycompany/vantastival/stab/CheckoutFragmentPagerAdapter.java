package com.mycompany.vantastival.stab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.info.InfoCheckoutKids;
import com.mycompany.vantastival.info.InfoCheckoutNew;
import com.mycompany.vantastival.stages.StagesMainstageFriday;
import com.mycompany.vantastival.stages.StagesMainstageSaturday;
import com.mycompany.vantastival.stages.StagesMainstageSunday;


public class CheckoutFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] checkoutTitles = new String[] {"New", "Kids"};
    private Context context;


    public CheckoutFragmentPagerAdapter(FragmentManager fm, Context context) {
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
            return new InfoCheckoutNew();
        } else if(position == 1) {
            return new InfoCheckoutKids();
        }

        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return checkoutTitles[position];
    }
}

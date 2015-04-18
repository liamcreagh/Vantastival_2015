package com.mycompany.vantastival.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.info.InfoTicketsGeneral;
import com.mycompany.vantastival.info.InfoTicketsPrices;
import com.mycompany.vantastival.info.InfoTicketsTerms;


// Creates a Sliding Tab Layout for Tickets Section in Info Activity

public class TicketsFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] ticketsTitles = new String[] {"About", "Prices", "Terms & Conditions"};
    private Context context;


    public TicketsFragmentPagerAdapter(FragmentManager fm, Context context) {
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
            return new InfoTicketsGeneral();
        } else if(position == 1) {
            return new InfoTicketsPrices();
        } else if(position == 2) {
            return new InfoTicketsTerms();
        }


        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return ticketsTitles[position];
    }
}

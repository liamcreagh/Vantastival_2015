package com.mycompany.vantastival.stab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.vantastival.frag.NewsFacebook;
import com.mycompany.vantastival.frag.NewsNews;
import com.mycompany.vantastival.frag.NewsTwitter;

/**
 * Created by liamcreagh on 30/03/2015.
 */
public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] newsTitles = new String[] {"News", "Facebook", "Twitter"};
    private Context context;


    public NewsFragmentPagerAdapter(FragmentManager fm, Context context) {
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
            return new NewsNews();
        } else if(position == 1) {
            return new NewsFacebook();
        } else if(position == 2) {
            return new NewsTwitter();
        }

        return null;

       }







    @Override
    public CharSequence getPageTitle(int position) {
        return newsTitles[position];
    }
}

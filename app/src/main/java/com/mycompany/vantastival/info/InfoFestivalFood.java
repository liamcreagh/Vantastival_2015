package com.mycompany.vantastival.info;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mycompany.vantastival.R;

// Calls Fragment (Tab in sliding Tabs) in Festival section within InfoMain Activity

public class InfoFestivalFood extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_festival_food, container, false);
        return view;
    }
}

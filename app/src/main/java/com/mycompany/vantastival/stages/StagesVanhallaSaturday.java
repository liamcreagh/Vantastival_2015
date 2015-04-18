package com.mycompany.vantastival.stages;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.mycompany.vantastival.R;

import com.mycompany.vantastival.StagesVanhalla;

// Fragment that calls populate() method from StagesVanhalla Activity and queries DBAdapther (SQLite) for bands playing Vanhalla Stage on Saturday

public class StagesVanhallaSaturday extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stages_vanhalla_saturday, container, false);
        ListView myList = (ListView) view.findViewById(R.id.listViewMainStage);

        SimpleCursorAdapter myAdapter = ((StagesVanhalla) getActivity()).populate("van", "sat");

        myList.setAdapter(myAdapter);


        return myList;
    }
}

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
import com.mycompany.vantastival.StagesMainstage;
import com.mycompany.vantastival.StagesUnplugged;

public class StagesUnpluggedSaturday extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stages_unplugged_saturday, container, false);
        ListView myList = (ListView) view.findViewById(R.id.listViewMainStage);

        SimpleCursorAdapter myAdapter = ((StagesUnplugged) getActivity()).populate("unp", "sat");

        myList.setAdapter(myAdapter);


        return myList;
    }
}

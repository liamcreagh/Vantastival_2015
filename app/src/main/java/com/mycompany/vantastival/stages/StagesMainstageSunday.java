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

public class StagesMainstageSunday extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stages_mainstage_sunday, container, false);

        ListView myList = (ListView) view.findViewById(R.id.listViewMainStage);

        SimpleCursorAdapter myAdapter = ((StagesMainstage) getActivity()).populate("main", "sun");

        myList.setAdapter(myAdapter);


        return myList;

    }
}

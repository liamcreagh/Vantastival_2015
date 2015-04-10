package com.mycompany.vantastival.stages;


import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.mycompany.vantastival.MainActivity;
import com.mycompany.vantastival.R;
import com.mycompany.vantastival.StagesMain;
import com.mycompany.vantastival.StagesMainstage;
import com.mycompany.vantastival.db.DBAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StagesMainstageFriday extends Fragment {


    // DBAdapter db = new DBAdapter(getActivity());


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stages_mainstage_friday, container, false);

        ListView myList = (ListView) view.findViewById(R.id.listViewMainStage);

        SimpleCursorAdapter myAdapter = ((StagesMainstage) getActivity()).populate();

        myList.setAdapter(myAdapter);





        return myList;

    }








}

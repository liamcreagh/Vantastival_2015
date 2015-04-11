package com.mycompany.vantastival.db;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by liamcreagh on 03/04/2015.
 */
public class Message {
    public static void message(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

    }
}

package com.mycompany.vantastival.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.mycompany.vantastival.R;

public class AssignmentTracker extends Activity {
    /** Called when the activity is first created. */
	
	//DBAdapter db = new DBAdapter(this); 
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        setContentView(R.layout.main);
        

        
        try {        	
        	String destPath = "/data/data/" + getPackageName() + "/databases/AssignmentDB";
        	File f = new File(destPath);        	
        	if (!f.exists()) {        	
			    CopyDB( getBaseContext().getAssets().open("mydb"), 
					new FileOutputStream(destPath));
        	}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
                

    }
    
    private class DBAdapter extends BaseAdapter {
    	private LayoutInflater mInflater;
    	//private ArrayList<>

		@Override
		public int getCount() {
			
			return 0;
		}

		@Override
		public Object getItem(int arg0) {

			return null;
		}

		@Override
		public long getItemId(int arg0) {
			
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			
			return null;
		}
    	
    }
        
    public void CopyDB(InputStream inputStream, OutputStream outputStream) 
    throws IOException {
        //---copy 1K bytes at a time---
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
    
    public void DisplayRecord(Cursor c)
    {
        Toast.makeText(this, 
                "id: " + c.getString(0) + "\n" +
                "Title: " + c.getString(1) + "\n" +
                "Due Date:  " + c.getString(2),
                Toast.LENGTH_SHORT).show();        
    } 
    
    public void addAssignment(View view)
    {
    	
    	Intent i = new Intent("com.pinchtapzoom.addassignment");
    	startActivity(i);
    	Log.d("TAG", "Clicked");
    }

}
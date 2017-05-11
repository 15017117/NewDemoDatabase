package com.myapplicationdev.android.demodatabase1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by 15017117 on 11/5/2017.
 */

public class TaskArrayAdapter extends ArrayAdapter<Task> {
    // Create ArrayList of objects
    private ArrayList<Task> objects;
    // To hold the context object
    private Context context;
    // Create the UI objects to hold the UI elements in row layout
    private TextView tvID,tvDesc,tvDate;

    public TaskArrayAdapter(Context context, int resource,
                                 ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the ArrayList of objects passed to this adapter
        this.objects = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    // getView() is called every time for every row
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent,
                false);
        // Get the TextView object
        tvID = (TextView) rowView.findViewById(R.id.tvID);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);
        // Parameter "pos" is the index of the
        //  row ListView is requesting.
        //  We get back the object at the same index.
        Task object = objects.get(pos);
        // Set the TextView to show the object info
        tvID.setText(object.getId()+"");
        tvDate.setText(object.getDate());
        tvDesc.setText(object.getDescription());
        // Return this row that is being populated.
        return rowView;
    }

}

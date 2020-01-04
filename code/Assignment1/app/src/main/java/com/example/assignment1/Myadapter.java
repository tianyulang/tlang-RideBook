package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class Myadapter extends BaseAdapter {

    private LayoutInflater inflater;
    private RideList list;
    public Myadapter(Context context){
        this.inflater = LayoutInflater.from(context);
    }


    public void setList(RideList list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.Size();
    }

    @Override
    public Object getItem(int i) {
        return list.Get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inflater.inflate(R.layout.item1,null);
        TextView date = v.findViewById(R.id.date);
        TextView distance = v.findViewById(R.id.distance);
        TextView time = v.findViewById(R.id.time);
        Ride ride = list.Get(i);
        date.setText(ride.getDate());
        distance.setText(ride.getDistance());
        time.setText(ride.getTime());


        return v;
    }

}

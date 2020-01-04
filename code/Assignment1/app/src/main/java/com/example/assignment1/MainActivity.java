package com.example.assignment1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private int INDEX;
    private Myadapter adapter;
    private AdapterView<?> ADAPTERVIEW;
    private RideList list = new RideList();
    private TextView Total;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        lv = findViewById(R.id.lv_main);


        adapter = new Myadapter(this);

        adapter.setList(list);

        View footerView = ((LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer, null, false);
        Total = (TextView)footerView.findViewById(R.id.footer_1);
        Total.setText("Total Distance :"+(list.getDistance()));

        lv.addFooterView(footerView,null,false);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.add){
            Intent intent = new Intent();
            Ride ride = new Ride("","","","","","");
            intent.putExtra("ride",ride);
            intent.setClass(this,DetailActivity.class);

            startActivityForResult(intent,2);
        }

        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1:// Edit Ride
                if(resultCode == RESULT_OK){
                    Ride ride_back = (Ride)data.getExtras().getSerializable("ride1");


                    Ride ride = (Ride) ADAPTERVIEW.getItemAtPosition(INDEX);

                    list.DeleteDistance(Double.valueOf(ride.getDistance()));

                    ride.setDate(ride_back.getDate());

                    ride.setTime(ride_back.getTime());
                    ride.setDistance(ride_back.getDistance());
                    ride.setAverage_speed(ride_back.getAverage_speed());
                    ride.setAverage_cadence(ride_back.getAverage_cadence());
                    ride.setComment(ride_back.getComment());

                    list.AddDistance(Double.valueOf(ride.getDistance()));

                    Total.setText("Total Distance :"+(list.getDistance()));

                    adapter.notifyDataSetChanged();

                }
                if(resultCode == 2){// Delete a ride  object
                    Ride ride = (Ride) ADAPTERVIEW.getItemAtPosition(INDEX);

                    list.DeleteDistance(Double.valueOf(ride.getDistance()));
                    list.Delete(ride);
                    Total.setText("Total Distance :"+(list.getDistance()));
                    adapter.notifyDataSetChanged();

                }
                break;
            case 2: //Add ride
                if(resultCode == RESULT_OK){
                    Ride ride_back = (Ride)data.getExtras().getSerializable("ride1");

                    list.Add(ride_back);
                    Total.setText("Total Distance :"+(list.getDistance()));
                    adapter.notifyDataSetChanged();

                }
            default:
        }


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        INDEX = i;
        ADAPTERVIEW = adapterView;
        final Ride ride = (Ride) adapterView.getItemAtPosition(i);
        AlertDialog.Builder dialog  =new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Delete/Detail");
        dialog.setMessage("Check detail please press left button; delete this ride please press right button ");
        dialog.setCancelable(true);
        dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        list.DeleteDistance(Double.valueOf(ride.getDistance()));
                        list.Delete(ride);
                        Total.setText("Total Distance :" + (list.getDistance()));
                        adapter.notifyDataSetChanged();

                    }
                });
        dialog.setNegativeButton("Detail", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,DetailActivity.class);

                //get the data from each item

                intent.putExtra("ride",ride);

                startActivityForResult(intent,1);
            }
        });
        dialog.show();

    }

}

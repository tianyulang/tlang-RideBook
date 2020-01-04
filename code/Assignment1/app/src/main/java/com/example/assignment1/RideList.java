package com.example.assignment1;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RideList {

    private List<Ride> list = new ArrayList<>();
    private  double Distance;

    public double getDistance() {
        return Distance;
    }


    public void Add(Ride ride){

        list.add(ride);

        Distance += Double.parseDouble(ride.getDistance());


    }
    public void Delete(Ride ride){

        list.remove(ride);
    }
    public Ride Get(int i){

        return list.get(i);

    }
    public int Size() {
        return list.size();
    }
    public void AddDistance(double distance){
        Distance += (distance);
    }
    public void DeleteDistance(double distance){
        Distance -=(distance);
    }


}

package com.example.assignment1;

import java.io.Serializable;

public class Ride implements Serializable {
    private String time;
    private String distance;
    private String date;
    private String average_speed;
    private String average_cadence;
    private String comment;

    public Ride(String time, String distance, String date, String average_speed, String average_cadence, String comment) {
        this.time = time;
        this.distance = distance;
        this.date = date;
        this.average_speed = average_speed;
        this.average_cadence = average_cadence;
        this.comment = comment;
    }

    public Ride() {
        this.time = "";
        this.distance = "";
        this.date = "";
        this.average_speed = "";
        this.average_cadence = "";
        this.comment = "";

    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAverage_speed() {
        return average_speed;
    }

    public void setAverage_speed(String average_speed) {
        this.average_speed = average_speed;
    }

    public String getAverage_cadence() {
        return average_cadence;
    }

    public void setAverage_cadence(String average_cadence) {
        this.average_cadence = average_cadence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

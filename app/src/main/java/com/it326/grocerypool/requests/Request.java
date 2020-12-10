package com.it326.grocerypool.requests;

import java.time.LocalDateTime;

public class Request {
    //all possible items needed for a request
    String email;
    String address;
    int year, month, day, hour, minute;

    // idont know if we will use year but it have it here in case it has use
    String location;

        //request constructor
    public Request(String email, String address, int year, int month, int day, int hour, int minute)
    {
        this.email = email;
        this.address = address;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public Request(){

    }

    // from edit profile screen takes all strings and makes the request details equal to it
    public void editRequest(String email, String address, int year, int month, int day, int hour, int minute)
    {
        this.email = email;
        this.address = address;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    // get methods for all parameters
    public String getEmail()
    {
        return email;
    }
    public String getLocation()
    {
        return location;
    }
    public String getAddress() {
        return address;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}

package com.it326.grocerypool;

public class Request {
    //all possible items needed for a request
    String time;
    String day;
    String month;
    String email;
    String year;
    // idont know if we will use year but it have it here in case it has use
    String location;

        //request constructor
    public Request(String time, String day, String month, String year, String email, String location)
    {
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
        this.email = email;
        this.email = email;
        this.location = location;

    }

    // from edit profile screen takes all strings and makes the request details equal to it
    public void editRequest(String time, String day, String month, String year, String email, String location)
    {
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
        this.email = email;
        this.location = location;

    }

    // get methods for all parameters
    public String getEmail()
    {
        return email;
    }
    public String getDay()
    {
        return day;
    }
    public String getMonth()
    {
        return month;
    }
    public String getTime()
    {
        return time;
    }
    public String getLocation()
    {
        return location;
    }
    public String getYear()
    {
        return year;
    }
}

package com.it326.grocerypool.requests;

import java.time.LocalDateTime;

public class Request {
    //all possible items needed for a request
    String email;
    String address;
    LocalDateTime dateTime;

    // idont know if we will use year but it have it here in case it has use
    String location;

        //request constructor
    public Request(String email, String address, LocalDateTime dateTime)
    {
        this.email = email;
        this.address = address;
        this.dateTime = dateTime;
    }

    public Request(){

    }

    // from edit profile screen takes all strings and makes the request details equal to it
    public void editRequest(String email, String address, LocalDateTime dateTime)
    {
        this.email = email;
        this.address = address;
        this.dateTime = dateTime;
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
    public LocalDateTime getDateTime(){
        return this.dateTime;
    }
}

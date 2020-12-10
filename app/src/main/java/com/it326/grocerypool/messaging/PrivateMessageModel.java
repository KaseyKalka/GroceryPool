package com.it326.grocerypool.messaging;

import java.util.Date;

public class PrivateMessageModel {
    String sender, recipient;
    String message;
    long messageTime;

    public PrivateMessageModel(){

    }

    public PrivateMessageModel(String sender, String recipient, String message){
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.messageTime = new Date().getTime();
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public long getMessageTime() {
        return messageTime;
    }
}

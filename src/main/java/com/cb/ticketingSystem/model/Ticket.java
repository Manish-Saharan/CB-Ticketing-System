package com.cb.ticketingSystem.model;

public class Ticket {
    private String from;
    private String to;
    private User user;
    
    public Ticket(String from, String to, User user) {
        this.from = from;
        this.to = to;
        this.user = user;
    }

    //Getters and Setters
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}


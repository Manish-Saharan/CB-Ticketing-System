package com.cb.ticketingSystem.model;

public class Receipt {
    private String ticketId;
    private String from;
    private String to;
    private User user;
    private int price;
    private String section;

    public Receipt(String ticketId, String from, String to, User user, int price, String section){
        this.ticketId = ticketId;
        this.from = from;
        this.to = to;
        this.user = user;
        this.price = price;
        this.section = section;
    }

    //Getters and Setters
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Receipt [ticketId=" + ticketId + 
        ", from=" + from + 
        ", to=" + to + 
        ", user name=" + user.getFirstName() + " " + user.getLastName() +
        ", email=" + user.getEmail() + 
        ", price=" + price + 
        ", section=" + section + "]";
    }
}

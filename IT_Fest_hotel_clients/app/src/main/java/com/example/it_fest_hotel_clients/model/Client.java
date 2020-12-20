package com.example.it_fest_hotel_clients.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Client implements Serializable {

    public enum Status{
        RESIDES,
        EVICTED
    }

    private int id, amountOfDays;
    private String lastName, firstName;
    private LocalDate arrivalDate, checkOutDate;
    private Status status = Status.EVICTED;


    public int getId() {
        return id;
    }

    public Client(int id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Client(int id, String lastName, String firstName, LocalDate arrivalDate, int amountOfDays) {
        this(id, lastName, firstName);
        this.amountOfDays = amountOfDays;
        this.arrivalDate = arrivalDate;
        this.checkOutDate = arrivalDate.plusDays(amountOfDays);
        this.status = Status.RESIDES;
    }

    public Client(int id, String lastName, String firstName, LocalDate arrivalDate, int amountOfDays, Status status) {
        this(id, lastName, firstName, arrivalDate, amountOfDays);
        this.status = status;
    }

    public Client(int id, String lastName, String firstName, LocalDate arrivalDate, int amountOfDays, LocalDate checkOutDate) {
        this(id, lastName, firstName, arrivalDate, amountOfDays);
        this.checkOutDate = checkOutDate;
    }

    public Client(int id, String lastName, String firstName, LocalDate arrivalDate, int amountOfDays, LocalDate checkOutDate, Status status) {
        this(id, lastName, firstName, arrivalDate, amountOfDays, checkOutDate);
        this.status = status;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setAmountOfDays(int amountOfDays) {
        this.amountOfDays = amountOfDays;
        this.checkOutDate = this.arrivalDate.plusDays(amountOfDays);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public int getAmountOfDays() {
        return amountOfDays;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}

/*
  File Name: Player.java
  Description: A class that represents a Player with personal information.
  Student's Name: Orlando Velasco Rios
  Student ID: 301368612
  Date: November 30, 2024
*/


package com.opsdevelop.orlandovelasco_comp228lab5;

public class Player {

    //Player information fields
    private int playerId;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String province;
    private String phoneNumber;

    // Constructor to initialize a new Player object with all details
    public Player(int playerId, String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.province = province;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public int getPlayerId() { return playerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getPostalCode() { return postalCode; }
    public String getProvince() { return province; }
    public String getPhoneNumber() { return phoneNumber; }
}

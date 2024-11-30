/*
  File Name: Games.java
  Description: A class that represents a game, storing information such as the
               game's title, the date it was played, and the score.
  Student's Name: Orlando Velasco Rios
  Student ID: 301368612
  Date: November 30, 2024
*/


package com.opsdevelop.orlandovelasco_comp228lab5;

// Importing the Date class from java.sql package to handle SQL date types
import java.sql.Date;

public class Games {

    //Games information fields
    private String gameTitle;
    private Date playingDate;
    private int score;

    // Constructor to initialize a new Games object with all details
    public Games(String gameTitle, Date playingDate, int score) {
        this.gameTitle = gameTitle;
        this.playingDate = playingDate;
        this.score = score;
    }

    // Getters
    public String getGameTitle() { return gameTitle; }

    public Date getPlayingDate() { return playingDate; }

    public int getScore() { return score; }
}

package com.w1761091.userinterface;
//UOW ID- W1761091
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;
@Component
public class FootballClub extends SportsClub implements Serializable {
    private int wins;
    private int draws;
    private int defeats;
    private int receivedGoals;
    private int scoredGoals;
    private int currentPointOfClub;
    private int noOfMatchedPlayed;

    public FootballClub(){

    }

    public FootballClub(String clubName ,String location,int wins, int draws, int defeats, int receivedGoals,int scoredGoals, int currentPointOfClub, int noOfMatchedPlayed){
        super(clubName, location);
        this.wins=wins;
        this.draws=draws;
        this.defeats=defeats;
        this.receivedGoals=receivedGoals;
        this.scoredGoals=scoredGoals;
        this.currentPointOfClub=currentPointOfClub;
        this.noOfMatchedPlayed=noOfMatchedPlayed;
    }
    public void setWins(int wins) {

        this.wins = wins;
    }
    public int getWins() {

        return wins;
    }
    public void setDraws(int draws) {

        this.draws = draws;
    }
    public int getDraws() {

        return draws;
    }
    public void setDefeats(int defeats) {

        this.defeats = defeats;
    }
    public int getDefeats() {

        return defeats;
    }
    public void setReceivedGoals(int receivedGoals) {

        this.receivedGoals = receivedGoals;
    }
    public int getReceivedGoals() {

        return receivedGoals;
    }
    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }
    public int getScoredGoals() {
        return scoredGoals;
    }
    public void setCurrentPointOfClub(int currentPointOfClub) {

        this.currentPointOfClub = currentPointOfClub;
    }
    public int getCurrentPointOfClub() {

        return currentPointOfClub;
    }
    public void setNoOfMatchedPlayed(int noOfMatchedPlayed) {

        this.noOfMatchedPlayed = noOfMatchedPlayed;
    }
    public int getNoOfMatchedPlayed() {

        return noOfMatchedPlayed;
    }


    public int hashcode(){
        return Objects.hash(wins, draws, defeats, receivedGoals, scoredGoals, currentPointOfClub, noOfMatchedPlayed);
    }

    @Override
    public String toString() {
        return "wins=" + wins + ", draws=" + draws + ", defeats=" + defeats + ", receivedGoals=" + receivedGoals + ", scoredGoals=" + scoredGoals + ", currentPointOfClub=" + currentPointOfClub + ", noOfMatchedPlayed=" + noOfMatchedPlayed ;
    }
}
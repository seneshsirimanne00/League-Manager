package com.w1761091.userinterface;
//UOW ID- W1761091
import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    private String clubName;
    private String location;

    public SportsClub(){

    }
    public SportsClub(String clubName, String location){
        this.clubName=clubName;
        this.location=location;
    }

    public void setClubName(String clubName){

        this.clubName=clubName;
    }
    public String getClubName(){

        return clubName;
    }
    public void setLocation(String location){

        this.location=location;
    }
    public String getLocation(){


        return location;
    }

    public int hashcode(){

        return Objects.hash(clubName, location);
    }
    @Override
    public String toString() {
        return "SportsClub=>" + "clubName='" + clubName + ", location='" + location;
    }
}

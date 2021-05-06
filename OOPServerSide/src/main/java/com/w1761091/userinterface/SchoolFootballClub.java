package com.w1761091.userinterface;
//UOW ID- W1761091
import java.util.Objects;

public class SchoolFootballClub extends FootballClub {
    private String schoolName;

    public SchoolFootballClub(){

    }
    public SchoolFootballClub(String schoolName){

        this.schoolName=schoolName;
    }

    public int hashcode(){
        return Objects.hash(schoolName);
    }
}

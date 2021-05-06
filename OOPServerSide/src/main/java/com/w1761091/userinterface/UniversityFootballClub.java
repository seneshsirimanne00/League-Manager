package com.w1761091.userinterface;
//UOW ID- W1761091
import java.util.Objects;

public class UniversityFootballClub  extends FootballClub{
    private String universityName;

    public UniversityFootballClub(){

    }
    public UniversityFootballClub(String universityName){

        this.universityName=universityName;
    }

    public int hashcode(){
        return Objects.hash(universityName);
    }
}

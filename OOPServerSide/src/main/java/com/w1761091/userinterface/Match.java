package com.w1761091.userinterface;
//UOW ID- W1761091
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class Match implements Serializable {
    private String clubOne;
    private String clubTwo;
    private int clubOneScore;
    private int clubTwoScore;
    @Autowired
    private MatchDate mdate;

    public Match(){

    }

    public Match(String clubOne,String clubTwo,int clubOneScore,int clubTwoScore,MatchDate mdate){
        this.clubOne=clubOne;
        this.clubTwo=clubTwo;
        this.clubOneScore=clubOneScore;
        this.clubTwoScore=clubTwoScore;
        this.mdate=mdate;
    }

    public String getClubOne() {

        return clubOne;
    }

    public void setClubOne(String clubOne) {

        this.clubOne = clubOne;
    }

    public String getClubTwo() {

        return clubTwo;
    }

    public void setClubTwo(String clubTwo) {

        this.clubTwo = clubTwo;
    }

    public int getClubOneScore() {

        return clubOneScore;
    }

    public void setClubOneScore(int clubOneScore) {

        this.clubOneScore = clubOneScore;
    }

    public int getClubTwoScore() {

        return clubTwoScore;
    }

    public void setClubTwoScore(int clubTwoScore) {

        this.clubTwoScore = clubTwoScore;
    }

    public MatchDate getMdate() {

        return mdate;
    }  // this getter returns mdate object


    public void setMdate(MatchDate mdate) {

        this.mdate = mdate;
    }

    public String toString() {
        return "Match ==>" + "clubOne='" + clubOne + ", clubTwo='" + clubTwo + ", clubOneScore=" + clubOneScore + ", clubTwoScore=" + clubTwoScore + ", mdate=" + mdate;
    }
}

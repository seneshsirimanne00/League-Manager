package com.w1761091.userinterface;
//UOW ID- W1761091
public interface LeagueManager {

    void addFootballClub(FootballClub newOne);
    void deleteFootballClub(String removeClub);
    void displayStats(String displaycname);
    void displayPremierLeagueTable();
    void addPlayedMatch(String c1,String c2,int c1score,int c2score,MatchDate mdate);
    void saveToFile();
    void readData();

}

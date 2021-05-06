package com.w1761091.userinterface;
//UOW ID- W1761091

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class PremierLeagueManager implements LeagueManager,Serializable {

    static ArrayList<FootballClub> FootballClubsArraylist = new ArrayList<FootballClub>(); // arraylist to hold football club objects
    static ArrayList<Match> PlayedMatchArraylist = new ArrayList<Match>();  // arraylist to hold match objects

    public PremierLeagueManager(){

    }

    @Override
    public void addFootballClub(FootballClub newOne) { //method to add football club
            if (FootballClubsArraylist.size() <= 19) { // validate max amount of football clubs to avoid out of bounds error
                FootballClubsArraylist.add(newOne);
            } else {
                System.out.println("you reached maximum club limit");
            }
    }

    public void deleteFootballClub(String removeClub) { // method to delete football clubs
        for(int i=0;i< FootballClubsArraylist.size();i++) {
            if(FootballClubsArraylist.get(i).getClubName().equals(removeClub)) { //for loop is used to check existence of football club
                FootballClubsArraylist.remove(i);
                break;
            }else{
                if(i==(FootballClubsArraylist.size()-1)) {
                    System.out.println("the club you entered is not here,try again ! ");
                    break;
                }
            }
        }
    }

    public void displayStats(String displaycname) { // method to display stats of a club
        for(int i=0;i<19;i++) {
            if(FootballClubsArraylist.get(i).getClubName().equals(displaycname)) {
                System.out.println(FootballClubsArraylist.get(i).toString());
                break;
            }else{
                if(i==(FootballClubsArraylist.size()-1)) {
                    System.out.println("the club you entered is not here,try again ! ");
                    break;
                }

            }
        }

    }

    public void displayPremierLeagueTable() {  // method to display PL table and also sort according to points
        int n = FootballClubsArraylist.size();
        FootballClub temp = null;     // bubble sort is used to sort according to points
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < (n - i - 1); j++) {
                if (FootballClubsArraylist.get(j).getCurrentPointOfClub() > FootballClubsArraylist.get(j + 1).getCurrentPointOfClub()) {
                    temp = FootballClubsArraylist.get(j);
                    FootballClubsArraylist.set(j, FootballClubsArraylist.get(j + 1));
                    FootballClubsArraylist.set(j + 1, temp);
                }
                if (FootballClubsArraylist.get(j).getCurrentPointOfClub() == FootballClubsArraylist.get(j + 1).getCurrentPointOfClub()) {
                    int goalDif = FootballClubsArraylist.get(j).getScoredGoals() - FootballClubsArraylist.get(j).getReceivedGoals();
                    int goalDifTwo = FootballClubsArraylist.get(j + 1).getScoredGoals() - FootballClubsArraylist.get(j + 1).getReceivedGoals();
                    if (goalDif > goalDifTwo) {
                        temp = FootballClubsArraylist.get(j);
                        FootballClubsArraylist.set(j, FootballClubsArraylist.get(j + 1));
                        FootballClubsArraylist.set(j + 1, temp);
                    }

                }
            }
        }
        Collections.reverse(FootballClubsArraylist);  // to show in descending order
        for (int i = 0; i < FootballClubsArraylist.size(); i++) {
            FootballClub f_obj = FootballClubsArraylist.get(i);
            System.out.println(FootballClubsArraylist.get(i).getClubName() + " ==> " + f_obj);
        }
    }

    // method to add played match
    public void addPlayedMatch(String c1,String c2,int c1score,int c2score,MatchDate mdate ) {
        if (c1score > c2score) {
                System.out.println(" ");
                for (int i = 0; i < PremierLeagueManager.FootballClubsArraylist.size(); i++) {
                    if (FootballClubsArraylist.get(i).getClubName().equals(c1)) { // checks existence
                        System.out.println(c1 + " won the match");
                        FootballClubsArraylist.get(i).setWins(FootballClubsArraylist.get(i).getWins() + 1);
                        System.out.println(FootballClubsArraylist.get(i).getClubName()+" ==> wins :"+FootballClubsArraylist.get(i).getWins());//just to check
                    }
                    if (FootballClubsArraylist.get(i).getClubName().equals(c2)) {
                        FootballClubsArraylist.get(i).setDefeats(FootballClubsArraylist.get(i).getDefeats() + 1);
                        System.out.println(FootballClubsArraylist.get(i).getClubName()+" ==> defeats :"+FootballClubsArraylist.get(i).getDefeats());//just to check
                    }

                }System.out.println("above data was updated.");
            } else if (c1score < c2score) {
                System.out.println(" ");
                for (int i = 0; i < PremierLeagueManager.FootballClubsArraylist.size(); i++) {
                    //below in the if statements the code updates the club name that comes first, in a first come first serve basis
                    if (FootballClubsArraylist.get(i).getClubName().equals(c2)) {
                        System.out.println(c2 + " won the match");
                        FootballClubsArraylist.get(i).setWins(FootballClubsArraylist.get(i).getWins() + 1);
                        System.out.println(FootballClubsArraylist.get(i).getClubName()+" ==> wins :"+FootballClubsArraylist.get(i).getWins());//just to check
                    }
                    if (FootballClubsArraylist.get(i).getClubName().equals(c1)) {
                        FootballClubsArraylist.get(i).setDefeats(FootballClubsArraylist.get(i).getDefeats() + 1);
                        System.out.println(FootballClubsArraylist.get(i).getClubName()+" ==> defeats :"+FootballClubsArraylist.get(i).getDefeats());//just to check
                    }

                }System.out.println("above data was updated.");
            } else if (c1score == c2score) {
                System.out.println(" ");
                System.out.println("The match was a draw");
                for (int i = 0; i < PremierLeagueManager.FootballClubsArraylist.size(); i++) {
                    //below in the if statements the code updates the club name that comes first, in a first come first serve basis
                    if (FootballClubsArraylist.get(i).getClubName().equals(c1)) {
                        FootballClubsArraylist.get(i).setDraws(FootballClubsArraylist.get(i).getDraws() + 1);
                        System.out.println(FootballClubsArraylist.get(i).getClubName()+" ==> draws :"+FootballClubsArraylist.get(i).getDraws());//just to check
                    }
                    if (FootballClubsArraylist.get(i).getClubName().equals(c2)) {
                        FootballClubsArraylist.get(i).setDraws(FootballClubsArraylist.get(i).getDraws() + 1);
                        System.out.println(FootballClubsArraylist.get(i).getClubName()+" ==> draws :"+FootballClubsArraylist.get(i).getDraws());//just to check

                    }
                }System.out.println("above data was updated.");
            }
            Match newMatch = new Match(c1,c2,c1score,c2score,mdate);
            PlayedMatchArraylist.add(newMatch);

    }
 //reference for below  2 methods : https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
 // the code i refferenced were used to save & load  Strings but my code is converted to save & load  Objects


    public void saveToFile() {
        try
        {
            FileOutputStream fos1 = new FileOutputStream("fbClubArrayData.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(FootballClubsArraylist);
            fos1.close();
            oos1.close();
            FileOutputStream fos2 = new FileOutputStream("playedMatchData.txt");
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            oos2.writeObject(PlayedMatchArraylist);
            fos2.close();
            oos2.close();


        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }


    }

    public void readData(){
        System.out.println(" ");
        try
        {
            FileInputStream fis1 = new FileInputStream("fbClubArrayData.txt");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            FootballClubsArraylist = (ArrayList) ois1.readObject();
            ois1.close();
            fis1.close();
            FileInputStream fis2 = new FileInputStream("playedMatchData.txt");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            PlayedMatchArraylist = (ArrayList) ois2.readObject();
            ois2.close();
            fis2.close();
        } catch (EOFException e) {
            System.out.println("No previous data detected.");
            return;
        }catch (FileNotFoundException e) {
        e.printStackTrace();
        }catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("internal error : Class not found");
            c.printStackTrace();
            return;
        }
        System.out.println(" Data was loaded.");
    }

}

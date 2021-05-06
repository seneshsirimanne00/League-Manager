package com.w1761091.userinterface;
//UOW ID- W1761091

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@RestController
public class UserinterfaceApplication {
    static ArrayList<Match> selectedByDateArraylist = new ArrayList<Match>(); //array of objects to store an object when a user enters date from GUI
    @CrossOrigin("http://localhost:4200") // to give CORS permission to the below URL
    @GetMapping("/show")
    public ArrayList<FootballClub> showTable(){     //this method is used to sort according to points send object data to the gui
        int n = PremierLeagueManager.FootballClubsArraylist.size();
        FootballClub temp = null;                   // bubble sort is used here to sort football clubs according to points
        for(int i=0; i < n-1; i++){
            for(int j=0; j < (n-i-1); j++){
                if (PremierLeagueManager.FootballClubsArraylist.get(j).getCurrentPointOfClub() > PremierLeagueManager.FootballClubsArraylist.get(j + 1).getCurrentPointOfClub()) {
                    temp = PremierLeagueManager.FootballClubsArraylist.get(j);
                    PremierLeagueManager.FootballClubsArraylist.set(j, PremierLeagueManager.FootballClubsArraylist.get(j + 1));
                    PremierLeagueManager.FootballClubsArraylist.set(j + 1, temp);
                }
                if(PremierLeagueManager.FootballClubsArraylist.get(j).getCurrentPointOfClub() == PremierLeagueManager.FootballClubsArraylist.get(j + 1).getCurrentPointOfClub()){
                    int goalDif =PremierLeagueManager.FootballClubsArraylist.get(j).getScoredGoals()-PremierLeagueManager.FootballClubsArraylist.get(j).getReceivedGoals();
                    int goalDifTwo =PremierLeagueManager.FootballClubsArraylist.get(j+1).getScoredGoals()-PremierLeagueManager.FootballClubsArraylist.get(j+1).getReceivedGoals();
                    if (goalDif > goalDifTwo) {
                        temp = PremierLeagueManager.FootballClubsArraylist.get(j);
                        PremierLeagueManager.FootballClubsArraylist.set(j, PremierLeagueManager.FootballClubsArraylist.get(j + 1));
                        PremierLeagueManager.FootballClubsArraylist.set(j + 1, temp);
                    }

                }

            }
        }
        Collections.reverse(PremierLeagueManager.FootballClubsArraylist);  // used this to make the sorted result into descending order
        return PremierLeagueManager.FootballClubsArraylist;
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/sortGoals")
    public ArrayList<FootballClub> sortGoals(){      //this method is used to sort  according to goals send object data to the gui
        int n = PremierLeagueManager.FootballClubsArraylist.size();
        FootballClub temp = null;
        for(int i=0; i < n-1; i++){
            for(int j=0; j < (n-i-1); j++){
                if (PremierLeagueManager.FootballClubsArraylist.get(j).getScoredGoals() > PremierLeagueManager.FootballClubsArraylist.get(j + 1).getScoredGoals()) {
                    temp = PremierLeagueManager.FootballClubsArraylist.get(j);
                    PremierLeagueManager.FootballClubsArraylist.set(j, PremierLeagueManager.FootballClubsArraylist.get(j + 1));
                    PremierLeagueManager.FootballClubsArraylist.set(j + 1, temp);
                }
            }
        }
        Collections.reverse(PremierLeagueManager.FootballClubsArraylist);
        return PremierLeagueManager.FootballClubsArraylist;    // used this to make the sorted result into descending order
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/sortWins")
    public ArrayList<FootballClub> sortWins(){  //this method is used to sort  according to wins send object data to the gui
        int n = PremierLeagueManager.FootballClubsArraylist.size();
        FootballClub temp = null;
        for(int i=0; i < n-1; i++){
            for(int j=0; j < (n-i-1); j++){
                if (PremierLeagueManager.FootballClubsArraylist.get(j).getWins() > PremierLeagueManager.FootballClubsArraylist.get(j + 1).getWins()) {
                    temp = PremierLeagueManager.FootballClubsArraylist.get(j);
                    PremierLeagueManager.FootballClubsArraylist.set(j, PremierLeagueManager.FootballClubsArraylist.get(j + 1));
                    PremierLeagueManager.FootballClubsArraylist.set(j + 1, temp);
                }
            }
        }
        Collections.reverse(PremierLeagueManager.FootballClubsArraylist); // to change to descending order

        return PremierLeagueManager.FootballClubsArraylist;
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/matchTable")            // this method is used to send match data to GUI
    public ArrayList<Match> matchtable(){
        return PremierLeagueManager.PlayedMatchArraylist;
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping("/Searchandsort")  //this method is used to retrive data from the GUI and also send data accordingly
    public ArrayList<Match> Searchandsort(@RequestBody String date){
        System.out.println("User input : "+date);
        try {
            String[] dateComponents = date.split("/"); //using String split method to split and assign data
            int day = Integer.parseInt(dateComponents[0]);//split data is converted to integers and assigned
            int month = Integer.parseInt(dateComponents[1]);
            int year = Integer.parseInt(dateComponents[2]);
        System.out.println("Date Selected : "+day+"/"+month+"/"+year);
        for(int i=0;i<PremierLeagueManager.PlayedMatchArraylist.size();i++) {  // this for loop checks if the date inputted by user is inside an object in the arraylist
            if(PremierLeagueManager.PlayedMatchArraylist.get(i).getMdate().equalTo(day,month,year)){
                selectedByDateArraylist.add(PremierLeagueManager.PlayedMatchArraylist.get(i));
            }
        }
        for(Match i : selectedByDateArraylist) {  // this for loop is print object
            System.out.println(i);
        }
        }catch (Exception e){
            System.out.println("Error, try again !!");
            System.out.println("Please type exactly as the placeholder eg :- 20/11/2020 ");
        }
        return selectedByDateArraylist;

    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/generateMatch")
    public ArrayList<Match> generateMatch(){  //this method id used generate and sort matches
        System.out.println(" ");
        System.out.println(" "); //below random numbers are generated to put as date and assign
        int rdate = ThreadLocalRandom.current().nextInt(1, 28);
        int rmonth = ThreadLocalRandom.current().nextInt(1, 12);
        int ryear = ThreadLocalRandom.current().nextInt(2018, 2022);;
        MatchDate mdate = new MatchDate(rdate,rmonth,ryear); // date object is created
        System.out.println("Random generated date : "+mdate.toString());
        //generating random numbers to pick an index number of an FootballClub object
        int crandom1 =0,crandom2 =0;
        int arraysize = PremierLeagueManager.FootballClubsArraylist.size();
        crandom1 = ThreadLocalRandom.current().nextInt(arraysize);
        do {  //because of the do while loop random number will be generated and a club will be picked every time the 2 nd club is equal to the 1st club
            crandom2 = ThreadLocalRandom.current().nextInt(arraysize);
        }while (crandom1==crandom2);
        String fbctemp = PremierLeagueManager.FootballClubsArraylist.get(crandom1).getClubName();
        System.out.println("Randomly picked Club 1 name : "+fbctemp);
        String fbctemp2 = PremierLeagueManager.FootballClubsArraylist.get(crandom2).getClubName();
        System.out.println("Randomly picked Club 2 name : "+fbctemp2);
        int crandomscore1=0 ,crandomscore2 =0;
        crandomscore1 = ThreadLocalRandom.current().nextInt(arraysize);
        do {// this do while loop ensures the scores are not equal
            crandomscore2 = ThreadLocalRandom.current().nextInt(arraysize);
        }while (crandomscore1==crandomscore2);

        System.out.println("Randomly picked Club 1 Score : "+crandomscore1);
        System.out.println("Randomly picked Club 2 Score : "+crandomscore2);

        PremierLeagueManager pm = new PremierLeagueManager();//object created to use
        pm.addPlayedMatch(fbctemp,fbctemp2,crandomscore1,crandomscore2,mdate); //played match data is passed to the method
        System.out.println(" The randomly generated match details is shown at the bottom of the table.before being sorted.");
        System.out.println(" Refresh webpage to show new match on the table");
        return PremierLeagueManager.PlayedMatchArraylist;
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/matchSortByDate")
    public ArrayList<Match> matchSortByDate(){
        int n = PremierLeagueManager.PlayedMatchArraylist.size();
        Match temp = null;     // bubble sort is used to sort according to date
        for(int i=0; i < n-1; i++){
            for(int j=0; j < (n-i-1); j++){
                // days amount = days + (month *30) + (year *360) to get a close full amount of days for the year , also
                int daysAmountj = PremierLeagueManager.PlayedMatchArraylist.get(j).getMdate().getDate() + (PremierLeagueManager.PlayedMatchArraylist.get(j).getMdate().getMonth() * 30) + (PremierLeagueManager.PlayedMatchArraylist.get(j).getMdate().getYear() * 365) ;
                int daysAmountj1 = PremierLeagueManager.PlayedMatchArraylist.get(j+1).getMdate().getDate() + (PremierLeagueManager.PlayedMatchArraylist.get(j+1).getMdate().getMonth() * 30) +(PremierLeagueManager.PlayedMatchArraylist.get(j+1).getMdate().getYear() * 365) ;
                if (daysAmountj > daysAmountj1) {
                    temp = PremierLeagueManager.PlayedMatchArraylist.get(j);
                    PremierLeagueManager.PlayedMatchArraylist.set(j, PremierLeagueManager.PlayedMatchArraylist.get(j + 1));
                    PremierLeagueManager.PlayedMatchArraylist.set(j + 1, temp);
                }
            }
        }
        return PremierLeagueManager.PlayedMatchArraylist;
    }


    public static void main(String[] args) {
        SpringApplication.run(UserinterfaceApplication.class, args);


        loadData();// this method is called here to read previous data
        //console menu starts here
        Scanner dsc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("welcome to Premier League Manager console menu.");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" Please select a option below ");
        System.out.println("Enter \"A\" to add a football club");
        System.out.println("Enter \"R\" to add a played match");
        System.out.println("Enter \"M\" to show match data");
        System.out.println("Enter \"D\" to delete/relegate a football club");
        System.out.println("Enter \"V\" to display stats of a football club");
        System.out.println("Enter \"T\" to Display the Premier League Table");
        System.out.println("Enter \"G\" to show GUI");
        System.out.println("Enter \"S\" to save to file");
        System.out.println("Enter \"Q\" to quit");
        consolemenu:
        {
            while (true) {
                selectedByDateArraylist.clear();
                System.out.println("");
                System.out.println("Select option :");
                String Option = dsc.next().toUpperCase(); //input is converted to uppercase
                switch (Option) {
                    case "A":
                        addFootballClub();
                        break;
                    case "R":
                        addMatchResults();
                        break;
                    case "G":
                        System.out.println("GUI loaded");
                        System.out.print("Open browser and use ");
                        break;
                    case "M":
                        showMatchData();
                        break;
                    case "D":
                        deleteFootballClub();
                        System.out.println("please refresh the browser page to show changes in the GUI .");
                        break;
                    case "V":
                        System.out.println(" ----Football Club Status---- ");
                        displayStats();
                        break;
                    case "T":
                        System.out.println("                                                  Premier League Table");
                        System.out.println(" ");
                        displayTable();
                        break;
                    case "S":
                        saveToFile();
                        break;
                    case "Q":
                        System.out.println("Thank you for using Premier League Manager .");
                        System.exit(1);
                    default:
                        System.out.println("invalid input try again");
                }

            }
        }
    }



    private static void showMatchData() { // this method is to show match data
        for(Match m1 : PremierLeagueManager.PlayedMatchArraylist) {
            System.out.println(m1);
        }
    }

    private static void addFootballClub() { // this method is used to add user input data accordingly to the addfootballclub method
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("enter football club name :");
            String fcname = sc.nextLine();
            for (int i = 0; i < PremierLeagueManager.FootballClubsArraylist.size(); i++) {
                if (PremierLeagueManager.FootballClubsArraylist.get(i).getClubName().equals(fcname)) {
                    System.out.println(" there is a football club with the same name here");
                    return;
                }
            }   //below variables keep user input data temporaly until it is passed to the method
            System.out.print("enter football club location :");
            String fclocation = sc.nextLine();
            System.out.print("enter football club wins :");
            int fcwins = sc.nextInt();
            System.out.print("enter football club draws :");
            int fcdraws = sc.nextInt();
            System.out.print("enter football club defeats :");
            int fcdefeats = sc.nextInt();
            System.out.print("enter football club goals recived :");
            int fcrgoals = sc.nextInt();
            System.out.print("enter football club goals scored :");
            int fcsgoals = sc.nextInt();
            System.out.print("enter football club current points :");
            int fccpoints = sc.nextInt();
            System.out.print("enter football club's no of matches played :");
            int fcnomatches = sc.nextInt(); //below an footballClub object is created and stored to an arraylist
            FootballClub fbi = new FootballClub(fcname, fclocation, fcwins, fcdraws, fcdefeats, fcrgoals, fcsgoals, fccpoints, fcnomatches);
            PremierLeagueManager pm = new PremierLeagueManager();
            pm.addFootballClub(fbi);
        }catch (Exception e){
            System.out.println(" please enter an integer ! ");
        }

    }

    private static void addMatchResults() {   //this method is used add user input data to the addplayedmatch method
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println(" enter date (only type numbers eg:- Year : 2020 , month :6 , day : 28)");
            System.out.print("year :");
            int myear = sc.nextInt();
            System.out.print("month :");
            int mmonth = sc.nextInt();
            if(mmonth>12){ //validation to not get more than a value of 12 for month
                System.out.println("month can't be more than 12 ");
                return;
            }
            System.out.print("day :");
            int mday = sc.nextInt();
            if(mday>31){ // validate number of days for month
                System.out.println(" invalid day for month ");
                return;
            }

            MatchDate mdate = new MatchDate(mday,mmonth,myear); // mdate object is created

            //getting club details starts
            int c1score = 0, c2score = 0;
            //Scanner sc = new Scanner(System.in);
            System.out.println("enter club names");
            System.out.print(" club 1 name :");
            String c1 = sc.next(); //below for loop checks if the clubs excistance in the arraylist
            for (int i = 0; i < PremierLeagueManager.FootballClubsArraylist.size(); i++) {
                if (PremierLeagueManager.FootballClubsArraylist.get(i).getClubName().equals(c1)) {
                    System.out.print("  enter " + c1 + "'s score :");
                    c1score = sc.nextInt();
                    break;
                } else {
                    if (i == (PremierLeagueManager.FootballClubsArraylist.size() - 1)) {
                        System.out.println("the club name you entered doesn't exist in the premier league");
                        return;
                    }
                }
            }
            System.out.print(" club 2 name :");
            String c2 = sc.next();
            for (int i = 0; i < PremierLeagueManager.FootballClubsArraylist.size(); i++) {
                if (PremierLeagueManager.FootballClubsArraylist.get(i).getClubName().equals(c2)) {
                    System.out.print("  enter " + c2 + "'s score :");
                    c2score = sc.nextInt();
                    break;
                } else {
                    if (i == (PremierLeagueManager.FootballClubsArraylist.size() - 1)) {
                        System.out.println("the club name you entered doesn't exist in the premier league");
                        return;
                    }
                }
            }
            PremierLeagueManager pm = new PremierLeagueManager();
            pm.addPlayedMatch(c1,c2,c1score,c2score,mdate);

            System.out.println(" Please Refresh web page to show changes in the GUI.");
        }catch (Exception i){
            System.out.println("please enter numbers only for scores,days,months and years");
        }


    }

    private static void deleteFootballClub() { // this method gets user input for deleting and calls deletefootballclub method
        Scanner sc = new Scanner(System.in);
        System.out.print("enter football club name you want to relegate/delete :");
        String fcdname =sc.nextLine();
        PremierLeagueManager pm = new PremierLeagueManager();
        pm.deleteFootballClub(fcdname);

    }
    private static void displayStats() {  // this method gets user input for a club to show and calls the method to do so
        Scanner sc = new Scanner(System.in);
        System.out.print("enter football club name you want to display :");
        String fcname =sc.nextLine();
        PremierLeagueManager pm = new PremierLeagueManager();
        pm.displayStats(fcname);
    }
    private static void displayTable() {
        PremierLeagueManager pm = new PremierLeagueManager();
        pm.displayPremierLeagueTable();

    }
    private static void saveToFile() {
        PremierLeagueManager pm = new PremierLeagueManager();
        pm.saveToFile();
        System.out.println("\n your data was saved to an external text file");

    }
    private static void loadData() {
        PremierLeagueManager pm = new PremierLeagueManager();
        pm.readData();
    }

}

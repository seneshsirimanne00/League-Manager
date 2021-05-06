package com.w1761091.userinterface;
//UOW ID- W1761091
import org.springframework.stereotype.Component;
import java.io.Serializable;
@Component
public class MatchDate implements Serializable {
    private int year;
    private int month;
    private int date;

    public MatchDate(){
    }
    public MatchDate(int date,int month,int year){
        this.date=date;
        this.month=month;
        this.year=year;
    }
    public int getYear() {
        return year; }
    public void setYear(int year) {

        this.year = year;
    }
    public int getMonth() {

        return month;
    }
    public void setMonth(int month) {

        this.month = month;
    }
    public int getDate() {

        return date;
    }
    public void setDate(int date) {

        this.date = date;
    }
    public Boolean equalTo(int sdate,int smonth,int syear) {  // this method is used to check equality of dates
        if (date == sdate && month == smonth && year == syear) {
            return true;
        } else {
            return false;
        }
    }
    public String toString(){
        return date +"/"+this.month+"/"+this.year;
    }

}

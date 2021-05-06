import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent implements OnInit {

  matchs:any;
  searchDate : String;
  


  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    let responsematch = this.http.get("http://localhost:8080/matchTable");
    responsematch.subscribe((data)=>this.matchs=data);

  }

  generstematch(){
    let responsematch = this.http.get("http://localhost:8080/generateMatch");
    responsematch.subscribe((data)=>this.matchs=data);
  }

  sortMatchByDate(){
    let responsematch = this.http.get("http://localhost:8080/matchSortByDate");
    responsematch.subscribe((data)=>this.matchs=data);
  }

  searchAndSort(){
    console.log(this.searchDate);
    let responsematch = this.http.post("http://localhost:8080/Searchandsort",this.searchDate);
    responsematch.subscribe((data)=>this.matchs=data);
  }

}

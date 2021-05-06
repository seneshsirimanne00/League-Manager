import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footballclub',
  templateUrl: './footballclub.component.html',
  styleUrls: ['./footballclub.component.css']
})
export class FootballclubComponent implements OnInit {

  footballclubs:any;
  footballclubsg:any;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    let response= this.http.get("http://localhost:8080/show");
    response.subscribe((data)=>this.footballclubs=data);
  }

  drawTable(){
    let response= this.http.get("http://localhost:8080/show");
    response.subscribe((data)=>this.footballclubs=data);
  }

  sortGoals(){
    let response= this.http.get("http://localhost:8080/sortGoals");
    response.subscribe((data)=>this.footballclubs=data);
  }

  sortWins(){
    let response= this.http.get("http://localhost:8080/sortWins");
    response.subscribe((data)=>this.footballclubs=data);
  }

}

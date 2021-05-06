import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FootballclubComponent } from './footballclub/footballclub.component';
import {HttpClientModule} from '@angular/common/http';
import { MatchComponent } from './match/match.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    FootballclubComponent,
    MatchComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AdaptiveQuizComponent } from './adaptive-quiz/adaptive-quiz.component';


@NgModule({
  declarations: [
    AppComponent,
    AdaptiveQuizComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

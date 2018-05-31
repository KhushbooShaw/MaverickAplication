import { Component, SystemJsNgModuleLoader, OnInit } from "@angular/core";
import * as Stomp from "stompjs";
import * as SockJS from "sockjs-client";

import { MatDialog } from "@angular/material";
import { ResponseData } from "../responseData";
import { MultiPlayerRulesComponent } from "../multi-player-rules/multi-player-rules.component";

@Component({
  selector: "app-multi-player-game",
  templateUrl: "./multi-player-game.component.html",
  styleUrls: ["./multi-player-game.component.css"]
})
export class MultiPlayerGameComponent implements OnInit {
  
  data: string[] = [];
  options: string[] = [];
  showConversation: boolean = false;
  ws: any;

  questions:ResponseData;
  
  userId: number;
  userName: string;
  questionId: number;
  questionStamp: string;

  op1: string;
  op2: string;
  op3: string;
  op4: string;
  selectedAnswer: string;
  startTime: number;
  endTime: number;
  totalTime: number;

  disabled: boolean;
  message: any;
  i = 1;

  //jsonData: ResponseData

  constructor(public dialog: MatDialog) {}

  openDialog(): void {
    let dialogRef = this.dialog.open(MultiPlayerRulesComponent, {
      width: "350px",
      height: "350px"
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log("The dialog was closed");
    });
  }
  connect() {
    
    var socket = new SockJS("http://localhost:8081/greeting");
    this.ws = Stomp.over(socket);

    let that = this;
    this.ws.connect(
      {},

      function(frame) {
        that.ws.subscribe("/errors", function(message) {
          alert("Error " + message.body);
        });

        that.ws.subscribe("/topic/reply", function(message) {
          console.log(message);
          that.showGreeting(message.body);
        });
        that.disabled = true;
      }

      //this function is used to show alert box when disconnect socket
      // function(error) {
      //   alert("STOMP error " + error);
      // }
    );
  }

  disconnect() {
    if (this.ws != null) {
      this.ws.ws.close();
    }
    this.setConnected(false);
    console.log("Disconnected");
  }

  sendResponse() {
    console.log("Data Send ==========>");
      let data = JSON.stringify({
        questionId: "11",
        selectedResponse: "any",
      });
      console.log("edelwksamdkmsdasmk==============>" + data);
      this.ws.send("/app/message", {}, data);
      
    } 
      // let data = JSON.stringify({
      //   userName: this.userName,
      //   userId: this.userId,
      //   questionStamp: this.questionStamp,
      //   questionId: this.questionId
      // });
      // console.log("edelwksamdkmsdasmk==============>" + data);
      // this.ws.send("/app/message", {}, data);
  
      sendAnswer(answer){
        this.selectedAnswer = answer;
        let ans = JSON.stringify({
            questionId: this.questionId,
            selectedResponse: this.selectedAnswer,

          });
          console.log("selected data ==============>" + ans);
          this.ws.send("/app/message", {}, ans);
          this.i++;
      }

  showGreeting(message) {
    this.showConversation = true;
    this.message=message;
    console.log("===>"+message)
    console.log("Type of Data =====> "+typeof message)
    let rep = message.replace("{","").replace("}","").replace(/"/g,'');
    let quest = rep.split(",");
    console.log(quest);
   // let question = quest.split(":");
    for(let j = 0;j<=quest.length;j++){
      this.data[j] = quest[j];
    }
    console.log("Hello");
    this.questionId = this.i;
    console.log(this.questionId);
    this.questionStamp = this.data[2].split(':')[1];
    console.log("kkkk="+this.questionStamp)
    this.op1 = this.data[3].split(":")[1]
    this.op2 = this.data[4].split(":")[1]
    this.op3 = this.data[5].split(":")[1]
    this.op4 = this.data[6].split(":")[1]
      
    console.log(this.op1)
    console.log("sjewrur=========================================>"+this.options)
  
    console.log("splited data=====>"+ this.data)

    this.data.push();

    console.log("Response Data : " + this.data);
  }

  setConnected(connected) {
    this.disabled = connected;
    this.showConversation = connected;
    this.data = [];
  }

  ngOnInit() {
    this.connect();
  }
}

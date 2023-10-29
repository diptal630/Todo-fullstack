import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {



  message = 'Some Welcome Message'
  welcomeMessageFromService : any 
  name =''
  
  constructor(
    private route : ActivatedRoute,
    private service: WelcomeDataService
    ){}
  ngOnInit(): void {
    console.log(this.message)
    //console.log(this.route.snapshot.params['name'])
    this.name = this.route.snapshot.params['name']
  }


getWelcomeMessage(){
  console.log(this.service.executeHellloWorldBeanService());
  this.service.executeHellloWorldBeanService().subscribe(
    response => this.handleSuccessfulResponse(response),
    error => this.handleErrorResponse(error)
  );
  console.log("last line of welcome message")
}

getWelcomeMessageWithVariable(){
  console.log(this.service.executePathVariable(this.name));
  this.service.executeHellloWorldBeanService().subscribe(
    response => this.handleSuccessfulResponse(response),
    error => this.handleErrorResponse(error)
  );
  console.log("last line of welcome message")
}

handleSuccessfulResponse(response : any){
 //console.log(response.message)
 this.welcomeMessageFromService = response.message
}


handleErrorResponse(error : any){
 // console.log(error)
  //console.log(error.error)
  //console.log(error.error.message)
  this.welcomeMessageFromService = error.error.message
}
}

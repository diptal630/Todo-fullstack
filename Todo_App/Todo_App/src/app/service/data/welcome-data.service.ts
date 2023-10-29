import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class HelloWorldBean{
  constructor(public message:string){}
}

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    private http:HttpClient
  ) { }

  executeHellloWorldBeanService(){
    return this.http.get<HelloWorldBean>('http://localhost:8081/hello-world-bean');
    //console.log("Execute Hello World Bean Service");
  }


  executePathVariable(name:string){
    return this.http.get<HelloWorldBean>(`http://localhost:8081/hello-world/path-variable/in28minutes/${name}`)
  }

  executeHelloWorldServiceWithPathVariable(name : string){
    let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization : basicAuthHeaderString
    })
    return this.http.get<HelloWorldBean>(`http://localhost:8080/hello-world/path-variable/${name}`, {headers})
  }

  createBasicAuthenticationHttpHeader(): string{
    let username = 'in28minutes'
    let password = 'dummy'
    let basicAuthHeaderString = 'Basic' + window.btoa(username +':' + password);
    return basicAuthHeaderString
  }

}

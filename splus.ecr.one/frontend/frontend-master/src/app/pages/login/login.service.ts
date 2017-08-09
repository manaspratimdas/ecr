import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/map'
import {Observable} from 'rxjs/Observable';

@Injectable()
export class LoginService {
 
    email: string; 
    username: string;
    companyid: string;
  pass: string;

    constructor(private http: Http){
    }
   userData(){
     console.log("get user data from db..");
     
     
           return this.http.get('http://localhost:8080/ecr/user/loggedIn_users?')
             .map((response: Response) => {
               let user = response.json();
               console.log("application user is : "+user['username']);
               if (user && user.token) {
               }
                return user;
            });
    }
  
      test(credentials){
        console.log("insert user in db..");
        this.email = credentials['email'];
        this.pass = credentials['password'];
      //  console.log("application email is :");
     //   console.log("application email is : " + credentials['email']);
      let myJSON = JSON.stringify({ "email":credentials['email'],"pass":credentials['password'] } );
        let cached: any;
        
    if (cached = sessionStorage.getItem("http://localhost:8080/ecr/user/login")) {
        return Observable.of(JSON.parse(cached));
    } else {
        return this.http.post("http://localhost:8080/ecr/user/login",myJSON).map((response: Response) => {
            sessionStorage.setItem("http://localhost:8080/ecr/user/login", response.text());
            sessionStorage.setItem("IP", "http://localhost:8080");
            sessionStorage.removeItem("add2Cart");
            return response.json();
        });
    }

       
//    }
        
  
 }}
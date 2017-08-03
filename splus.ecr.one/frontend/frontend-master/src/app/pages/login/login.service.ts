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
    user: string;

    constructor(private http: Http){
        this.user = "dhiraj";
            // this.username = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))['username'];
            // this.companyid = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))['companyId'];
            
    }
 
      test(credentials){
        console.log("insert user in db..");
        this.email = credentials['email'];
        this.pass = credentials['password'];
        console.log("application email & pass :"+this.email + ","+this.pass);
     
        let myJSON = JSON.stringify({ "email":credentials['email'],"pass":credentials['password'] } );
        let cached: any;
        
    if (cached = sessionStorage.getItem("http://localhost:8080/ecr/user/login")) {
        return Observable.of(JSON.parse(cached));
    } else {
        return this.http.post("http://localhost:8080/ecr/user/login",myJSON).map((response: Response) => {
            sessionStorage.setItem("http://localhost:8080/ecr/user/login", response.text());
            this.username = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))['username'];
            this.companyid = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))['companyId'];
            
            return response.json();
        });
    }

       
//    }
        
  
 }}
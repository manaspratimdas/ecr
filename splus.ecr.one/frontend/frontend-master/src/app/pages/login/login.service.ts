import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';

import 'rxjs/add/operator/map'

@Injectable()
export class LoginService {
 
    email: string; 
    username: string;
    companyid: string;

    constructor(private http: Http) { 
      
    }
    userData(){
        console.log("get user data from db..");
           return this.http.get('http://localhost:8080/login')
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
        return this.http.get('http://localhost:8080/login')
            .map((response: Response) => {
                let user = response.json();
                this.username = user['email'];
                
            });
 
    }
        
  
 }
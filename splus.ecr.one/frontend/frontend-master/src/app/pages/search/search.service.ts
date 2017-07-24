import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';


@Injectable()
export class SearchService {

   constructor(private http: Http) {
   console.log("in service..");
 }

  getData() {
    
     return this.http.get('http://localhost:8080/search')
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let user = response.json();
                console.log(user);
//                return new Promise((resolve, reject) => {
//                  setTimeout(() => {
//                    resolve(user);
//                  }, 2000);
//                });
              localStorage.setItem('currentUser', JSON.stringify(user));
                return user;
    });
  }
}

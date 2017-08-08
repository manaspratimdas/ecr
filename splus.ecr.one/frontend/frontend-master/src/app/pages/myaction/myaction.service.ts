import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

@Injectable()
export class MyActionService {

    constructor(private http: Http) { 
  
  }
  getData() {
   //window.alert("in myAction service..");
     
      return this.http.get('http://localhost:8080/ecr/cart/save')
              .map((response: Response) => response.json());
}

}

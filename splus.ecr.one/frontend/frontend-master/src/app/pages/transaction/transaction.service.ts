import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';


@Injectable()
export class TransactionService {

  constructor(private http: Http) { 
  
  }

  getData() {

    // window.alert("in transaction service..");
     
      return this.http.get('http://localhost:8080/ecr/cart/save')
              .map((response: Response) => response.json());
  }
  // getData(): Promise<any> {
  //   return new Promise((resolve, reject) => {
  //     setTimeout(() => {
  //       resolve(this.smartTableData);
  //     }, 2000);
  //   });
  // }
}

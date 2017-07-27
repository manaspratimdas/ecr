import { Injectable } from '@angular/core';
import { Jsonp } from '@angular/http';
import { Http, Response, Headers } from '@angular/http';
import { LocalDataSource } from 'ng2-smart-table';

@Injectable()
export class InventoryService {

 constructor(private http: Http) {
   console.log("in service..");
 }
    status: string;
    condition: string;
  oldCondition: string;
  getData() {
  console.log("GET");
    
    return this.http.get('http://localhost:8080/inventory')
            .map((response: Response) => {
                let user = response.json();
                console.log("http - result : "+user);
                if (user && user.token) {
                }
                return user;
            });
}
  
    test(event) {
      this.status = event.newData['c_status'];
      this.condition = event.newData['c_condition'];
      //  this.oldCondition = event.data['c_condition'];
      console.log("In post call");
      
      console.log('http://localhost:8080/updateData'+'?status='+this.status+'?condition='+this.condition);
      return this.http.post('http://localhost:8080/updateData'+'?status='+this.status+'&condition='+this.condition,JSON.stringify({ 'Content-Type': 'application/json' }))
            .map((response: Response) => response.json());
}
}

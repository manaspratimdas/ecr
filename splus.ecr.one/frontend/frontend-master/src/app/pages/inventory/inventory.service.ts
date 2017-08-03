import { Injectable } from '@angular/core';
import { Jsonp,RequestOptions } from '@angular/http';
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
  companyId: string;
  getData() {
  console.log("GET");
    var sessionData = sessionStorage.getItem("http://localhost:8080/ecr/user/login");
    console.log("sessionData" + sessionData);
    
    this.companyId = JSON.parse(sessionData)['companyId'];
    console.log("this.companyId : "+this.companyId);
    console.log("http://localhost:8080/ecr/company/"+this.companyId+"/containers")
    return this.http.get("http://localhost:8080/ecr/company/"+this.companyId+"/containers")
            .map((response: Response) => {
                let user = response.json();
                console.log("http - result : "+user);
                if (user && user.token) {
                }
                return user;
            });
}
  
      update(jsonW) {
      
     // var RRR = "[{\"id\":1,\"code\":\"CLHU8817406\",\"port\":{\"id\":1,\"isoPortName\":\"FRBZL\",\"isoPortCode\":\"FRBZL\",\"country\":{\"id\":1,\"name\":\"INDIA\",\"isoCountryCode\":\"IN\",\"isoLocalName\":\"INDIA\",\"region\":{\"id\":1,\"name\":\"ASIA\",\"regionCode\":\"AS\"}},\"longitude\":\"798273498273.8\",\"latitude\":\"235716253761.9\"},\"containerType\":{\"id\":1,\"size\":\"40\",\"type\":\"PS\",\"description\":\"40x9 6,Open top, open ends (skeletal)\"},\"containerCondition\":\"Good\",\"status\":\"A\"}]";
      
      console.log("json array : "+"[" + jsonW + "]");  
      var jsonD = "[" + jsonW + "]";
      console.log("result : "+jsonD);
      
      var headers = new Headers();
      headers.append('Content-Type','application/json; charset=utf8');
      
      return this.http.post('http://localhost:8080/ecr/containers/update',jsonD,{headers:headers})
              .map((response: Response) => response.json());
  }


  delete(jsonW) {

      console.log("json array : "+"[" + jsonW + "]");  
     // var jsonD = "[" + jsonW + "]";
     // var jsonD = jsonW;
      console.log("result : "+jsonW);
      
      var headers = new Headers();
      headers.append('Content-Type','application/json; charset=utf8');
      
      return this.http.post('http://localhost:8080/ecr/containers/delete',jsonW,{headers:headers})
            .map((response: Response) => response.json());
    
  }
}

import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

@Injectable()
export class MyActionService {

    companyId: string;
    constructor(private http: Http) { 
  
  }
  getDataforLender() {
    var sessionData = sessionStorage.getItem("http://localhost:8080/ecr/user/login");
    console.log("sessionData" + sessionData);
    
    this.companyId = JSON.parse(sessionData)['companyId'];
    console.log("this.companyId : "+this.companyId);
     
      return this.http.get("http://localhost:8080/ecr/adapter/cart/lender/action/"+this.companyId)
              .map((response: Response) => response.json());
}
getDataforBorrower(){
    var sessionData = sessionStorage.getItem("http://localhost:8080/ecr/user/login");
    console.log("sessionData" + sessionData);
    
    this.companyId = JSON.parse(sessionData)['companyId'];
    console.log("this.companyId : "+this.companyId);
     
      return this.http.get("http://localhost:8080/ecr/adapter/cart/borrower/action/"+this.companyId)
              .map((response: Response) => response.json());
  
}

onConfirm(selectedRows){
  
  //  window.alert("selected : "+selectedRows);
    console.log("hello");
    
      return this.http.get('http://localhost:8080/ecr/lender/onConfirm/containers/'+selectedRows)
              .map((response: Response) => response.json());
  
  }
  
  onReject(selectedRows){
  
      return this.http.get('http://localhost:8080/ecr/lender/onReject/containers/'+selectedRows)
              .map((response: Response) => response.json());
  
  }
  
  onRelease(selectedRows){
    
   return this.http.get('http://localhost:8080/ecr/borrower/onRelease/containers/'+selectedRows)
              .map((response: Response) => response.json());
 
  }
}

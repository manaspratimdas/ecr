import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';


@Injectable()
export class TransactionService {

  constructor(private http: Http) { 
  
  }

  getData(companyId) {
    
   // console.log("in borrower service.."+"http://localhost:8080/ecr/cart/company/2");
    console.log("company id : "+companyId);

    return this.http.get(sessionStorage.getItem("IP")+':8080/ecr/adapter/cart/lender/trans/'+companyId)
              .map((response: Response) => response.json());
  }

 getBorrowerData(companyId) {
    
    //console.log("in borrower service.."+"http://localhost:8080/ecr/adapter/cart/company");
    console.log("company id : "+companyId);

    return this.http.get(sessionStorage.getItem("IP")+':8080/ecr/adapter/cart/borrower/trans/'+companyId)
              .map((response: Response) => response.json());
  
 }

 getLenderData(companyId) {
  
    //console.log("in borrower service.."+"http://localhost:8080/ecr/cart/company/"+companyId);
    console.log("company id : "+companyId);

    return this.http.get(sessionStorage.getItem("IP")+':8080/ecr/adapter/cart/lender/trans/'+companyId)
              .map((response: Response) => response.json());
  
 }
}

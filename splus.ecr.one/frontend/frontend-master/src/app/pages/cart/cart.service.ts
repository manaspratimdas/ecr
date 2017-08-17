import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

@Injectable()
export class CartService {
  
  companyId: string;
  selectedType: string;
  selectedCountry: string;
  selectedPort: string;
  selectedCompany: string;

  constructor(private http: Http) { }

  
  saveToCart(jsonW) {

    console.log("result : "+jsonW);
      
      var headers = new Headers();
      headers.append('Content-Type','application/json; charset=utf8');
      
      return this.http.post(sessionStorage.getItem("IP")+':8080/ecr/cart/save',jsonW,{headers:headers})
              .map((response: Response) => response.json());
  }

}
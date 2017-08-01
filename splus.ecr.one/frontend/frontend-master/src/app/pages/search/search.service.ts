import {Injectable} from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

@Injectable()
export class SearchService {
  selectedType: string;
  selectedCountry: string;
  selectedPort: string;
  selectedCompany: string;

  constructor(private http: Http) { }

  getSearchData() {
    
     return this.http.get('http://localhost:8080/ecr/containers')
            .map((response: Response) => {
                let user = response.json();
                console.log("http - result : "+user);
                if (user && user.token) {
                }
                return user;
            });
  }
  getData(selectedType,selectedCountry,selectedPort,selectedCompany) {

    console.log("in serach service.."+selectedType,selectedCountry,selectedPort,selectedCompany);
    // return this.http.post('http://localhost:8080/ecr/search'+'?type='+selectedType
    //         +'&country='+selectedCountry+'&port='+selectedPort+'&company='+selectedCompany,JSON.stringify({ 'Content-Type': 'application/json' }))
    //         .map((response: Response) => response.json());
    return this.http.get('http://localhost:8080/ecr/containers')
            .map((response: Response) => {
                let user = response.json();
                console.log("http - result : "+user);
                if (user && user.token) {
                }
                return user;
            });
  }
  
  test(seletedrows) {
    console.log("in service.."+seletedrows);
       return this.http.get('http://localhost:8080/ecr/containers')
            .map((response: Response) => {
                let user = response.json();
                console.log("http - result : "+user);
                if (user && user.token) {
                }
                return user;
            });
  }
}

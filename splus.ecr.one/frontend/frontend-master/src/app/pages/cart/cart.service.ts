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

}
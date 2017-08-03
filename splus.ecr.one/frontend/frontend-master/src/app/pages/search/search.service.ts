import {Injectable} from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

@Injectable()
export class SearchService {
  
  companyId: string;
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
    
    console.log("in serach service.."+'http://localhost:8080/ecr/search'+'?type='+selectedType
             +'&country='+selectedCountry+'&port='+selectedPort+'&company='+selectedCompany);

     return this.http.get('http://localhost:8080/ecr/search'+'?type='+selectedType
             +'&country='+selectedCountry+'&port='+selectedPort)
             .map((response: Response) => {
                let user = response.json();
                console.log("http - result : "+user);
                if (user && user.token) {
                }
                return user;
            });
  }
  
  test(id) {
    console.log("in service.."+id);
    console.log("url : "+"http://localhost:8080/ecr/containers/"+id);
    
       return this.http.get('http://localhost:8080/ecr/containers/'+id)
            .map((response: Response) => {

                console.log("json data : "+response.json());
                let user = response.json();
                console.log("http - result : "+user['id']);
                return user;
            });
  }

  saveToCart(jsonW) {

    
      //var jsonD = "[" + jsonW + "]";
      console.log("result : "+jsonW);
      
      var headers = new Headers();
      headers.append('Content-Type','application/json; charset=utf8');
      
      return this.http.post('http://localhost:8080/ecr/cart/save',jsonW,{headers:headers})
              .map((response: Response) => response.json());
  }
}

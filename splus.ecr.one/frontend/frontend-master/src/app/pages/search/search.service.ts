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

          var url: string;
    
        if(selectedType!=null&&selectedCountry!=null&&selectedPort!=null&&selectedCompany!=null){
          console.log("in loop..");
          url = 'http://localhost:8080/ecr/search'+'?type='+selectedType+'&country='+selectedCountry+'&port='+selectedPort+'&company='+selectedCompany;
        }else if(selectedType!=null&&selectedCountry!=null&&selectedPort!=null){
             url = 'http://localhost:8080/ecr/search'+'?type='+selectedType+'&country='+selectedCountry+'&port='+selectedPort;
        }else if(selectedType!=null&&selectedCountry!=null&&selectedCompany!=null){
          console.log("in loop..");
          url = 'http://localhost:8080/ecr/search'+'?type='+selectedType+'&country='+selectedCountry+'&company='+selectedCompany;
        }else if(selectedCountry!=null&&selectedPort!=null&&selectedCompany!=null){
          console.log("in loop..");
          url = 'http://localhost:8080/ecr/search'+'?country='+selectedCountry+'&port='+selectedPort+'&company='+selectedCompany;
        }else if(selectedType!=null&&selectedCountry!=null){
             url = 'http://localhost:8080/ecr/search'+'?type='+selectedType+'&country='+selectedCountry;
        }else if(selectedType!=null&&selectedPort!=null){
             url = 'http://localhost:8080/ecr/search'+'?type='+selectedType+'&port='+selectedPort;
        }else if(selectedType!=null&&selectedCompany!=null){
             url = 'http://localhost:8080/ecr/search'+'?type='+selectedType+'&company='+selectedCompany;
        }else if(selectedCountry!=null&&selectedPort!=null){
             url = 'http://localhost:8080/ecr/search'+'?country='+selectedCountry+'&port='+selectedPort;
        }else if(selectedCompany!=null&&selectedCountry!=null){
             url = 'http://localhost:8080/ecr/search'+'?company='+selectedCompany+'&country='+selectedCountry;
        }else if(selectedCompany!=null&&selectedPort!=null){
             url = 'http://localhost:8080/ecr/search'+'?company='+selectedCompany+'&port='+selectedPort;
        }else if(selectedType!=null){
             url = 'http://localhost:8080/ecr/search'+'?type='+selectedType;
        }else if(selectedCountry!=null){
             url = 'http://localhost:8080/ecr/search'+'?country='+selectedCountry;
        }else if(selectedPort!=null){
             url = 'http://localhost:8080/ecr/search'+'?port='+selectedPort;
        }else if(selectedCompany!=null){
             url = 'http://localhost:8080/ecr/search'+'?company='+selectedCompany;
        }else{
            window.alert("Please select one of the field..!");
        }
        
    console.log("in serach service.."+url);

     return this.http.get(url)
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

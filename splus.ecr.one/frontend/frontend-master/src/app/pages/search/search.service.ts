import {Injectable} from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

@Injectable()
export class SearchService {
  
  companyId: string;
  selectedType: string;
  selectedCountry: string;
  selectedPort: string;
  selectedCompany: string;
  test1:string="Heraj Test";

  constructor(private http: Http) { }

  getSearchData() {
    
     return this.http.get(sessionStorage.getItem("IP") + ':8080/ecr/containers')
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
          url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?type='+selectedType+'&country='+selectedCountry+'&port='+selectedPort+'&company='+selectedCompany;
        }else if(selectedType!=null&&selectedCountry!=null&&selectedPort!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?type='+selectedType+'&country='+selectedCountry+'&port='+selectedPort;
        }else if(selectedType!=null&&selectedCountry!=null&&selectedCompany!=null){
          console.log("in loop..");
          url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?type='+selectedType+'&country='+selectedCountry+'&company='+selectedCompany;
        }else if(selectedCountry!=null&&selectedPort!=null&&selectedCompany!=null){
          console.log("in loop..");
          url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?country='+selectedCountry+'&port='+selectedPort+'&company='+selectedCompany;
        }else if(selectedType!=null&&selectedCountry!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?type='+selectedType+'&country='+selectedCountry;
        }else if(selectedType!=null&&selectedPort!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?type='+selectedType+'&port='+selectedPort;
        }else if(selectedType!=null&&selectedCompany!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?type='+selectedType+'&company='+selectedCompany;
        }else if(selectedCountry!=null&&selectedPort!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?country='+selectedCountry+'&port='+selectedPort;
        }else if(selectedCompany!=null&&selectedCountry!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?company='+selectedCompany+'&country='+selectedCountry;
        }else if(selectedCompany!=null&&selectedPort!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?company='+selectedCompany+'&port='+selectedPort;
        }else if(selectedType!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?type='+selectedType;
        }else if(selectedCountry!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?country='+selectedCountry;
        }else if(selectedPort!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?port='+selectedPort;
        }else if(selectedCompany!=null){
             url = sessionStorage.getItem("IP") + ':8080/ecr/search'+'?company='+selectedCompany;
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
    
    
    //console.log("url : "+""sessionStorage.getItem("IP")"/ecr/containers/"+id);
    
       return this.http.get(sessionStorage.getItem("IP") + ':8080/ecr/containers/'+id)
            .map((response: Response) => {

                console.log("json data : "+response.json());
                let user = response.json();
                console.log("http - result : "+user['id']);
                this.test1 = id;
                return user;
            });
  }

  saveToCart(jsonW) {

    
      //var jsonD = "[" + jsonW + "]";
      console.log("result : "+jsonW);
      
      var headers = new Headers();
      headers.append('Content-Type','application/json; charset=utf8');
      
      return this.http.post(sessionStorage.getItem("IP") + ':8080/ecr/cart/save',jsonW,{headers:headers})
              .map((response: Response) => response.json());
  }
}

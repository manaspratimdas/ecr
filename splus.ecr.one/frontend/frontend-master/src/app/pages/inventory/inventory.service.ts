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
    
    return this.http.get('http://localhost:8080/ecr/containers')
            .map((response: Response) => {
                let user = response.json();
                console.log("http - result : "+user);
                if (user && user.token) {
                }
                return user;
            });
}
  
    update(myParams) {
     // this.status = event.newData['c_status'];
     // this.condition = event.newData['c_condition'];
      //  this.oldCondition = event.data['c_condition'];
      
      
      var JSONArray= "[ { \"id\": 4, \"name\": \"AAA container 555\", \"code\": \"AAAU8817405\", \"company\": {   \"id\": 2,  \"name\": \"APOC\",\"address\": {\"id\": 2,\"addressLineOne\": \"150 MOTOR PARKWAY\",\"streetName\": \"SUITE 401\",\"city\": \"MIAMI\",\"country\": {\"id\": 3,\"name\": \"CHN\",\"isoCountryCode\": \"CN\",\"isoLocalName\": \"CHINA\",\"region\": {\"id\": 1,\"name\": \"ASIA\",\"regionCode\": \"AS\"}},\"zip\": \"88825\"}},\"port\": {\"id\": 1,\"isoPortName\": \"Brionne\",\"isoPortCode\": \"FRBNN\",\"country\": {\"id\": 1,\"name\": \"INDIA\",\"isoCountryCode\": \"IN\",\"isoLocalName\": \"IND\",\"region\": {\"id\": 1,\"name\": \"ASIA\",\"regionCode\": \"AS\"}},\"longitude\": \"798273498273.8\",\"latitude\": \"235716253761.9\"},\"containerType\": {\"id\": 1,\"size\": \"40\",\"type\": \"DC\",\"description\": \"Dry Container\"},\"status\": \"A\"}]";
      var jsonData = JSON.parse( JSONArray );   
     // console.log('http://localhost:8080/containers/update'+'?id='+event.newData['id']+'&size ='+event.newData['size']+'&type='+event.newData['type']+'&description='+event.newData['description']+'&description='+event.newData['condition']+'&port='+event.newData['port']+'&depot='+event.newData['depot']);
      return this.http.post('http://localhost:8080/ecr/containers/update',JSON.stringify({ 'Content-Type': 'application/json',data:jsonData, dataType:'json' }))
            .map((response: Response) => response.json());
}
}

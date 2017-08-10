import {Component} from '@angular/core';

import { Http } from '@angular/http'

import {UsersMapService} from './usersMap.service';

@Component({
  selector: 'users-map',
  templateUrl: './usersMap.html',
  styleUrls: ['./usersMap.scss']
})
export class UsersMap {

  mapData:Object;
  containers:any;
  usersMapService:UsersMapService;
  constructor(private _usersMapService:UsersMapService, private http:Http) {

       // this.http.get("http://localhost:8080/ecr/companies").subscribe((data) => {
          //this.containers.push(data);
        //  console.log("testinnggg")
          this.usersMapService = _usersMapService
          this.mapData = this.usersMapService.getData(this.containers);
       // });
    
  }

 
}

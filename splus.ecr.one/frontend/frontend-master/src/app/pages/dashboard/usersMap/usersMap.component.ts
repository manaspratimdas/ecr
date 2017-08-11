import {Component} from '@angular/core';

import { Http } from '@angular/http'

import {UsersMapService} from './usersMap.service';

import {BaThemeConfigProvider, layoutPaths} from '../../../theme';

@Component({
  selector: 'users-map',
  templateUrl: './usersMap.html',
  styleUrls: ['./usersMap.scss']
})
export class UsersMap {

  mapData:Object;
  containers:any;
  usersMapService:UsersMapService;
  constructor(private _baConfig:BaThemeConfigProvider,private _usersMapService:UsersMapService, private http:Http) {
    this.mapData = this._usersMapService.getData();
  }

 
}

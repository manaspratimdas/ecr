import {Injectable} from '@angular/core';
import {BaThemeConfigProvider, layoutPaths} from '../../../theme';
import { Http, Response, Headers } from '@angular/http';

@Injectable()
export class UsersMapService {

  containers:any[] = []; 
  constructor(private _baConfig:BaThemeConfigProvider, private http: Http) {
       
  }

  getData() {
    console.log("in container getData");
    var layoutColors = this._baConfig.get().colors;

    return {
      type: 'map',
      theme: 'blur',
      zoomControl: { zoomControlEnabled: false, panControlEnabled: false },

      dataProvider: {
        map: 'worldLow',
        zoomLevel: 1.0,
        zoomLongitude: 10,
        zoomLatitude: 52,
        areas: this.getDataFromServer(layoutColors)
      },

      areasSettings: {
        rollOverOutlineColor: layoutColors.border,
        rollOverColor: layoutColors.primaryDark,
        alpha: 0.8,
        unlistedAreasAlpha: 0.2,
        unlistedAreasColor: layoutColors.defaultText,
        balloonText: '[[title]]: [[customData]] containers'
      },


      legend: {
        width: '100%',
        marginRight: 27,
        marginLeft: 27,
        equalWidths: false,
        backgroundAlpha: 0.3,
        backgroundColor: layoutColors.border,
        borderColor: layoutColors.border,
        borderAlpha: 1,
        top: 362,
        left: 0,
        horizontalGap: 10,
        data: [
          {
            title: 'over 1 000 users',
            color: layoutColors.primary
          },
          {
            title: '500 - 1 000 users',
            color: layoutColors.successLight
          },
          {
            title: '100 - 500 users',
            color: layoutColors.success
          },
          {
            title: '0 - 100 users',
            color: layoutColors.danger
          }
        ]
      },
      export: {
        enabled: true
      },
      creditsPosition: 'bottom-right',
      pathToImages: layoutPaths.images.amChart
    };
  
            
  }

  getDataFromServer(layoutColors){
   
      var constainersJson = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))["containersInCountries"];
      for(var i = 0; i<Object.keys(constainersJson).length; i++){
        var colour = layoutColors.primary;
        var group = constainersJson[i].groupId
      if(constainersJson[i].customData>1000){
          colour = layoutColors.primary;
          group = constainersJson[i].groupId
      }else if(constainersJson[i].customData>500){
          colour = layoutColors.successLight;  
          group = constainersJson[i].groupId   
      }else if(constainersJson[i].customData>200){
          colour = layoutColors.success;
          group = constainersJson[i].groupId
      }else{
          colour = layoutColors.danger;
          group = constainersJson[i].groupId
      }
          this.containers.push({ 'title': constainersJson[i].title, 'id': constainersJson[i].id, color:colour, customData: constainersJson[i].customData, groupId: group});
      
     }
        return this.containers;
    
      
  }
}

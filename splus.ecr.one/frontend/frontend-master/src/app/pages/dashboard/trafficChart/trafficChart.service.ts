import {Injectable} from '@angular/core';
import {BaThemeConfigProvider, colorHelper} from '../../../theme';

@Injectable()
export class TrafficChartService {

  containers:any[] = []; 
  colors:any[] = [];
  totalContainers:any;
  constructor(private _baConfig:BaThemeConfigProvider) {
  }


  getData() {
     return this.getContainersByPort();    
  }
  getContainersByRegion(){
     let dashboardColors = this._baConfig.get().colors.dashboard;
     var constainersJson = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))["containersInRegion"];
     console.log("Regionnnnnn : " + constainersJson)



     var constainersJson1 = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))["containersInPort"];
     console.log("Regionnnnnn : " + constainersJson1)
     var keys = Object.keys(constainersJson1);
     console.log("Keyssss" +Object.keys(constainersJson1));

     for(var i = 0; i<keys.length;i++){
      console.log(keys[i]);
      console.log(constainersJson1[keys[i]][0]);
      console.log(constainersJson1[keys[i]][1]);
      
        this.containers.push({
          value: constainersJson1[keys[i]][0],
          color: dashboardColors.white,
          highlight: colorHelper.shade(dashboardColors.white, 15),
          label: keys[i],
          percentage: constainersJson1[keys[i]][1],
          order: 1,
        });
     }
    return [
      {
        value: constainersJson["South America"],
        color: dashboardColors.white,
        highlight: colorHelper.shade(dashboardColors.white, 15),
        label: "South America",
        percentage: 87,
        order: 1,
      }, {
        value: constainersJson["Europe"],
        color: dashboardColors.gossip,
        highlight: colorHelper.shade(dashboardColors.gossip, 15),
        label: "Europe",
        percentage: 22,
        order: 4,
      }, {
        value: constainersJson["Africa"],
        color: dashboardColors.silverTree,
        highlight: colorHelper.shade(dashboardColors.silverTree, 15),
        label: "Africa",
        percentage: 70,
        order: 3,
      }, {
        value: constainersJson["Antarctica"],
        color: dashboardColors.surfieGreen,
        highlight: colorHelper.shade(dashboardColors.surfieGreen, 15),
        label: "Antarctica",
        percentage: 38,
        order: 2,
      }, {
        value: constainersJson["Australia"],
        color: dashboardColors.blueStone,
        highlight: colorHelper.shade(dashboardColors.blueStone, 15),
        label: "Australia",
        percentage: 17,
        order: 0,
      },
      {
        value: constainersJson["ASIA"],
        color: dashboardColors.blueStone,
        highlight: colorHelper.shade(dashboardColors.blueStone, 15),
        label: "Asia",
        percentage: 17,
        order: 5,
      },
      {
        value: constainersJson["North America"],
        color: dashboardColors.white,
        highlight: colorHelper.shade(dashboardColors.white, 15),
        label: "North America",
        percentage: 87,
        order: 6,
      },
    ];



  }

  getContainersByPort(){
    
    
     let dashboardColors = this._baConfig.get().colors.dashboard;
     this.colors.push(dashboardColors.white);
     this.colors.push(dashboardColors.gossip);
     this.colors.push(dashboardColors.blueStone);
     this.colors.push(dashboardColors.surfieGreen);
     this.colors.push(dashboardColors.silverTree);

     var constainersJson = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))["containersInPort"];
     console.log("Regionnnnnn : " + constainersJson)
     var keys = Object.keys(constainersJson);
     var colorSize = Object.keys(this.colors).length;
     console.log("Keyssss" +Object.keys(this.colors));
     var colorCount = 0;
     //this.totalContainers = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))["totalContainers"]["totalContainers"];
     console.log("totalContainersddd " +JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))["totalContainers"]["totalContainers"]);
     for(var i = 0; i<keys.length;i++){

      console.log(keys[i]);
      console.log(constainersJson[keys[i]][0]);
      console.log(constainersJson[keys[i]][1]);
       console.log(this.colors[colorCount]);
        this.containers.push({
          value: constainersJson[keys[i]][0],
          color: this.colors[colorCount],
          highlight: colorHelper.shade(this.colors[colorCount], 15),
          label: keys[i],
          percentage: constainersJson[keys[i]][1],
          order: 1,
        });
        if(i>0){
        if(i%colorSize-1==0){
          colorCount = 0;
        }else{
          colorCount = colorCount+1;
        }
      }
     }
   return this.containers;
  }

  getTotalContainersCount(){
      this.totalContainers = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))["totalContainers"]["totalContainers"];
      return this.totalContainers;
  }
}

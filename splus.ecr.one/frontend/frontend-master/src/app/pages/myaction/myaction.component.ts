import { Component } from '@angular/core';
import { MyActionService } from './myaction.service';
import { LocalDataSource } from 'ng2-smart-table';

@Component({
  selector: 'myaction-table',
  templateUrl: './myaction.html',
  styleUrls: ['./myaction.scss']
})
export class MyAction {
  
  lButton: string = '';
  bButton: string = '';

  query: string = '';
  
  
  settings = {
  selectMode: 'multi',
 actions:{
      position : 'right',
      add:false,
      edit:false,
      delete:false,
      editable:false   
    },  
    columns: {
       id: {
        title: 'Sr.No',
        filter: false,
        type: 'number'
      },
      
       Date: {
        title: 'Date',
           filter: false,
        type: 'string'
      },
      OriginPort: {
        title: 'Origin Port',
          filter: false,
        type: 'string'
      },
      DestinationPort: {
        title: 'Destination Port',
          filter: false,
        type: 'string'
      },
      ETA: {
        title: 'ETA',
          filter: false,
        type: 'string'
      },
      containerNo: {
        title: 'Container No.',
          filter: false,
        type: 'number'
      },
      
      Size : {
        title: 'Size/Type',
          filter: false,
        type: 'number'
      }
    }
  };

  
  source: LocalDataSource = new LocalDataSource();

 constructor(protected service: MyActionService) {
   
    this.bButton = 'hide-class';
    this.lButton = 'show-class';
 
    this.service.getData().subscribe(
           data => {
//                console.log("Data saved..!");
          });
      
  }

   lenderButton(){
    window.alert("lender click...");
     this.bButton = 'hide-class';
     this.lButton = 'show-class';
  }
  
  borrowerButton(){
  window.alert("borrower click...");
   this.lButton = 'hide-class';
   this.bButton = 'show-class';
   // : 'hide-class';
  }
}

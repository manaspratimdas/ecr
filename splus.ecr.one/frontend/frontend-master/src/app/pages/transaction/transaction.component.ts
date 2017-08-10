import { Component,ElementRef } from '@angular/core';

import { TransactionService } from './transaction.service';
import { LocalDataSource } from 'ng2-smart-table';

@Component({
  selector: 'transaction-table',
  templateUrl: './transaction.html',
  styleUrls: ['./transaction.scss']
})
export class Transaction {

  query: string = '';

  settings = {
//  selectMode: 'multi',
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
      
       pickUpDate: {
        title: 'Date',
           filter: false,
        type: 'string'
      },
      portSource: {
        title: 'Origin Port',
          filter: false,
        type: 'string'
      },
      portDestination: {
        title: 'Destination Port',
          filter: false,
        type: 'string'
      },
      ETA: {
          title: 'ETA',
          filter: false,
        type: 'string'
      },
      containerCode: {
        title: 'Container No.',
          filter: false,
          type: 'string'
      },
      
      sizeType : {
        title: 'Size/Type',
          filter: false,
        type: 'number'
      }
    }
  };

  source: LocalDataSource = new LocalDataSource();
  lButton: string = '';
  bButton: string = '';
  visible: boolean;
  companyId: string = '';
  constructor(protected service: TransactionService) {
   
    var sessionData = sessionStorage.getItem("http://localhost:8080/ecr/user/login");
    console.log("sessionData" + sessionData);
    
    this.companyId = JSON.parse(sessionData)['companyId'];
    console.log("companyId : "+this.companyId);
    this.lButton = 'show-class';
    this.bButton = 'hide-class';

      this.service.getData(this.companyId).subscribe(
             data => {
               console.log("Data saved..!");
              this.source.load(data);
            });
  }

  lenderButton(){
    //window.alert("lender click...");
    
    this.service.getLenderData(this.companyId).subscribe(
           data => {
           this.source.load(data);
          });

     this.bButton = 'hide-class';
     this.lButton = 'show-class';
  }
  
  borrowerButton(){
  //window.alert("borrower click...");
    
  this.service.getBorrowerData(this.companyId).subscribe(
           data => {
             console.log(JSON.stringify(data));
           this.source.load(data);
          });
  
  this.lButton = 'hide-class';
  this.bButton = 'show-class';
   // : 'hide-class';
  }
  
}

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
  lButton: string = '';
  bButton: string = '';
  visible: boolean;
  constructor(protected service: TransactionService) {
   // this.lButton = 'show-class';
   // this.visible = true;
    
    //this.lButton.nativeElement.focus();
    this.lButton = 'show-class';
    this.bButton = 'hide-class';
    this.service.getData().subscribe(
           data => {
//                console.log("Data saved..!");
          });
    // this.service.getData().then((data) => {
    //   this.source.load(data);
    // });
  }

  lenderButton(){
   // window.alert("lender click...");
     this.bButton = 'hide-class';
     this.lButton = 'show-class';
  }
  
  borrowerButton(){
 // window.alert("borrower click...");
   this.lButton = 'hide-class';
   this.bButton = 'show-class';
   // : 'hide-class';
  }
  
}

import { Component } from '@angular/core';
import { MyActionService } from './myaction.service';
import { LocalDataSource } from 'ng2-smart-table';

@Component({
  selector: 'myaction-table',
  templateUrl: './myaction.html',
  styleUrls: ['./myaction.scss']
})
export class MyAction {
  
  id: any;
 selectedRows = [];
 unselectedRows = [];
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
      
       pickUpDate: {
        title: 'Date',
        filter: false,
        type: 'Date'
      },
      portSource: {
        title: 'Origin Port',
          filter: false,
        type: 'string'
      },
      portDestination: {
        title: 'Destination Port',
          filter: false,
        type: 'string',
        
      },
      ETA: {
        title: 'ETA',
          filter: false,
        type: 'string'
      },
      containerCode: {
        title: 'Container No.',
          filter: false,
        type: 'number'
      },
      
      sizeType : {
        title: 'Size/Type',
          filter: false,
        type: 'string'
      },
      companyName : {
        title: 'Lender/Borrower',
        filter: false,
        type: 'string'
      }
    }
  };

  
  source: LocalDataSource = new LocalDataSource();

 constructor(protected service: MyActionService) {
   
    this.bButton = 'hide-class';
    this.lButton = 'show-class';
 
    this.service.getDataforLender().subscribe(
             data => {
             this.source.load(data);
          },
          error => {
          });
  }

  onRowSelect(event): void {
    //this.code = event.data['code'];
    this.id = event.data['id'];
    console.log("selected index :" + this.id);
    if(this.selectedRows.includes(this.id)){
      this.selectedRows = this.selectedRows.splice(this.id);
    }else{
      this.selectedRows.push(this.id);
    }
    
    
    
    console.log("on select : "+this.selectedRows);
  
  }
  
  
   lenderButton(){
   // window.alert("lender click...");
     this.bButton = 'hide-class';
     this.lButton = 'show-class';
      
     this.service.getDataforLender().subscribe(
             data => {
             this.source.load(data);
          },
          error => {
          });
  }
  
  borrowerButton(){
  //window.alert("borrower click...");
   this.lButton = 'hide-class';
   this.bButton = 'show-class';
   
   this.service.getDataforBorrower().subscribe(
             data => {
             this.source.load(data);
          },
          error => {
          });
  }

  onRelease(){
  //window.alert("click on release click"+this.selectedRows);
  this.service.onRelease(this.selectedRows).subscribe(
  data => {
  }
  );
  }
  
  onConfirm() {
    
    //window.alert("array : "+this.selectedRows);
     this.service.onConfirm(this.selectedRows).subscribe(
     
     data => {
     });
  }
  
  onReject() {
    
   // window.alert("array : "+this.selectedRows);
     this.service.onReject(this.selectedRows).subscribe(
     
     data => {
     });
  }
}

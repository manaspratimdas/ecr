import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { InventoryService } from './inventory.service';
import { Http ,RequestOptions, Response, Headers } from '@angular/http';
import { LocalDataSource } from 'ng2-smart-table';
import { Observable } from 'rxjs';

@Component({
  selector: 'smart-table',
  templateUrl: './inventory.html',
  styleUrls: ['./inventory.scss']
})
export class Inventory {

  query: string = '';
  dee: string;
  settings = {
    add: {
      addButtonContent: '<i class="ion-ios-plus-outline"></i>',
      createButtonContent: '<i class="ion-checkmark"></i>',
      cancelButtonContent: '<i class="ion-close"></i>',
      confirmCreate: true
    },
    edit: {
      editButtonContent: '<i class="ion-edit"></i>',
      saveButtonContent: '<i class="ion-checkmark"></i>',
      cancelButtonContent: '<i class="ion-close"></i>',
      confirmSave: true,
    },
    delete: {
      deleteButtonContent: '<i class="ion-trash-a"></i>',
      confirmDelete: true
    },
    columns: {
      id: {
        title: 'Container No.',
        type: 'number'
      },
      containerType: {
        title: 'Size/Type',
        type: 'string',
         valuePrepareFunction: (containerType) => {
                         return containerType.size+" "+containerType.type;
                     }
      },
      status: {
        title: 'Status  ',
        type: 'string'
      },
      containerType1: {
        title: 'Condition',
        type: 'string',
          valuePrepareFunction: (containerType) => {
                          return containerType.description;
                      }
      },
      port: {
        title: 'Port',
        type: 'string',
         valuePrepareFunction: (port) => {
                          return port.id;
                      }
      },
      depot: {
        title: 'Depot',
        type: 'string'
       }
      // c_dept: {
      //   title: 'Depot',
      //   type: 'string'
      // },
      // c_date: {
      //   title: 'Date',
      //   type: 'string'
      // },
      // c_time: {
      //   title: 'Time',
      //   type: 'string'
      // }
    }
  };

  source: LocalDataSource = new LocalDataSource();

  constructor(protected service: InventoryService,private router: Router,private http: Http) {
    
       this.service.getData()
      .subscribe(
          data => {
             this.source.load(data);
          },
          error => {
          });
  }
  
  onCreateConfirm(event): void {
  if (window.confirm('Are you sure you want to add new record?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }
  
  onSaveConfirm(event): void {
  if (window.confirm('Are you sure you want to edit record?')) {
     
    let myParams = new URLSearchParams(); 

     myParams.append("id",event.newData['id']);
     myParams.append("containerType",event.newData['containerType']);
     myParams.append("status",event.newData['status']);
     myParams.append("description",event.newData['description']);
     myParams.append("port",event.newData['port']);
     myParams.append("depot",event.newData['depot']);
    
     this.service.update(myParams)
      .subscribe(
          data => {
             console.log(data);
       //      this.router.navigate(['/inventory']);
            if(data != null){
               this.source.load(data);
              event.confirm.resolve();
            }
          },
          error => {
          });
    } else {
      event.confirm.reject();
    }  
  }
  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }
}

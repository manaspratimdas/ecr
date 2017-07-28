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
        title: 'Sr. No.',
        type: 'number'
      
      },
      code: {
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
      containerCondition: {
        title: 'Condition',
        type: 'string'
      },
      port: {
        title: 'Port',
        type: 'string',
         valuePrepareFunction: (port) => {
                          return port.isoPortCode;
                      }
      },
      depot: {
        title: 'Depot',
        type: 'string'
       }
      // c_dept: {
      //   title: 'Depot',
      //   type: 'string'
      // }
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

     var jsonData = JSON.stringify({ "id":event.newData['id'],"code":event.newData['code'],"containerType":event.newData['containerType'],"status":event.newData['status'],
     "containerCondition":event.newData['containerCondition'],"port":event.newData['port']});

     var json1 = JSON.stringify(jsonData);
     var jsonW = JSON.parse(json1);
     
     this.service.update(jsonW)
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
     console.log("in delete call : "+event.data['id']);
      var jsonData = JSON.stringify({ "id":event.data['id'],"code":event.data['code'],"containerType":event.data['containerType'],"status":event.data['status'],
     "containerCondition":event.data['containerCondition'],"port":event.data['port']});
    
     console.log("requested data : "+jsonData);
     var json1 = JSON.stringify(jsonData);
     var jsonW = JSON.parse(json1);

     this.service.delete(jsonW)
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
}

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
      c_srno: {
        title: 'Sr No.',
        type: 'number'
      },
      c_contno: {
        title: 'Cont No.',
        type: 'string'
      },
      c_size: {
        title: 'Size',
        type: 'string'
      },
      c_status: {
        title: 'Status',
        type: 'string'
      },
      c_condition: {
        title: 'Condition',
        type: 'string'
      },
      c_port: {
        title: 'Port',
        type: 'string'
      },
      c_dept: {
        title: 'Depot',
        type: 'string'
      },
      c_date: {
        title: 'Date',
        type: 'string'
      },
      c_time: {
        title: 'Time',
        type: 'string'
      }
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
    
    this.service.test(event)
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

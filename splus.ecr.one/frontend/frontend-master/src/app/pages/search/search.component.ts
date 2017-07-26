import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

import { SearchService } from './search.service';
import { LocalDataSource, ViewCell } from 'ng2-smart-table';
import { Http ,RequestOptions, Response, Headers } from '@angular/http';

@Component({
  selector: 'search-table',
  templateUrl: './search.html',
  styleUrls: ['./search.scss']
})
  
export class Search {

  types: any[]=[
                {id:1,name:'10'},
                {id:2,name:'20'}
    ];
  
  countries: any[]=[
                {id:1,name:'india'},
                {id:2,name:'china'}
    ];
  
  ports: any[]=[
                {id:1,name:'port1'},
                {id:2,name:'port2'}
    ];
  
  companies: any[]=[
                {id:1,name:'shipco'},
                {id:2,name:'scan-shipping'}
    ];
  
  query: string = '';
  selectedRows: number[]=[];
  
  selectedType: string ;
  selectedCountry: string;
  selectedPort: string;
  selectedCompany: string;
  
  settings = {
    selectMode: 'multi',
    actions: false,
    columns: {
//      id: {
//        title: 'Select',
//        type: 'custom',
//        renderComponent: CheckboxViewComponent
//      },
      id: {
        title: 'ID',
        filer: false,
        type: 'number'
      },
      firstName: {
        title: 'First Name',
        filer: false,
        type: 'string'
      },
      lastName: {
        title: 'Last Name',
        filer: false,
        type: 'string'
      },
      username: {
        title: 'Username',
        filer: false,
        type: 'string'
      },
      email: {
        title: 'E-mail',
        filer: false,
        type: 'string'
      },
      age: {
        title: 'Age',
        filer: false,
        type: 'number'
      }
    }
  };

settings1 = {
   
    actions: false,
    columns: {
//      id: {
//        title: 'Select',
//        type: 'custom',
//        renderComponent: CheckboxViewComponent
//      },//Company Name	
      id: {
        title: 'sr.no',
        filer: false,
        type: 'number'
      },
      condition: {
        title: 'condition',
        filer: false,
        type: 'string'
      },
      contno: {
        title: 'Container No.',
        filer: false,
        type: 'string'
      },
      containerType :{
        title: 'Size/Type',
        filer: false,
        valuePrepareFunction: (containerType) => {
                         return containerType.Size+containerType.type;
                     }
      },
      port: {
        title: 'Port',
        filer: false,
        valuePrepareFunction: (port) => {
                         return port.isoPortCode;
                     }
      },
      company: {
        title: 'Depot',
        filer: false,
        valuePrepareFunction: (company) => {
                         return company.name;
                     }
      },
     delete: {
      deleteButtonContent: '<i class="ion-trash-a"></i>',
      confirmDelete: true
    },
    test: {
                          title: 'fire',
                          type: 'html'
    }                
    }
  };

  source: LocalDataSource = new LocalDataSource();
  source1: LocalDataSource = new LocalDataSource();
//  constructor(protected service: SearchService) {
//    this.service.getData().then((data) => {
//      this.source.load(data);
//    });
//  }
  
  constructor(protected service: SearchService,private http: Http) {
//    this.source.setFilter([],false);
    this.service.getData()
      .then(
          data => {
             this.source.load(data);
          },
          error => {
          });
  }
        onSearch(){
          window.alert("search clicked..!"+ this.selectedType+","+ this.selectedCountry+","+ this.selectedPort+","+ this.selectedCompany);
        }
            
    onSubmit(){

      window.alert("book click.."+this.selectedRows);
       this.service.test(this.selectedRows).subscribe(
          data => {
           this.source1.load(data);
          });
    }
  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }
  
  onRowSelect(event): void {
    debugger;
    
    let id = event.data['id'];
    var index = this.selectedRows.indexOf(id);
    console.log("selected index :" + index);
    if(index != -1) {
      this.selectedRows.splice(index, id);
    } else {
      this.selectedRows.push(id);
    }
    console.log(this.selectedRows);
    
  }
  
  onTypeChange(event:Event): void {
    this.selectedType = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedType);
  }
  
  onCountryChange(event:Event): void {
    this.selectedCountry = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedCountry);
  }
  
  onPortChange(event:Event): void {
    this.selectedPort = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedPort);
  }
  
  onCompanyChange(event:Event): void {
    this.selectedCompany = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedCompany);
  }
  
}


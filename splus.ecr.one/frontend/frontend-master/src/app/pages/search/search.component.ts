import { Component,ChangeDetectorRef,OnInit, Input, EventEmitter, Output } from '@angular/core';

import { SearchService } from './search.service';
import { LocalDataSource, ViewCell } from 'ng2-smart-table';
import { Http ,RequestOptions, Response, Headers } from '@angular/http';
import 'rxjs/Rx';

@Component({
  selector: 'search-table',
  templateUrl: './search.html',
  styleUrls: ['./search.scss']
})
  
export class Search {

  private types = [];
  private countries = [];
  private ports = [];
  private companies = [];

  query: string = '';
  code: string = '';
  selectedRows: number[]=[];
  
  selectedType: string ;
  selectedCountry: string;
  selectedPort: string;
  selectedCompany: string;
  
  settings = {
    selectMode: 'multi',
    actions: false,
    columns: {

      company: {
        title: 'Company Name',
        filer: false,
        type: 'string',
         valuePrepareFunction: (company) => {
                         return company.name;
                     }
      },
      code: {
        title: 'Container No.',
        filer: false,
        type: 'string'
      },
      containerType: {
        title: 'Size/Type',
        filer: false,
        type: 'string',
          valuePrepareFunction: (containerType) => {
                         return containerType.size+" "+containerType.type;
                     }
      },
      containerCondition: {
        title: 'Condition',
        filer: false,
        type: 'string'
      },
      port: {
        title: 'Port',
        filer: false,
        type: 'string',
         valuePrepareFunction: (port) => {
                         return port.isoPortCode;
                     }
      },
      depot: {
        title: 'Depot',
        filer: false,
        type: 'number'
      }
    }
  };

settings1 = {
  
    delete: {
      deleteButtonContent: '<i class="ion-trash-a"></i>',
      confirmDelete: true
    },
    actions:{
      position : 'right',
      add:false,
      edit:false,
      delete:true,
      editable:false
    }, 
//    actions: false,
    columns: {

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

  constructor(protected service: SearchService,private http: Http,cd: ChangeDetectorRef) {
  //code for data which we want show in search suggession list 
    http.get('http://localhost:8080/ecr/containers')
        .flatMap((data) => data.json())
        .map((value) => value['containerType'].size + " " + value['containerType'].type)
        .subscribe((data) => {
          this.types.push(data);
          
          cd.detectChanges();
        });
        
         http.get('http://localhost:8080/ecr/containers')
        .flatMap((data) => data.json())
        .map((value) => value['port'].country.isoLocalName)
        .subscribe((data) => {
          this.countries.push(data);
          
          cd.detectChanges();
        });
        
         http.get('http://localhost:8080/ecr/containers')
        .flatMap((data) => data.json())
        .map((value) => value['port'].isoPortCode)
        .subscribe((data) => {
          this.ports.push(data);
          
          cd.detectChanges();
        });
        
        http.get('http://localhost:8080/ecr/containers')
        .flatMap((data) => data.json())
        .map((value) => value['company'].name)
        .subscribe((data) => {
          this.companies.push(data);
          
          cd.detectChanges();
        });
      }
      onSearch() {
          window.alert("search clicked..!"+ this.selectedType+","+ this.selectedCountry+","+ this.selectedPort+","+ this.selectedCompany);
           this.service.getData(this.selectedType,this.selectedCountry,this.selectedPort,this.selectedCompany).subscribe(
           data => {
           this.source.load(data);
          });
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
    this.code = event.data['code'];
    
  //  var index = this.selectedRows.values;
    console.log("selected index :" + this.code);
    // if(index != -1) {
    //   this.selectedRows.splice(index, id);
    // } else {
    //   this.selectedRows.push(id);
    // }
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


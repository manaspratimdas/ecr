import { Component,ChangeDetectorRef,OnInit, Input, EventEmitter, Output,Injectable } from '@angular/core';
import { FormGroup, AbstractControl,FormControl, FormBuilder, Validators } from '@angular/forms';

import { SearchService } from './search.service';
import { LocalDataSource, ViewCell } from 'ng2-smart-table';
import { Http ,RequestOptions, Response, Headers } from '@angular/http';
import 'rxjs/Rx';


@Injectable()
@Component({
  selector: 'search-table',
  templateUrl: './search.html',
  styleUrls: ['./search.scss'],
  
})


  
export class Search {

  selectedRequisitionNo: string;
  selectedRequestedQuantity: string;
  selectedPickupDate: string;
selectedSource: string;
  selectedDestination: string ;
  selectedNote: string ;
  private types = [];
  private countries = [];
  private ports = [];
  private companies = [];

  str: string;  
  RowIndex: number = 0;
  TotalRows: number = 0;
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
        filter: false,
        type: 'number'
      },
      condition: {
        title: 'condition',
        filter: false,
        type: 'string'
      },
      contno: {
        title: 'Container No.',
        filter: false,
        type: 'string'
      },
      containerType :{
        title: 'Size/Type',
        filter: false,
        valuePrepareFunction: (containerType) => {
                         return containerType.Size+containerType.type;
                     }
      },
      port: {
        title: 'Port',
        filter: false,
        valuePrepareFunction: (port) => {
                         return port.isoPortCode;
                     }
      },
      company: {
        title: 'Depot',
        filter: false,
        valuePrepareFunction: (company) => {
                         return company.name;
                     }
       }//,
    //  delete: {
    //   deleteButtonContent: '<i class="ion-trash-a"></i>',
    //   confirmDelete: true
    // }               
    }
  };

  source: LocalDataSource = new LocalDataSource();
  source1: LocalDataSource = new LocalDataSource();
  form:FormGroup;
  isSubmitting: boolean = false;
  testt:string;
  
  
 
  constructor(private fb:FormBuilder,protected service: SearchService,private http: Http,cd: ChangeDetectorRef) {
    this.testt = 'Heraj1';
    console.log(this.testt);
   
    
    
    
    http.get('http://localhost:8080/ecr/containers')
        .flatMap((data) => data.json())
        .subscribe((data) => {
          this.types.push(data);
          cd.detectChanges();
        });
        
         http.get('http://localhost:8080/ecr/containers')
        .flatMap((data) => data.json())
        .subscribe((data) => {
          this.countries.push(data);
          cd.detectChanges();
        });
        
         http.get('http://localhost:8080/ecr/containers')
        .flatMap((data) => data.json())
        .subscribe((data) => {
          this.ports.push(data);
          cd.detectChanges();
        });
        
        http.get('http://localhost:8080/ecr/containers')
        .flatMap((data) => data.json())
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
        name: string;
        onConfirm(){
          this.name = "";
         // window.alert("in booking screen.."+this.bookForm.value);    
        }
            
    onSubmit(){
  
console.log("submiiiiiitttt   " + this.selectedRequisitionNo)
console.log("submiiiiiitttt   " + this.selectedRequestedQuantity)
console.log("submiiiiiitttt   " + this.selectedNote)
console.log("submiiiiiitttt   " + this.selectedDestination)
console.log("submiiiiiitttt   " + this.selectedSource)
console.log("submiiiiiitttt   " + this.selectedPickupDate)
      window.alert("book click.."+this.selectedRows);
    //   
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
    //debugger;
    
    this.code = event.data['code'];
    console.log("selected index :" + this.code);

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


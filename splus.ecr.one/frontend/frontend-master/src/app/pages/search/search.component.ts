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

  srcPorts: string[] = [];
  addedPorts: string[] = [];
  bookingContent:boolean = false;
  requisitionNumber:string = "";
  requestQuantity:String = "0";
  msg:boolean = false;
  userName: string;
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
  private sourcePorts  = [];


  bookedData: any;
  dataTransfer: any;
  companyId: string;
  id: string;
  str: string;  
  RowIndex: number = 0;
  TotalRows: number = 0;
  query: string = '';
  code: string = '';
  selectedRows = [];
  
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
      }
      //               ,
      // depot: {
      //   title: 'Depot',
      //   filer: false,
      //   type: 'number'
      // }
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
     company: {
        title: 'Company Name',
        filter: false,
         valuePrepareFunction: (company) => {
                         return company.name;
                     }
                        
      },
      code: {
        title: 'Container No.',
        filter: false,
        type: 'string'
      },
      containerType :{
        title: 'Size/Type',
        filter: false,
        valuePrepareFunction: (containerType) => {
                         return containerType.size+containerType.type;
                     }
      },
      containerCondition: {
        title: 'Condition',
        filter: false,
        type: 'string'
      },
      port: {
        title: 'Port',
        filter: false,
        valuePrepareFunction: (port) => {
                         return port.isoPortCode;
                     }
      },
      lastUpdateDate: {
        
        title: 'Last Update Date',
        filter: false,
        valuePrepareFunction: (lastUpdateDate) => { 
       
        var userDate = new Date(lastUpdateDate);
        
        var day = userDate.getDate();
        var month = userDate.getMonth() + 1;
        var year = userDate.getFullYear();
        var hr = userDate.getHours();
        var min = userDate.getMinutes();
        var sec = userDate.getSeconds();
    
        return year+"-"+month + "-" + day+" "+hr+":"+min+":"+sec;
      }   
     }                  
    }
  };

  source: LocalDataSource = new LocalDataSource();
  source1: LocalDataSource = new LocalDataSource();
  form:FormGroup;
  isSubmitting: boolean = false;
  testt:string;
  
  
 
  constructor(private fb:FormBuilder,protected service: SearchService, private http: Http,cd: ChangeDetectorRef) {
    this.testt = 'Heraj1';
    console.log(this.testt);
    
   
    http.get("http://localhost:8080/ecr/containertypes")
        .flatMap((data) => data.json())
        .subscribe((data) => {
          this.types.push(data);
          cd.detectChanges();
        });
        
         http.get("http://localhost:8080/ecr/countries")
        .flatMap((data) => data.json())
        .subscribe((data) => {
          this.countries.push(data);
          cd.detectChanges();
        });
        
         http.get("http://localhost:8080/ecr/ports")
        .flatMap((data) => data.json())
        .subscribe((data) => {
          this.ports.push(data);
          cd.detectChanges();
        });
        
        http.get("http://localhost:8080/ecr/companies")
        .flatMap((data) => data.json())
        .subscribe((data) => {
          this.companies.push(data);
          cd.detectChanges();
        });
      }
      onSearch() {
         // window.alert("search clicked..!"+ this.selectedType+","+ this.selectedCountry+","+ this.selectedPort+","+ this.selectedCompany);
           this.service.getData(this.selectedType,this.selectedCountry,this.selectedPort,this.selectedCompany).subscribe(
           data => {
           this.source.load(data);
          });
         
        }
     
        onConfirm(event:Event): void{
          
            console.log("selectedRequisitionNo     : " + this.selectedRequisitionNo)
            console.log("selectedRequestedQuantity : " + this.selectedRequestedQuantity)
            console.log("selectedNote              : " + this.selectedNote)
            console.log("selectedDestination       : " + this.selectedDestination)
            console.log("selectedSource            : " + this.selectedSource)
            console.log("selectedPickupDate        : " + this.selectedPickupDate)
            console.log("Booked json : "+this.bookedData);    
          
           var sessionData = sessionStorage.getItem("http://localhost:8080/ecr/user/login");
           console.log("sessionData" + sessionData);
    
          this.companyId = JSON.parse(sessionData)['companyId'];

          var borrower = JSON.stringify({ "id":this.companyId,"name":"this.userName"});
          var jsona = JSON.parse(borrower);
          console.log(borrower);
          console.log(jsona);
          var destinationPort = JSON.stringify({ "id":this.companyId,"isoPortName":"this.userName"});
          var jsonb = JSON.parse(destinationPort);
          console.log(destinationPort);
          console.log(jsonb);
          console.log("issueResolve---->"+this.selectedPickupDate);
          var jsonData = JSON.stringify({ "id":null,"requestDate":this.selectedPickupDate,
        "releaseDate":this.selectedPickupDate,"containers":this.bookedData,"borrower":jsona,"destinationPort":jsonb});
          console.log("object : "+jsonData);
          
          var json1 = JSON.stringify(jsonData);
          var jsonW = JSON.parse(json1);

          this.service.saveToCart(jsonW).subscribe(
           data => {
                console.log("Data saved..!");
          });

           this.msg = true
           setTimeout(function() {
          
           this.msg = false;
           }.bind(this), 2000); 
          
        }
            
    onSubmit(){
       
      this.bookingContent = true;
     // window.alert("book click.."+this.selectedRows); 
       this.service.test(this.selectedRows).subscribe(
          data => {
           this.source1.load(data);
           this.bookedData = data;
           for (var i = 0,j=0; i< Object.keys(this.bookedData).length; i++,j++) {
            // if(!this.hasId(this.srcPorts, JSON.parse(JSON.stringify(this.bookedData[i])).port.id)){
                 this.srcPorts[i] = JSON.parse(JSON.stringify(this.bookedData[i])).port;
               //  this.data2Cart[i] = JSON.parse(JSON.stringify(this.bookedData[i]));
            // }
                 

            }

           console.log( JSON.stringify(this.bookedData));
            sessionStorage.setItem("add2Cart",JSON.stringify(this.bookedData));
           this.sourcePorts.push(this.srcPorts);
           this.requisitionNumber = (String)(new Date().getMilliseconds());
           console.log("booked size" + Object.keys(this.bookedData).length);
           this.requestQuantity = (String)(Object.keys(this.bookedData).length);
           window.location.href = "http://localhost:4200/#/pages/cart";
          });
    }

   hasId(data, id) {
     
     
  return (JSON.parse(JSON.stringify(data))).some(function (el) {
    return true;
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
    this.id = event.data['id'];
    console.log("selected index :" + this.id);
    this.selectedRows.push(this.id);
    console.log("on select : "+this.selectedRows);
    
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


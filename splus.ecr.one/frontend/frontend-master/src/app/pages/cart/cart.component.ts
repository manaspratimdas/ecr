import { Component,ChangeDetectorRef,OnInit, Input, EventEmitter, Output,Injectable } from '@angular/core';
import { FormGroup, AbstractControl,FormControl, FormBuilder, Validators } from '@angular/forms';

import { SearchService } from '../search/search.service';
import { LocalDataSource, ViewCell } from 'ng2-smart-table';
import { Http ,RequestOptions, Response, Headers } from '@angular/http';
import 'rxjs/Rx';

@Component({
  selector: 'cart',
  templateUrl: './cart.html',
  styleUrls: ['./cart.scss'],
  providers: [SearchService]
})
export class Cart {
 srcPorts: string[] = [];
 destPorts:any[] = [];
 requisitionNumber:string;
 requestQuantity : string;
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

    columns: {

      id: {
        title: 'Sr.No',
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
      }
                     ,
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

  
  source1: LocalDataSource = new LocalDataSource();
  form:FormGroup;
  
  @Output()
  change = new EventEmitter();
  
  constructor(private fb:FormBuilder,protected service: SearchService,private http: Http,cd: ChangeDetectorRef) {
  http.get("http://localhost:8080/ecr/ports")
        .flatMap((data) => data.json())
        .subscribe((data) => {
          this.destPorts.push(data);
          cd.detectChanges();
        });
    this.requisitionNumber = (String)(new Date().getMilliseconds());
    console.log("in cart..");
      
  }

  ngOnInit(){
    let data = null;
     
if(sessionStorage.getItem("add2Cart")!= null){
        data = JSON.parse(sessionStorage.getItem("add2Cart"));
     }else{
        data = JSON.parse("[]");
     }

    this.requestQuantity = (String)(Object.keys(data).length);
    this.source1.load(data);

		for (var i = 0,j=0; i< Object.keys(data).length; i++,j++) {
      this.srcPorts[i] = JSON.parse(JSON.stringify(data[i])).port;
    }
  }

 onConfirm(event:Event): void {
    sessionStorage.removeItem("add2Cart");
    window.alert("book click..!");
   }
}
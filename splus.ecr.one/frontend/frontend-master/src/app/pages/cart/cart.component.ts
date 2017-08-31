import { Component,ChangeDetectorRef,OnInit, Input, EventEmitter, Output,Injectable } from '@angular/core';
import { FormGroup, AbstractControl,FormControl, FormBuilder, Validators } from '@angular/forms';
import { Pipe, PipeTransform } from '@angular/core';
import * as _ from 'lodash'; 

import { SearchService } from '../search/search.service';
import { LocalDataSource, ViewCell } from 'ng2-smart-table';
import { Http ,RequestOptions, Response, Headers } from '@angular/http';
import 'rxjs/Rx';


@Pipe({
    name: 'uniqFilter',
    pure: false
})
@Injectable()
export class UniquePipe implements PipeTransform {
    transform(items: any[], args: any[]): any {
        return _.uniqBy(items, args);
    }
}
@Component({
  selector: 'cart, UniquePipe',
  templateUrl: './cart.html',
  styleUrls: ['./cart.scss'],
  providers: [SearchService]
})

export class Cart {

 srcPorts: string[] = [];
 destPorts:any[] = [];
 requisitionNumber:string;
 requestQuantity: string;
 pickupDate: string;
 source:string;
 distPort:string; 
 note:string;
 companyId:string;
 msg:boolean = false;
 today:any = new Date().toISOString().split('T')[0];;

ngAfterViewInit(){
    document.getElementById('pickupDate').setAttribute('min', this.today);
  }


 settings1 = {
   hideSubHeader: true,
    // delete: {
    //   deleteButtonContent: '<i class="ion-trash-a"></i>',
    //   confirmDelete: true
    // },
     actions:false,
    //   position : 'right',
    //   add:false,
    //   edit:false,
    //  // delete:true,
    //   editable:false   
    // }, 

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
  localData: any;
  requisitionNo:string;
  
  @Output()
  change = new EventEmitter();
  
  constructor(private fb:FormBuilder,protected service: SearchService,private http: Http,cd: ChangeDetectorRef) {
  http.get(sessionStorage.getItem("IP")+":8080/ecr/ports")
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
   //  console.log("requisitionNumber:: "+this.requisitionNumber);
    this.requestQuantity = (String)(Object.keys(data).length);
    this.source1.load(data);
    this.localData = data;

  for (var i = 0,j=0; i< Object.keys(data).length; i++,j++) {
    
      this.srcPorts[i] = JSON.parse(JSON.stringify(data[i])).port;
      
    }

    if(data != null && data != ''){
             (<HTMLInputElement> document.getElementById("myButton")).disabled = false;
            this.source1.load(data);
          } 
            else{
              (<HTMLInputElement> document.getElementById("myButton")).disabled = true;
            }
  }

  onConfirm(event:Event): void {
  //  this.requisitionNo = event['requisitionNumber'];
    //this.requisitionNo = (<HTMLSelectElement>event.srcElement).value; 
    // window.alert("requisitionNumber ---> "+this.requisitionNumber);
    // sessionStorage.removeItem("add2Cart");
    // window.alert("requested quantity ---> "+this.localData.length);

          var sessionData = sessionStorage.getItem("http://localhost:8080/ecr/user/login");
          console.log("sessionData" + sessionData);
    
          this.companyId = JSON.parse(sessionData)['companyId'];

          var borrower = JSON.stringify({ "id":this.companyId,"name":"this.userName"});
          var jsona = JSON.parse(borrower);
          
          console.log(borrower);
          console.log(jsona);
          
          var destinationPort = JSON.stringify({ "id":this.companyId,"isoPortName":"userName"});
          var jsonb = JSON.parse(destinationPort);
          
          var company = JSON.stringify({ "id":this.companyId,"isoPortName":"userName"});
          var jsonc = JSON.parse(company);
 
          var jsonData = JSON.stringify({ "id":"","company":jsonc,"status":"1","requestDate":this.pickupDate,
          "releaseDate":this.pickupDate,"destinationPort":jsonb,"containers":this.localData,"requisitionNo":this.requisitionNumber,
          "requestedQuantity":this.requestQuantity,"pickUpDate":this.pickupDate,"note":this.note,"portSource":this.source,
          "portDestination":this.distPort,"borrower":jsona});
          
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
          sessionStorage.removeItem("add2Cart")

          let data = null;
     

           data = JSON.parse("[]");
          
           this.localData = data;

          (< HTMLSelectElement>document.getElementById("pickupDate")).value = "mm/dd/yyyy";
        (< HTMLSelectElement>document.getElementById("note")).value = '';
           console.log("updated date : "+ this.pickupDate);
           
           this.requisitionNumber = "0";
           this.srcPorts = [];
           this.destPorts = [];
           this.note = null;
           this.requestQuantity = "0";
           this.source1.load(data);
            if(data != null && data != ''){
             (<HTMLInputElement> document.getElementById("myButton")).disabled = false;
            this.source1.load(data);
          } 
            else{
              (<HTMLInputElement> document.getElementById("myButton")).disabled = true;
            }
           
   }
  
   onPickupDateChange(event:Event): void{
    
    this.pickupDate = (<HTMLSelectElement>event.srcElement).value; 
  //  window.alert("pickup date ---> "+this.pickupDate);
   
   }

   onSourceChange(event:Event): void{
  
    this.source = (<HTMLSelectElement>event.srcElement).value;
    console.log("source ---> "+this.source);
 //   window.alert("source ---> "+this.source);
   }
  
   onDestChange(event:Event): void{
  
    this.distPort = (<HTMLSelectElement>event.srcElement).value; 
 //   window.alert("distPort ---> "+this.distPort);
   }

   onNoteChange(event:Event): void{
   
    this.note = (<HTMLSelectElement>event.srcElement).value; 
  //  window.alert("notes ---> "+this.note);
   }
}
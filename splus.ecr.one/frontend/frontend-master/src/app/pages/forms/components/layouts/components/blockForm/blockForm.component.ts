import {Component,Output, EventEmitter  } from '@angular/core';
import { Search } from '../../../../../search/search.component';



@Component({
  selector: 'block-form',
  templateUrl: './blockForm.html',
  providers: [Search],
  inputs:['parentValue']

  //directives: [Search]
})
export class BlockForm {
test : string;
searchfinal : Search;
data: any;
  constructor(search : Search) {
    this.test = "Heraj";
    this.searchfinal = search;
    this.data = search.dataTransfer;
    this.destinations = search.bookedData;
    console.log("data:"+this.data);
  }

  @Output() searchSelectedRequisitionNo: EventEmitter<string> = new EventEmitter<string>()
  @Output() searchSelectedRequestedQuantity: EventEmitter<string> = new EventEmitter<string>()
  @Output() searchSelectedPickupDate: EventEmitter<string> = new EventEmitter<string>()
  @Output() searchSelectedSource: EventEmitter<string> = new EventEmitter<string>()
  @Output() searchSelectedDestination: EventEmitter<string> = new EventEmitter<string>()
  @Output() searchSelectedNote: EventEmitter<string> = new EventEmitter<string>()

  //@Input('testt') incomingData: string;
  parentValue:string;
  //@Input('parentData') incomingData: string;
  
  selectedRequisitionNo: string;
  selectedRequestedQuantity: string;
  selectedPickupDate: string;
  selectedSource: string;
  selectedDestination: string ;
  selectedNote: string ;
  private sources = [];
  private destinations = [];
  
  
  onSubmission() {
   window.alert("submit clicked..!"+ this.selectedRequisitionNo +","+this.selectedRequestedQuantity +","+ this.selectedPickupDate +","+ this.selectedDestination +","+ this.selectedNote);
   console.log("tanya");
   }
   onRequisitionNoChange(event:Event): void {
     
    
    this.selectedRequisitionNo = (<HTMLSelectElement>event.srcElement).value; 
    
    console.log(this.selectedRequisitionNo);
    
    this.searchSelectedRequisitionNo.emit(this.selectedRequisitionNo);
    console.log(this.searchfinal.selectedRequisitionNo)
  }
  
  onRequestedQuantityChange(event:Event): void {
    this.selectedRequestedQuantity = (<HTMLSelectElement>event.srcElement).value; 
    this.searchSelectedRequestedQuantity.emit(this.selectedRequestedQuantity);
    console.log(this.selectedRequestedQuantity);
  }
  
  onPickupDateChange(event:Event): void {
    this.selectedPickupDate = (<HTMLSelectElement>event.srcElement).value; 
    this.searchSelectedPickupDate.emit(this.selectedPickupDate);
    console.log(this.selectedPickupDate);
  }
  
  onDestinationChange(event:Event): void {
    this.selectedDestination = (<HTMLSelectElement>event.srcElement).value; 
    this.searchSelectedDestination.emit(this.selectedDestination);
    console.log(this.selectedDestination);
  }
  
   onNoteChange(event:Event): void {
    this.selectedNote = (<HTMLSelectElement>event.srcElement).value;
    this.searchSelectedNote.emit(this.selectedNote);
    console.log(this.selectedNote);
  }
 onSourceChange(event:Event): void {
    this.selectedSource = (<HTMLSelectElement>event.srcElement).value; 
    this.searchSelectedSource.emit(this.selectedSource);
    console.log(this.selectedSource);
  }
}

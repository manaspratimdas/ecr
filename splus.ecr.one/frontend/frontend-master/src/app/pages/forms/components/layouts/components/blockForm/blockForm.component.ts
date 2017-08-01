import {Component} from '@angular/core';

@Component({
  selector: 'block-form',
  templateUrl: './blockForm.html',
})
export class BlockForm {

  constructor() {
  }
  
  selectedRequisitionNo: string;
  selectedRequestedQuantity: string;
  selectedPickupDate: string;
selectedSource: string;
  selectedDestination: string ;
  selectedNote: string ;
  
  
  onSubmission() {
   window.alert("submit clicked..!"+ this.selectedRequisitionNo +","+this.selectedRequestedQuantity +","+ this.selectedPickupDate +","+ this.selectedDestination +","+ this.selectedNote);
   console.log("tanya");
   }
   onRequisitionNoChange(event:Event): void {
    this.selectedRequisitionNo = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedRequisitionNo);
  }
  
  onRequestedQuantityChange(event:Event): void {
    this.selectedRequestedQuantity = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedRequestedQuantity);
  }
  
  onPickupDateChange(event:Event): void {
    this.selectedPickupDate = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedPickupDate);
  }
  
  onDestinationChange(event:Event): void {
    this.selectedDestination = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedDestination);
  }
  
   onNoteChange(event:Event): void {
    this.selectedNote = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedNote);
  }
 onSourceChange(event:Event): void {
    this.selectedSource = (<HTMLSelectElement>event.srcElement).value; 
    console.log(this.selectedSource);
  }
}

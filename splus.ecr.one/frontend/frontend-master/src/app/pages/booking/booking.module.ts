import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule as AngularFormsModule } from '@angular/forms';
import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';
import { NgbRatingModule } from '@ng-bootstrap/ng-bootstrap';

import { routing }       from './booking.routing';

import { Booking } from './booking.component';
import { Layouts } from '../../pages/forms/components/layouts';



import { BlockForm } from '../../pages/forms/components/layouts/components/blockForm';
import { HorizontalForm } from '../../pages/forms/components/layouts/components/horizontalForm';
import { BasicForm } from '../../pages/forms/components/layouts/components/basicForm';
import { WithoutLabelsForm } from '../../pages/forms/components/layouts/components/withoutLabelsForm';

@NgModule({
  imports: [
    CommonModule,
    AngularFormsModule,
    AppTranslationModule,
    NgaModule,
    NgbRatingModule,
    routing
  ],
  declarations: [
    Layouts,
    Booking,
    BlockForm,
    HorizontalForm,
    BasicForm,
    WithoutLabelsForm
  ]
})
export class BookingModule {
}

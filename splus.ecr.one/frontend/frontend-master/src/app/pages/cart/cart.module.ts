import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { Cart } from './cart.component';
import { CartService } from './cart.service';
import { SearchService } from '../search/search.service'
//import { Layouts } from '../../pages/forms/components/layouts';
import { routing } from './cart.routing';


//import { BlockForm } from '../../pages/forms/components/layouts/components/blockForm';
// import { HorizontalForm } from '../../pages/forms/components/layouts/components/horizontalForm';
// import { BasicForm } from '../../pages/forms/components/layouts/components/basicForm';
// import { WithoutLabelsForm } from '../../pages/forms/components/layouts/components/withoutLabelsForm';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    AppTranslationModule,
    NgaModule,
    routing,
    Ng2SmartTableModule
  ],
  declarations: [
  //  Layouts,
    Cart
 //   BlockForm,
    // HorizontalForm,
    // BasicForm,
    // WithoutLabelsForm
  ], providers: [
    CartService,SearchService
  ]
})
export class CartModule {
}

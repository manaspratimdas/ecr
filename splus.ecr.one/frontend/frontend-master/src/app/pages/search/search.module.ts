import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import { Search } from './search.component';
import { SearchService } from './search.service';
import { routing }       from './search.routing';



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
    Search
  ],
  providers: [
    SearchService
  ]
})
export class SearchModule {}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import { MyAction } from './myaction.component';
import { MyActionService } from './myaction.service';
import { routing } from './myaction.routing';
import { JsonpModule } from '@angular/http';


@NgModule({
  imports: [JsonpModule,
    CommonModule,
    FormsModule,
    AppTranslationModule,
    NgaModule,
    routing,
    Ng2SmartTableModule
  ],
  declarations: [
    MyAction
  ],
  providers: [
    MyActionService
  ]
})
export class MyActionModule {}

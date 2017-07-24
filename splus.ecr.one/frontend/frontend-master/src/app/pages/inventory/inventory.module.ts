import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import { Inventory } from './inventory.component';
import { InventoryService } from './inventory.service';
import { routing }       from './inventory.routing';
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
    Inventory
  ],
  providers: [
    InventoryService
  ]
})
export class InventoryModule {}

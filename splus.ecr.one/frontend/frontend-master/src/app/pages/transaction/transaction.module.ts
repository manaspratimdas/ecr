import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import { Transaction } from './transaction.component';
import { TransactionService } from './transaction.service';
import { routing }       from './transaction.routing';



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
    Transaction
  ],
  providers: [
    TransactionService
  ]
})
export class TransactionModule {}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppTranslationModule } from '../../app.translation.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import { LoginService } from './login.service';
import { JsonpModule } from '@angular/http';

import { Login } from './login.component';
import { routing } from './login.routing';


@NgModule({
  imports: [JsonpModule,
    CommonModule,
    AppTranslationModule,
    ReactiveFormsModule,
    FormsModule,
    NgaModule,
    routing
  ],
  declarations: [
    Login
  ],providers: [
    LoginService
  ]
})
export class LoginModule {}

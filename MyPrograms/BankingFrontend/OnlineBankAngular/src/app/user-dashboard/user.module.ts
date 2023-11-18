import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { CustomerService } from '../services/customer.service';

@NgModule({
    imports: [
      CommonModule,
      FormsModule,
      UserRoutingModule
    ],
    // declarations: [ OrderByPipe, RatingComponent],
    providers: [CustomerService]
  })
  export class UserModule { }
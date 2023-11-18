import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';

@NgModule({
    imports: [
      CommonModule,
      FormsModule,
      AdminRoutingModule
    ],
    // declarations: [ OrderByPipe, RatingComponent],
    // providers: [ProductService, AuthGuardService]
  })
  export class AdminModule { }
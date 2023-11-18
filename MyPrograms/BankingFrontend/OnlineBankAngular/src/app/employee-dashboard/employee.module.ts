import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeService } from '../services/employee.service';

@NgModule({
    imports: [
      CommonModule,
      FormsModule,
      EmployeeRoutingModule
    ],
    // declarations: [ OrderByPipe, RatingComponent],
    providers: [EmployeeService]
  })
  export class EmployeeModule { }
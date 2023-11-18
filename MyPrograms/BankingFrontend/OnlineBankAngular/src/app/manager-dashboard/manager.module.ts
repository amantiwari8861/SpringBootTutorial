import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ManagerRoutingModule } from './manager-routing.module';
import { ManagerService } from '../services/manager.service';

@NgModule({
    imports: [
      CommonModule,
      FormsModule,
      ManagerRoutingModule
    ],
    // declarations: [ OrderByPipe, RatingComponent],
    providers: [ManagerService]
  })
  export class ManagerModule { }
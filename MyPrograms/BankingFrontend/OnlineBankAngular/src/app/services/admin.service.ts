import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, tap, throwError } from 'rxjs';
import { Admin } from '../models/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  admins!:any;
  constructor(public http:HttpClient) { 
    this.http.get<Admin[]>('./assets/admin/admins.json').pipe(
      tap((admins) => {
        this.admins = admins;
      console.log(admins);
      
      }),
      catchError(this.handleError));

  }
   // Error Handling code
   private handleError(err: HttpErrorResponse) {
    return throwError(() => err.error() || 'Server error');
}
}

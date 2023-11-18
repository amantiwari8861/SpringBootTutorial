import { Injectable } from '@angular/core';
import { Observable,throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import {
    HttpClient,
    HttpErrorResponse,
    HttpHeaders,
  } from '@angular/common/http';
import { Customer } from '../models/Customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

    customersUrl = 'http://localhost:9090/api/users';
  options = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {  }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customersUrl).pipe(
      tap((data: any) => console.log('Data Fetched:' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }
  addCustomer(customer: Customer): Observable<any> {
    return this.http
      .post(this.customersUrl, customer, {
        headers: this.options,
      })
      .pipe(catchError(this.handleError));
  }
  updateCustomer(customer: Customer): Observable<any> {
    // const options = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http
      .put<any>(this.customersUrl, customer, {
        headers: this.options,
      })
      .pipe(
        tap((_: any) => console.log(`updated Customer id=${customer.custid}`)),
        catchError(this.handleError)
      );
  }
  deleteCustomer(customerId: number): Observable<any> {
    const url = `${this.customersUrl}/${customerId}`;
    return this.http.delete(url).pipe(catchError(this.handleError));
  }
  private handleError(err: HttpErrorResponse): Observable<any> {
    let errMsg = '';
    if (err.error instanceof Error) {
      // A client-side or network error occurred. Handle it accordingly.
      console.log('An error occurred:', err.error.message);
      errMsg = err.error.message;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.log(`Backend returned code ${err.status}`);
      errMsg = err.error.status;
    }
    return throwError(() => errMsg);
  }
}

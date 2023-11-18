import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Employee } from '../models/Employee';
@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  employeesUrl = 'http://localhost:9090/employees';
  options = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {}
  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeesUrl).pipe(
      tap((data: any) => console.log('Data Fetched:' + JSON.stringify(data))),
      catchError(this.handleError)
    );
  }
  addEmployee(employee: Employee): Observable<any> {
    return this.http
      .post(this.employeesUrl, employee, {
        headers: this.options,
      })
      .pipe(catchError(this.handleError));
  }
  updateEmployee(employee: Employee): Observable<any> {
    // const options = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http
      .put<any>(this.employeesUrl, employee, {
        headers: this.options,
      })
      .pipe(
        tap((_: any) => console.log(`updated Employee id=${employee.empid}`)),
        catchError(this.handleError)
      );
  }
  deleteEmployee(employeeId: number): Observable<any> {
    const url = `${this.employeesUrl}/${employeeId}`;
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

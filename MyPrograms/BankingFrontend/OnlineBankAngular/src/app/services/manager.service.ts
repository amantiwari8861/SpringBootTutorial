import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Manager } from '../models/Manager';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  baseUrl = 'http://localhost:9090/managers/';
  constructor(private http: HttpClient) { }
  getManagers(): Observable<Manager[]> {
     return this.http.get<Manager[]>(this.baseUrl);
  }
  getManagerById(id: number): Observable<Manager> {
    return this.http.get<Manager>(this.baseUrl + '/' + id);
  }

  createManager(manager: Manager): Observable<Manager> {
    return this.http.post<Manager>(this.baseUrl, manager);
  }

  updateManager(manager: Manager): Observable<Manager> {
    return this.http.put<Manager>(this.baseUrl + '/' + manager.mid, manager);
  }

  deleteManager(managerId: number): Observable<Manager> {
    return this.http.delete<Manager>(this.baseUrl + '/' + managerId);
  }
}

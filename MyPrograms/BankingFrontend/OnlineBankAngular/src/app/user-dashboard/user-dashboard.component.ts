import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../models/Customer';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css'],
})
export class UserDashboardComponent implements OnInit {
  customers!: Customer[];
  errorMessage!:string;
  constructor(private http: HttpClient,private customerService:CustomerService) 
  {
    this.customerService.getCustomers().subscribe({
      next: customers => this.customers = customers,
      error:error => this.errorMessage = <any>error
    })
  }
  dtOptions: DataTables.Settings = {};

  ngOnInit(): void {
        setTimeout(() => {
          $('#customertable').DataTable({
            pagingType: 'full_numbers',
            pageLength: 5,
            processing: true,
            lengthMenu: [5, 10, 25, 50],
          });
        },2);
  }
  
}

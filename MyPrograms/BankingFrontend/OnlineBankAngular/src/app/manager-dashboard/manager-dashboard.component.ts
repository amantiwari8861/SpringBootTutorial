import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Manager } from '../models/Manager';

@Component({
  selector: 'app-manager-dashboard',
  templateUrl: './manager-dashboard.component.html',
  styleUrls: ['./manager-dashboard.component.css']
})
export class ManagerDashboardComponent implements OnInit {

  managers!:Manager[];
  constructor(private http: HttpClient) { }
  dtOptions: DataTables.Settings = {};
   
  ngOnInit(): void {
    // this.dtOptions = {
    //   // data:this.managers,
    //   serverSide:true,
    //   pagingType: 'full_numbers',
    //   pageLength: 5,
    //   processing: true,
    //   // columns:[
    //   //   {"title":"Manager Id",},
    //   //   {"title":"Manager Name",data:"mname"},
    //   // ]
    // };
    this.http.get<Manager[]>('../assets/manager/managers.json')
      .subscribe(managers => {
        this.managers = managers;
        // console.log(managers);

        setTimeout(()=>{   
          $('#managertable').DataTable( {
            pagingType: 'full_numbers',
            pageLength: 5,
            processing: true,
            lengthMenu : [5, 10, 25,50,100]
        } );
        }, 1);
      });
  }
}

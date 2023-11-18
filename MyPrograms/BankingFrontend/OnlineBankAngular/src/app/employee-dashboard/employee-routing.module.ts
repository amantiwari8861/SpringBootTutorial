import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeDashboardComponent } from './employee-dashboard.component';
const employeeRoutes: Routes = [
    {path: '',canActivate: []},
    // {path:'Employeecrud',loadChildren:()=>import("../Employee-dashboard/Employee.module").then(m=>m.EmployeeModule)},
    // {path:'usercrud',loadChildren:()=>import("../user-dashboard/user.module").then(m=>m.UserModule)}
];
@NgModule({
    imports: [RouterModule.forChild(employeeRoutes)],
    exports: [RouterModule]
})
export class EmployeeRoutingModule { }

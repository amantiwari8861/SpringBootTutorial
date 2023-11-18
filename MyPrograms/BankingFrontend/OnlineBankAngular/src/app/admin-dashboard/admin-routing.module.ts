import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeDashboardComponent } from '../employee-dashboard/employee-dashboard.component';
import { ManagerDashboardComponent } from '../manager-dashboard/manager-dashboard.component';
import { UserDashboardComponent } from '../user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard.component';
const adminRoutes: Routes = [
  {
    path: '',
    canActivate: [],
    children: [
      {
        path: 'managercrud',
        component:ManagerDashboardComponent,
        loadChildren: () =>
          import('../manager-dashboard/manager.module').then(
            (m) => m.ManagerModule
          ),
      },
      {
        path: 'usercrud',
        component:UserDashboardComponent,
        loadChildren: () =>
          import('../user-dashboard/user.module').then(
            (m) => m.UserModule),
      },
      {
        path: 'employeecrud',
        component:EmployeeDashboardComponent,
        loadChildren: () =>
          import('../employee-dashboard/employee.module').then(
            (m) => m.EmployeeModule),
      }
    ],
  },
];
@NgModule({
  imports: [RouterModule.forChild(adminRoutes)],
  exports: [RouterModule],
})
export class AdminRoutingModule {}

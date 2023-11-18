import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { IndexComponent } from './components/index/index.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { LoginGuardService } from './guards/login-guard.service';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import { ManagerDashboardComponent } from './manager-dashboard/manager-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

const appRoutes: Routes = [
  { path: 'web', component:IndexComponent},
  { path: '', redirectTo: '/web', pathMatch: 'full' },
  { path: 'login', component:SignInComponent },
  { path: 'register', component:SignUpComponent },
  { path: 'admin', component:AdminDashboardComponent,
  // canActivate:[LoginGuardService],
    loadChildren:()=>import("./admin-dashboard/admin.module").then(m=>m.AdminModule)
  },
  { path: 'manager', component:ManagerDashboardComponent ,canActivate:[LoginGuardService],
    loadChildren:()=>import("./manager-dashboard/manager.module").then(m=>m.ManagerModule)
  },
  { path: 'employee', component:EmployeeDashboardComponent,canActivate:[LoginGuardService],
    loadChildren:()=>import("./employee-dashboard/employee.module").then(m=>m.EmployeeModule)
  },
  { path: 'user', component:UserDashboardComponent ,canActivate:[LoginGuardService],
  loadChildren:()=>import("./user-dashboard/user.module").then(i=>i.UserModule) 
  },
  // { path: '/user/:id', component: UserDashboardComponent },
  { path: '**', component: PagenotfoundComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

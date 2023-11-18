import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginGuardService } from '../guards/login-guard.service';
import { ManagerDashboardComponent } from './manager-dashboard.component';
const managerRoutes: Routes = [
    {path: '/manager',
    // component:ManagerDashboardComponent,
    canActivate: [LoginGuardService]},

    // {path:'managercrud',loadChildren:()=>import("../manager-dashboard/manager.module").then(m=>m.ManagerModule)},
    // {path:'usercrud',loadChildren:()=>import("../user-dashboard/user.module").then(m=>m.UserModule)}
];
@NgModule({
    imports: [RouterModule.forChild(managerRoutes)],
    exports: [RouterModule]
})
export class ManagerRoutingModule { }

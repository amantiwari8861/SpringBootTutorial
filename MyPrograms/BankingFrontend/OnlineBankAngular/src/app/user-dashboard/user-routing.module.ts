import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserDashboardComponent } from './user-dashboard.component';
const userRoutes: Routes = [
    {path: '',canActivate: []},
    // {path:'managercrud',loadChildren:()=>import("../manager-dashboard/manager.module").then(m=>m.ManagerModule)},
    // {path:'usercrud',loadChildren:()=>import("../user-dashboard/user.module").then(m=>m.UserModule)}
];
@NgModule({
    imports: [RouterModule.forChild(userRoutes)],
    exports: [RouterModule]
})
export class UserRoutingModule { }

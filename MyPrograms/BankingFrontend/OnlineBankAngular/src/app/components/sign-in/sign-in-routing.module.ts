import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './sign-in.component';
import { LoginGuardService } from "../../guards/login-guard.service";
const loginRoutes: Routes = [
    {
        path: '',
        component: SignInComponent,
        canActivate: [LoginGuardService]
    }
];
@NgModule({
    imports: [RouterModule.forChild(loginRoutes)],
    exports: [RouterModule]
})
export class BookRoutingModule { }

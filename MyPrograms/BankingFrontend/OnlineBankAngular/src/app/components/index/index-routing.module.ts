import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from '../sign-in/sign-in.component';
const indexRoutes: Routes = [
    {
        path: '',
        component:SignInComponent,
        // canActivate: [SignInGuardService]
    }
];
@NgModule({
    imports: [RouterModule.forChild(indexRoutes)],
    exports: [RouterModule]
})
export class IndexRoutingModule { }

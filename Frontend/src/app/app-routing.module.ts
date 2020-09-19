import { ProfileAdminComponent } from './admin/profile-admin/profile-admin.component';
import { ForgotPasswordComponent } from './authorization/forgot-password/forgot-password.component';
import { RegisterComponent } from './authorization/register/register.component';
import { HomeComponent } from './Home/home/home.component';
import { LoginComponent } from './authorization/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path : '', redirectTo : '/home', pathMatch: 'full'},
  {path : 'home', component : HomeComponent},
  {path : 'login', component : LoginComponent},
  {path : 'register', component : RegisterComponent},
  {path : 'forgotpassword', component : ForgotPasswordComponent},
  {path : 'profile-admin', component : ProfileAdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

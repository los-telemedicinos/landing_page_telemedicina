import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainPageComponent} from "./components/aboutBeforeMain/main-page/main-page.component";
import {RegisterPatientComponent} from "./components/aboutBeforeMain/register-patient/register-patient.component";
import {LoginComponent} from "./components/aboutBeforeMain/login/login.component";
import {PacientePrincipalComponent} from "./components/aboutMain/paciente-principal/paciente-principal.component";
import {ListDoctorComponent} from "./components/aboutDoctors/list-doctor/list-doctor.component";
import {AuthGuard} from "./guards/auth.guard";
import {RegisterDoctorComponent} from "./components/aboutDoctors/register-doctor/register-doctor.component";
import {ListTimeDoctorComponent} from "./components/aboutDoctors/list-time-doctor/list-time-doctor.component";
import {
  AppointmentRegisterComponent
} from "./components/aboutAppointment/appointment-register/appointment-register.component";

const routes: Routes = [
  {path: "", component: MainPageComponent},
  {path: "register/patient", component: RegisterPatientComponent},
  {path: "login", component: LoginComponent},
  {path: "user/main", component: PacientePrincipalComponent, canActivate:[AuthGuard]},
  {path: "user/list-doctors", component: ListDoctorComponent, canActivate:[AuthGuard]},
  {path: "user/register-doctor", component: RegisterDoctorComponent, canActivate:[AuthGuard]},
  {path: "user/show-info-doctors", component: ListTimeDoctorComponent, canActivate: [AuthGuard]},
  {path: "user/register-appointment", component: AppointmentRegisterComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

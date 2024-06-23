import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MainPageComponent } from './components/aboutBeforeMain/main-page/main-page.component';
import {MatToolbar} from "@angular/material/toolbar";
import {MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import { HeaderMenuComponent } from './components/aboutBeforeMain/header-menu/header-menu.component';
import {NgOptimizedImage} from "@angular/common";
import {HTTP_INTERCEPTORS, HttpClientModule, provideHttpClient, withFetch} from "@angular/common/http";
import {MaterialModule} from "./modules/material.module";
import {MatOption, MatSelect} from "@angular/material/select";
import {
  MatDatepicker,
  MatDatepickerInput,
  MatDatepickerModule,
  MatDatepickerToggle
} from "@angular/material/datepicker";
import { RegisterPatientComponent } from './components/aboutBeforeMain/register-patient/register-patient.component';
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardModule} from "@angular/material/card";
import { LoginComponent } from './components/aboutBeforeMain/login/login.component';
import { HeaderPacienteComponent } from './components/aboutMain/header-paciente/header-paciente.component';
import { PacientePrincipalComponent } from './components/aboutMain/paciente-principal/paciente-principal.component';
import { DoctorDetailsComponent } from './components/aboutDoctors/doctor-details/doctor-details.component';
import { ListDoctorComponent } from './components/aboutDoctors/list-doctor/list-doctor.component';
import {AuthInterceptor} from "./interceptor/auth.interceptor";
import { RegisterDoctorComponent } from './components/aboutDoctors/register-doctor/register-doctor.component';
import { ListTimeDoctorComponent } from './components/aboutDoctors/list-time-doctor/list-time-doctor.component';
import {MatGridList, MatGridTile} from "@angular/material/grid-list";
import {MatNativeDateModule} from "@angular/material/core";
import {FormsModule} from "@angular/forms";
import {MatCheckbox} from "@angular/material/checkbox";
import { AppointmentRegisterComponent } from './components/aboutAppointment/appointment-register/appointment-register.component';
import { ViewListAppointmentComponent } from './components/aboutAppointment/view-list-appointment/view-list-appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PacientePrincipalComponent,
    DoctorDetailsComponent,
    ListDoctorComponent,
    ListTimeDoctorComponent,
    ViewListAppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbar,
    MatIconButton,
    MatIcon,
    MainPageComponent,
    NgOptimizedImage,
    HeaderMenuComponent,
    HttpClientModule,
    MaterialModule,
    MatSelect,
    MatOption,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatDatepicker,
    MatCard,
    MatCardContent,
    RegisterPatientComponent,
    HeaderPacienteComponent,
    MatCardHeader,
    MatCardActions,
    MatCardModule,
    RegisterDoctorComponent,
    MatGridList,
    MatGridTile,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule,
    MatCheckbox,
    AppointmentRegisterComponent
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
    provideHttpClient(withFetch()),
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

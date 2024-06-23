import {Component, OnInit} from '@angular/core';
import {MatCardModule} from "@angular/material/card";
import {HeaderMenuComponent} from "../header-menu/header-menu.component";
import {NgOptimizedImage} from "@angular/common";
import {MatFormField, MatFormFieldModule} from "@angular/material/form-field";
import {MatInput, MatInputModule} from "@angular/material/input";
import {
  FormBuilder,FormGroup,
  FormsModule,
  ReactiveFormsModule, Validators
} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {PatientService} from "../../../services/ServicePatient/patient.service";
import {MatSnackBar, MatSnackBarModule} from "@angular/material/snack-bar";
import {Router, RouterLink} from "@angular/router";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {provideNativeDateAdapter} from "@angular/material/core";
import {Patient} from "../../../models/Patient";

@Component({
  selector: 'app-register-ServicePatient',
  templateUrl: './register-patient.component.html',
  styleUrl: './register-patient.component.css',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatCardModule, HeaderMenuComponent, NgOptimizedImage, MatFormField, MatInput, FormsModule, MatFormFieldModule, MatInputModule, MatIconModule, MatButtonModule, ReactiveFormsModule, MatSnackBarModule, MatDatepickerModule, RouterLink]
})
export class RegisterPatientComponent implements OnInit{

  crearForm !: FormGroup

  constructor(private router: Router, private patientService: PatientService, private formulario: FormBuilder, private _snackBar: MatSnackBar){}

  openSnackBar(message: string, action: string){
    this._snackBar.open(message, action, {duration: 3000})
  }

  ngOnInit(): void {
    this.crearForm = this.formulario.group({
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      birthdate: ['', Validators.required],
      address: ['', Validators.required],
      email: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      dni: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
      password_repeat: ['', Validators.required]
    })
  }

  registrarPaciente(){

    if(this.crearForm.get('password')?.value !== this.crearForm.get('password_repeat')?.value){
      this.openSnackBar('Las contraseñas son diferentes', 'Cerrar')
      this.crearForm.get('password')?.reset()
      this.crearForm.get('password_repeat')?.reset()
      return
    }
    if(this.crearForm.invalid){
      this.openSnackBar('Por favor completa todos los campos requeridos correctamente para crear tu cuenta', 'Cerrar')
      return
    }
    const paciente: Omit<Patient, 'id'> = {
      name: this.crearForm.get('name')?.value,
      lastName: this.crearForm.get('lastName')?.value,
      birthdate: this.crearForm.get('birthdate')?.value,
      address: this.crearForm.get('address')?.value,
      email: this.crearForm.get('email')?.value,
      phoneNumber: this.crearForm.get('phoneNumber')?.value,
      dni:this.crearForm.get('dni')?.value,
      username: this.crearForm.get('username')?.value,
      password: this.crearForm.get('password')?.value,
    }

    this.patientService.create(paciente).subscribe({
      next: (response) =>{
        console.log(paciente)
        console.log(this.crearForm.get('password_repeat'))
        this.openSnackBar(`La cuenta del paciente ${paciente.name} ${paciente.lastName} fue creado correctamente. Gracias por su preferencia`, "Cerrar")
        this.router.navigate([''])
        this.crearForm.reset()
      },
      error: (err) =>{
        console.log('Lo sentimos, no se pudo crear el paciente: ', err)
      }
    })
  }
}

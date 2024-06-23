import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router, RouterLink} from "@angular/router";
import {PatientService} from "../../../services/ServicePatient/patient.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Patient} from "../../../models/Patient";
import {MatOption, provideNativeDateAdapter} from "@angular/material/core";
import {HeaderMenuComponent} from "../../aboutBeforeMain/header-menu/header-menu.component";
import {MatCard, MatCardContent} from "@angular/material/card";
import {NgForOf, NgOptimizedImage} from "@angular/common";
import {MaterialModule} from "../../../modules/material.module";
import {MatIcon} from "@angular/material/icon";
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";
import {HeaderPacienteComponent} from "../../aboutMain/header-paciente/header-paciente.component";
import {DoctorService} from "../../../services/ServiceDoctor/doctor.service";
import {Doctor} from "../../../models/Doctor";
import {MatSelect} from "@angular/material/select";
import {Speciality} from "../../../models/Speciality";
import {SpecialityService} from "../../../services/ServiceSpeciality/speciality.service";

@Component({
  selector: 'app-register-doctor',
  templateUrl: './register-doctor.component.html',
  styleUrl: './register-doctor.component.css',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [
    HeaderMenuComponent,
    MatCard,
    MatCardContent,
    NgOptimizedImage,
    MaterialModule,
    MatIcon,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatDatepicker,
    HeaderPacienteComponent,
    RouterLink,
    MatSelect,
    MatOption,
    NgForOf
  ]
})
export class RegisterDoctorComponent implements OnInit{
  crearForm !: FormGroup
  specialitySelect: Speciality = {id: 0, specialityName: ''}
  specialities: Speciality[] = []

  @ViewChild('textarea') textarea!: ElementRef<HTMLTextAreaElement>

  constructor(private router: Router, private doctorService: DoctorService, private formulario: FormBuilder, private _snackBar: MatSnackBar, private specialityService: SpecialityService){}

  openSnackBar(message: string, action: string){
    this._snackBar.open(message, action, {duration: 3000})
  }

  onEspecialidadSeleccionadaChange(event: any): void{
    const selectedId = +event.value
    this.specialitySelect =<Speciality>this.specialities.find(s => s.id === selectedId)
  }

  ngOnInit(): void {
    this.specialityService.listaSpeciality().subscribe(data => {
      this.specialities = data
      console.log(this.specialities)
    })
    this.crearForm = this.formulario.group({
      name: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      dni: ['', Validators.required],
      tuitionNumber: ['', Validators.required],
      speciality: ['', Validators.required],
      doctorDetails: ['', Validators.required]
    })
  }

  ngAfterViewInit(): void{
    if(this.textarea){
      this.textarea.nativeElement.addEventListener('input', this.adjustTextareaHeight.bind(this))
    }
  }

  adjustTextareaHeight(): void{
    this.textarea.nativeElement.style.height = 'auto'
    this.textarea.nativeElement.style.height = `${this.textarea.nativeElement.scrollHeight}px`
  }

  registrarDoctor(){
    if(this.crearForm.invalid){
      this.openSnackBar('Por favor completa todos los campos requeridos correctamente para crear la cuenta del doctor', 'Cerrar')
      return
    }
    const doctor: Omit<Doctor, 'id'> = {
      name: this.crearForm.get('name')?.value,
      lastName: this.crearForm.get('lastName')?.value,
      email: this.crearForm.get('email')?.value,
      dni:this.crearForm.get('dni')?.value,
      tuitionNumber: this.crearForm.get('tuitionNumber')?.value,
      speciality: this.specialitySelect,
      doctorDetails: this.crearForm.get('doctorDetails')?.value
    }
    console.log(doctor)
    this.doctorService.registrarDoctor(doctor).subscribe({
      next: (response) =>{
        this.openSnackBar(`La cuenta del paciente ${doctor.name} ${doctor.lastName} fue creado correctamente.`, "Cerrar")
        this.router.navigate(['/user/list-doctors'])
        this.crearForm.reset()
      },
      error: (err) =>{
        console.log('Lo sentimos, no se pudo crear el paciente: ', err)
      }
    })
  }

}

import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import { Router } from "@angular/router";
import { DoctorService } from "../../../services/ServiceDoctor/doctor.service";
import { MatSnackBar } from "@angular/material/snack-bar";
import { DoctorTimeService } from "../../../services/ServiceDoctorTime/doctor-time.service";
import { UsernameService } from "../../../services/ServiceUsername/username.service";
import { PatientService } from "../../../services/ServicePatient/patient.service";
import { AppointmentService } from "../../../services/ServiceAppointment/appointment.service";
import { Appointment } from "../../../models/Appointment";
import {NgForOf, NgIf, NgOptimizedImage} from "@angular/common";
import { MatCard, MatCardContent } from "@angular/material/card";
import { MatIcon } from "@angular/material/icon";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import { MatInput } from "@angular/material/input";
import { MatButton } from "@angular/material/button";
import { RouterLink } from "@angular/router";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {Patient} from "../../../models/Patient";
import {Doctor} from "../../../models/Doctor";
import {Doctor_Time} from "../../../models/Doctor_Time";
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-appointment-register',
  templateUrl: './appointment-register.component.html',
  styleUrl: './appointment-register.component.css',
  standalone: true,
  imports: [
    NgOptimizedImage,
    MatCard,
    MatCardContent,
    ReactiveFormsModule,
    MatIcon,
    MatFormField,
    MatInput,
    MatButton,
    RouterLink,
    NgIf,
    MatError,
    MatLabel,
    MatOption,
    MatSelect,
    NgForOf
  ]
})
export class AppointmentRegisterComponent implements OnInit {
  crearForm!: FormGroup;
  idDoctorTime: number = 0;
  idDoctor: number = 0;
  username: string = '';
  idPatient: number = 0;
  dateAppointment: Date = new Date()
  registerDate: Date = new Date()
  state: string = 'Pendiente'
  patient: Patient = {id: 0, name: '', lastName: '', birthdate: new Date(), address: '', email: '', phoneNumber: '', dni: '', username: '', password: ''}
  doctor: Doctor = {id: 0, name: '', lastName: '', doctorDetails: '', email: '', dni: 0, tuitionNumber: '', speciality: {id: 0, specialityName: ''}}
  doctorTime: Doctor_Time = {id: 0, day: '', startTime: '', endTime: '', usedAppointment: false}

  constructor(
    private router: Router,
    private doctorService: DoctorService,
    private formulario: FormBuilder,
    private _snackBar: MatSnackBar,
    private doctorTimeService: DoctorTimeService,
    private usernameService: UsernameService,
    private patientService: PatientService,
    private appointmentService: AppointmentService,
  ) {}

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, { duration: 3000 });
  }

  // ngOnInit(): void {
  //   this.doctorTimeService.currentIdTimeDoctor.subscribe(id => {
  //     this.idDoctorTime = id;
  //   });
  //
  //   this.doctorService.currentIdDoctor.subscribe(id => {
  //     this.idDoctor = id;
  //   });
  //
  //   this.usernameService.currentUsername.subscribe(username => {
  //     this.username = username;
  //   });
  //
  //   this.patientService.getInfo(this.username).subscribe(patient => {
  //     this.idPatient = patient.id;
  //   });
  //
  //   this.doctorTimeService.currentHourTimeDoctor.subscribe(date =>{
  //     this.dateAppointment = new Date(date);
  //   })
  //
  //   this.crearForm = this.formulario.group({
  //     reason: ['', Validators.required],
  //     temperature: ['', Validators.required],
  //     weight: ['', Validators.required]
  //   });
  // }

  ngOnInit(): void {
    this.doctorTimeService.currentIdTimeDoctor.subscribe(id => {
      this.idDoctorTime = id;
      console.log('ID Doctor Time:', this.idDoctorTime);
    });

    this.doctorService.currentIdDoctor.subscribe(id => {
      this.idDoctor = id;
      console.log('ID Doctor:', this.idDoctor);
    });

    this.usernameService.currentUsername.subscribe(username => {
      this.username = username;
      console.log('Username:', this.username);
    });

    this.patientService.getInfo(this.username).subscribe(patient => {
      this.idPatient = patient.id;
      console.log('Patient ID:', this.idPatient);
    });

    this.doctorTimeService.currentHourTimeDoctor.subscribe(date => {
      this.dateAppointment = new Date(date);
      console.log('Date Appointment:', this.dateAppointment);
    });

    this.crearForm = this.formulario.group({
      reason: ['', Validators.required],
      temperature: ['', Validators.required],
      weight: ['', Validators.required]
    });
  }


  // registrarAppointment() {
  //   if (this.crearForm.invalid) {
  //     this.openSnackBar('Por favor completa todos los campos requeridos correctamente para crear la cita', 'Cerrar');
  //     return;
  //   }
  //
  //   forkJoin({
  //     patient: this.patientService.getPatient(this.idPatient),
  //     doctor: this.doctorService.getDoctor(this.idDoctor),
  //     doctorTime: this.doctorTimeService.getDoctor_Time(this.idDoctorTime)
  //   }).subscribe({
  //     next: ({ patient, doctor, doctorTime }) => {
  //       this.patient = patient;
  //       this.doctor = doctor;
  //       this.doctorTime = doctorTime;
  //
  //       const appointment: Omit<Appointment, 'id'> = {
  //         appointmentDate: this.dateAppointment,
  //         reason: this.crearForm.get('reason')?.value,
  //         state: "Pendiente",
  //         registerDate_Appointment: this.registerDate,
  //         temperature: this.crearForm.get('temperature')?.value,
  //         weight: this.crearForm.get('weight')?.value,
  //         patient: this.patient,
  //         doctor: this.doctor,
  //         doctorTime: this.doctorTime
  //       };
  //       console.log(appointment)
  //       this.appointmentService.createAppointment(appointment).subscribe({
  //         next: () => {
  //           this.openSnackBar("La cita ha sido agendada correctamente", "Cerrar");
  //           this.router.navigate(['/user/list-doctors']);
  //           this.crearForm.reset();
  //         },
  //         error: (err) => {
  //           console.log('Lo sentimos, no se pudo guardar correctamente su cita: ', err);
  //         }
  //       });
  //     },
  //     error: (err) => {
  //       console.log('Error al obtener datos necesarios para la cita: ', err);
  //       this.openSnackBar('Error al obtener datos necesarios para la cita', 'Cerrar');
  //     }
  //   });
  // }

  registrarAppointment() {
    if (this.crearForm.invalid) {
      this.openSnackBar('Por favor completa todos los campos requeridos correctamente para crear la cita', 'Cerrar');
      return;
    }

    console.log('Iniciando la creación de la cita...');

    forkJoin({
      patient: this.patientService.getPatient(this.idPatient),
      doctor: this.doctorService.getDoctor(this.idDoctor),
      doctorTime: this.doctorTimeService.getDoctor_Time(this.idDoctorTime)
    }).subscribe({
      next: ({ patient, doctor, doctorTime }) => {
        console.log('Datos del paciente:', patient);
        console.log('Datos del doctor:', doctor);
        console.log('Datos del tiempo del doctor:', doctorTime);

        if (!patient) {
          console.error('El paciente es nulo');
          this.openSnackBar('Error al obtener datos del paciente', 'Cerrar');
          return;
        }
        if (!doctor) {
          console.error('El doctor es nulo');
          this.openSnackBar('Error al obtener datos del doctor', 'Cerrar');
          return;
        }
        if (!doctorTime) {
          console.error('El tiempo del doctor es nulo');
          this.openSnackBar('Error al obtener datos del tiempo del doctor', 'Cerrar');
          return;
        }

        this.patient = patient;
        this.doctor = doctor;
        this.doctorTime = doctorTime;

        const appointment: Omit<Appointment, 'id'> = {
          appointmentDate: this.dateAppointment,
          reason: this.crearForm.get('reason')?.value,
          state: this.state,
          registerDate_Appointment: new Date(),
          temperature: this.crearForm.get('temperature')?.value,
          weight: this.crearForm.get('weight')?.value,
          patient: this.patient,
          doctor: this.doctor,
          doctorTime: this.doctorTime
        };

        console.log('Datos de la cita:', appointment);

        this.appointmentService.createAppointment(appointment).subscribe({
          next: () => {
            this.openSnackBar("La cita ha sido agendada correctamente", "Cerrar");
            this.router.navigate(['/user/list-doctors']);
            this.crearForm.reset();
          },
          error: (err) => {
            console.log('Lo sentimos, no se pudo guardar correctamente su cita: ', err);
          }
        });
      },
      error: (err) => {
        console.log('Error al obtener datos necesarios para la cita: ', err);
        this.openSnackBar('Error al obtener datos necesarios para la cita', 'Cerrar');
      }
    });
  }

}

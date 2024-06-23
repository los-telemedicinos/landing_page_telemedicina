import {Component, OnInit} from '@angular/core';
import {DoctorService} from "../../../services/ServiceDoctor/doctor.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";
import {Doctor} from "../../../models/Doctor";
import {StateService} from "../../../services/ServiceState/state.service";

@Component({
  selector: 'app-list-doctor',
  templateUrl: './list-doctor.component.html',
  styleUrl: './list-doctor.component.css'
})
export class ListDoctorComponent implements OnInit{
  constructor(private router: Router, private doctorService: DoctorService, private _snackBar: MatSnackBar, private stateService: StateService) {}

  doctors: Doctor[] = []
  filterValue: string = ''
  typeRols: string = ''

  ngOnInit(): void {
    this.stateService.currentTypeRols.subscribe(typeRols => {
      this.typeRols = typeRols
    })
    this.cargaDoctores()
    console.log(this.typeRols)
  }

  cargaDoctores(): void{
    this.doctorService.listaDoctor().subscribe((data: Doctor[]) => {
      this.doctors = data
    }, (error) =>{
        console.error('Error al cargar los doctores', error)
      }
      )
  }
  applyFilter(event: Event){
    const value = (event.target as HTMLInputElement).value.toLowerCase()
    this.doctors = this.doctors.filter(doctor =>
      doctor.name.toLowerCase().includes(value) ||
      doctor.speciality.specialityName.toLowerCase().includes(value)
    )
  }

  resetFilter(){
    this.filterValue = ''
    this.cargaDoctores()
  }


  viewDoctorSchedule(doctor: Doctor) {
    this.doctorService.changeDoctor(doctor.id);
    this.router.navigate(['/user/show-info-doctors']);
  }

  updateDoctorSchedule(doctor: Doctor) {
    this.doctorService.changeDoctor(doctor.id);
    // Redirigir a la ruta de actualización del horario del doctor
    // this.router.navigate(['/user/update-doctor-schedule']);
  }

  goToCreateAccount(){
    this.router.navigate(['/user/register-doctor']);
  }

}

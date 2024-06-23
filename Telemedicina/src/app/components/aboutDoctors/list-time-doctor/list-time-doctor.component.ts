import { Component, OnInit } from '@angular/core';
import { Doctor_Time } from "../../../models/Doctor_Time";
import { ActivatedRoute, Router } from "@angular/router";
import { DoctorTimeService } from "../../../services/ServiceDoctorTime/doctor-time.service";
import { MatSnackBar } from "@angular/material/snack-bar";
import { DoctorService } from "../../../services/ServiceDoctor/doctor.service";

@Component({
  selector: 'app-list-time-doctor',
  templateUrl: './list-time-doctor.component.html',
  styleUrls: ['./list-time-doctor.component.css']
})
export class ListTimeDoctorComponent implements OnInit {
  doctorTimes: Doctor_Time[] = [];
  id: number = 0;
  fechaFiltro!: Date;
  minDate = new Date();
  loading = false;
  selectedTimeId: number | null = null; // Para manejar un único tiempo seleccionado

  constructor(
    private route: ActivatedRoute,
    private doctorTimeService: DoctorTimeService,
    private snackBar: MatSnackBar,
    private router: Router,
    private doctorService: DoctorService
  ) {}

  ngOnInit() {
    this.doctorService.currentIdDoctor.subscribe(id => {
      this.id = id;
      this.cargarDoctorTime(this.id);
    });
  }

  onCheckboxChange(id: number, time: string, isChecked: boolean) {
    if (isChecked) {
      this.selectedTimeId = id;
      this.doctorTimeService.changeTimeDoctor(id); // Actualizar el ID del horario seleccionado en el servicio
      this.doctorTimeService.changeHourTimeDoctor(time)
    } else {
      this.selectedTimeId = null;
      this.doctorTimeService.changeTimeDoctor(0); // Resetear el ID en el servicio si se desmarca
    }
  }

  isCheckboxDisabled(timeId: number): boolean {
    return this.selectedTimeId !== null && this.selectedTimeId !== timeId;
  }

  viewDoctorTime(doctorTime: Doctor_Time) {
    this.doctorService.changeDoctor(doctorTime.id);
  }

  cargarDoctorTime(id: number) {
    this.loading = true;
    this.doctorTimeService.listaTimexDoctor(id).subscribe((times: Doctor_Time[]) => {
      this.doctorTimes = times.map(time => ({ ...time, hidden: false }));
      this.loading = false;
    });
  }

  aplicarFiltro() {
    if (this.fechaFiltro) {
      const filterDate = this.fechaFiltro.toISOString().substring(0, 10);
      this.loading = true;
      this.doctorTimeService.listaTimexDoctor(this.id).subscribe((times: Doctor_Time[]) => {
        this.doctorTimes = times.map(time => ({ ...time, hidden: false }));
        this.doctorTimes = this.doctorTimes.filter(time => {
          const timeDate = new Date(time.day);
          const timeFilterDate = timeDate.toISOString().substring(0, 10);
          return timeFilterDate === filterDate && !time.usedAppointment;
        });

        if (this.doctorTimes.length === 0) {
          this.snackBar.open("El doctor no cuenta con horarios para la fecha seleccionada", "OK", { duration: 3000 });
        }
        this.loading = false;
      });
    }
  }

  limpiarFilter() {
    this.cargarDoctorTime(this.id);
  }

  saveAppointment() {
    if (this.selectedTimeId === null) {
      this.snackBar.open("No se ha seleccionado ningún horario", "OK", { duration: 3000 });
      return;
    }

    const selectedTime = this.doctorTimes.find(time => time.id === this.selectedTimeId);
    if (selectedTime) {
      this.router.navigate(['/user/register-appointment'], {state: {doctorTime: selectedTime}});
    }
  }
}

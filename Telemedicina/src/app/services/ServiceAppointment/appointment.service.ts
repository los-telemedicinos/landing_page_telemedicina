import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Doctor} from "../../models/Doctor";
import {Appointment} from "../../models/Appointment";

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private clientHttp: HttpClient) { }

  createAppointment(appointment: Omit<Appointment, 'id'>){
    return this.clientHttp.post('http://localhost:8080/api/appointment', appointment)
  }
}

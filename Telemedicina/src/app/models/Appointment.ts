import {Patient} from "./Patient";
import {Doctor} from "./Doctor";
import {Doctor_Time} from "./Doctor_Time";

export interface Appointment {
  id: number
  appointmentDate: Date
  reason: string
  state: string
  registerDate_Appointment: Date
  temperature: number
  weight: number
  patient: Patient
  doctor: Doctor
  doctorTime: Doctor_Time

}

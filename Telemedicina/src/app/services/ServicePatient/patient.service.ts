import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Patient} from "../../models/Patient";

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http:HttpClient) { }

  create(patient:Omit<Patient, 'id'>){
    return this.http.post('http://localhost:8080/api/patient', patient)
  }

  getInfo(username:string){
    return this.http.get<Patient>(`http://localhost:8080/api/patient/${username}`)
  }

  getPatient(id:number){
    return this.http.get<Patient>(`http://localhost:8080/api/patient/id/${id}`)
  }
}

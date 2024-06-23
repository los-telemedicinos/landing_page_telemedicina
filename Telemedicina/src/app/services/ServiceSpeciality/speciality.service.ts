import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Speciality} from "../../models/Speciality";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SpecialityService {

  constructor(private clienteHttp: HttpClient) { }

  listaSpeciality(): Observable<Speciality[]>{
    return this.clienteHttp.get<Speciality[]>('http://localhost:8080/api/speciality')
  }

  registrarSpeciality(speciality:Omit<Speciality, 'id'>){
    return this.clienteHttp.post<Speciality>('http://localhost:8080/api/speciality', speciality)
  }
}

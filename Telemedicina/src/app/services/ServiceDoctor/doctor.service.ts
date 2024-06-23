import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Doctor} from "../../models/Doctor";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private clientHttp: HttpClient) { }

  private idDoctor = new BehaviorSubject<number>(0);
  currentIdDoctor = this.idDoctor.asObservable()

  listaDoctor(){
    return this.clientHttp.get<Doctor[]>('http://localhost:8080/api/doctors')
  }

  registrarDoctor(doctor: Omit<Doctor, 'id'>){
    return this.clientHttp.post('http://localhost:8080/api/doctors/register', doctor)
  }

  getDoctor(id: number){
    return this.clientHttp.get<Doctor>(`http://localhost:8080/api/doctors/${id}`)
  }

  changeDoctor(id: number){
    this.idDoctor.next(id)
  }
}

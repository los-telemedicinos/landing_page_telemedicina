import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Doctor_Time} from "../../models/Doctor_Time";
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DoctorTimeService {

  servidor:string="http://localhost:8080/api";
  recurso:string="time";

  constructor(private clientHttp: HttpClient) { }

  private idTimeDoctor = new BehaviorSubject<number>(0);
  currentIdTimeDoctor = this.idTimeDoctor.asObservable()

  private hourTimeDoctor = new BehaviorSubject<string>('');
  currentHourTimeDoctor = this.hourTimeDoctor.asObservable()

  listaDoctor_Time(){
    return this.clientHttp.get<Doctor_Time[]>(this.servidor + "/" + this.recurso);
  }

  listaTimexDoctor(id: number){
    return this.clientHttp.get<Doctor_Time[]>(this.servidor +  "/"  + this.recurso +  "/" + id.toString() );
  }

  updateUsedAppointment(id: number, usedAppointment: boolean): Observable<Doctor_Time> {
    return this.clientHttp.put<Doctor_Time>(`${this.servidor}/${id}/usedAppointment`, usedAppointment);
  }

  getDoctor_Time(id:number){
    return this.clientHttp.get<Doctor_Time>(`${this.servidor}/doctor-time/${id}`)
  }

  changeTimeDoctor(id: number){
    this.idTimeDoctor.next(id)
  }

  changeHourTimeDoctor(time: string){
    this.hourTimeDoctor.next(time)
  }
}

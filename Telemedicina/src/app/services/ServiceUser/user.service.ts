import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {DTOUser} from "../../models/DTOUser";
import {Patient} from "../../models/Patient";
import {User} from "../../models/User";
import {Observable, tap} from "rxjs";
import {DTOToken} from "../../models/DTOToken";
import {response} from "express";
import {UsernameService} from "../ServiceUsername/username.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  username: string = ''
  constructor(private http: HttpClient, private usernameService: UsernameService) {
    this.usernameService.currentUsername.subscribe(username => {
      this.username = username
    })
  }

  login(user: Omit<DTOUser, 'id'>): Observable<DTOToken>{
    return this.http.post<DTOToken>(`http://localhost:8080/api/users/login`, user).pipe(
      tap(response => {
        localStorage.setItem('token', response.jwtToken)
      })
    )
  }

  getInfo(username:string){
    return this.http.get<User>(`http://localhost:8080/api/user/${username}`)
  }

  logout(): void{
    localStorage.removeItem('token')
    localStorage.removeItem('authorities')
    localStorage.removeItem('id')
  }

  getCurrentUser(): Observable<User>{
    return this.http.get<User>(`http://localhost:8080/api/user/${this.username}`)
  }
}

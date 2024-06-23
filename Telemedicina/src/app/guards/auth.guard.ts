// auth.guard.ts
import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import {UserService} from "../services/ServiceUser/user.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router, private userService: UserService) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if(this.isLocalStorageAvailable() && localStorage.getItem('token')){
      const user = this.userService.getCurrentUser()
      user.subscribe((user)=>{
        localStorage.setItem('id', user.id.toString())
        const authorities = user.authorities.map(authority => authority.name)
          localStorage.setItem('authorities', authorities.toString())
      },
        error => {
          console.log('Error al obtener usuario actual: ', error)
        }
      )
      return true
    }else{
      return false
    }
  }

  private isLocalStorageAvailable(): boolean {
    try {
      const testKey = '__testKey__';
      localStorage.setItem(testKey, testKey);
      localStorage.removeItem(testKey);
      return true;
    } catch (e) {
      return false;
    }
  }
}

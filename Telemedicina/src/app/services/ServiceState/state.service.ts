import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StateService {
  private typeRolsSource = new BehaviorSubject<string>('');
  currentTypeRols = this.typeRolsSource.asObservable()
  constructor() { }

  changeTypeRols(typeRols: string){
    this.typeRolsSource.next(typeRols)
  }
}

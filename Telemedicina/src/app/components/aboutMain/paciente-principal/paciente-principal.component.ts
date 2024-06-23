import {Component, OnInit} from '@angular/core';
import {StateService} from "../../../services/ServiceState/state.service";

@Component({
  selector: 'app-paciente-principal',
  templateUrl: './paciente-principal.component.html',
  styleUrl: './paciente-principal.component.css'
})
export class PacientePrincipalComponent implements OnInit{

  typeRols: string = ''

  constructor(private stateService: StateService) {
  }
  ngOnInit(): void {
    this.stateService.currentTypeRols.subscribe(typeRols => {
      this.typeRols = typeRols
    })
  }

}

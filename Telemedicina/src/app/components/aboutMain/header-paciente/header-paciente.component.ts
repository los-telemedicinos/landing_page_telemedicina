import {Component, OnInit} from '@angular/core';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {NgForOf, NgOptimizedImage} from "@angular/common";
import {MatTab, MatTabGroup} from "@angular/material/tabs";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {PatientService} from "../../../services/ServicePatient/patient.service";
import {Patient} from "../../../models/Patient";
import {UserService} from "../../../services/ServiceUser/user.service";
import {User} from "../../../models/User";
import {StateService} from "../../../services/ServiceState/state.service";
import {UsernameService} from "../../../services/ServiceUsername/username.service";
import {MatMenu, MatMenuItem, MatMenuTrigger} from "@angular/material/menu";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-header-paciente',
  templateUrl: './header-paciente.component.html',
  styleUrl: './header-paciente.component.css',
  standalone: true,
  imports: [MatToolbarModule, MatButtonModule, MatIconModule, NgOptimizedImage, MatTabGroup, MatTab, RouterLink, NgForOf, MatMenuTrigger, MatMenu, MatMenuItem]
})
export class HeaderPacienteComponent implements OnInit{

  username!: string
  fullName: string = ''
  typeRols = ''

  constructor(private rutaNavegacion: ActivatedRoute, private patientService: PatientService, private userService: UserService, private router: Router, private stateService: StateService, private usernameService: UsernameService, private _snackBar: MatSnackBar) {
  }
  roles: string[] = []

  openSnackBar(message: string, action: string){
    this._snackBar.open(message, action, {duration: 3000})
  }

  ngOnInit(): void {
    this.usernameService.currentUsername.subscribe(username => {
      this.username = username
    })
    this.actualizarInfo()
  }

  getUserRole(): string{
    return this.typeRols
  }

  actualizarInfo(){
    this.patientService.getInfo(this.username).subscribe({
      next: (data: Patient)=>{
        this.fullName = `${data.name} ${data.lastName}`
        this.userService.getInfo(this.username).subscribe((data: User) =>{
          if(data.authorities && data.authorities.length > 0){
            this.roles =data.authorities.map(auth => auth.name)
            for(let role of this.roles){
              if(role === 'ROLE_PATIENT'){
                this.typeRols = 'Paciente'
              }
              else if(role === 'ROLE_ADMIN') {
                this.typeRols = 'Administrador'
              }
            }
            this.stateService.changeTypeRols(this.typeRols)
          }
        });
      }
    })
  }

  goToProfile() {
    // Implementa la lógica para navegar al perfil del usuario
    // this.router.navigate(['/profile']);
  }

  logout() {
    this.userService.logout();
    this.router.navigate(['/login']);
    this.openSnackBar('Sesión cerrada correctamente', 'Cerrar');
  }
}

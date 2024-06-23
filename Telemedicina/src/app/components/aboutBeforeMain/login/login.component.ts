import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {UserService} from "../../../services/ServiceUser/user.service";
import {DTOUser} from "../../../models/DTOUser";
import {UsernameService} from "../../../services/ServiceUsername/username.service";
import {DTOToken} from "../../../models/DTOToken";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  crearForm !: FormGroup

  constructor(private router: Router, private userService: UserService, private formulario: FormBuilder, private _snackBar: MatSnackBar, private usernameService: UsernameService){}

  roles: string[] = []
  openSnackBar(message: string, action: string){
    this._snackBar.open(message, action, {duration: 3000})
  }

  ngOnInit(): void {
    this.crearForm = this.formulario.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  login(){
    if(this.crearForm.valid){
      const user: Omit<DTOUser, 'id'> = {
        username: this.crearForm.get('username')?.value,
        password: this.crearForm.get('password')?.value,
        type: 'patient'
      }
      this.userService.login(user).subscribe(
        (response: DTOToken) =>{
          this.usernameService.changeUsername(user.username)
          this.openSnackBar(`Bienvenido !! ${user.username}`, 'Cerrar')
          this.router.navigate(['/user/main'])
        },
        error => {
          this.openSnackBar('Login fallido, intente nuevamente', 'Cerrar')
          this.crearForm.reset()
        }
      )
    }
  }
}

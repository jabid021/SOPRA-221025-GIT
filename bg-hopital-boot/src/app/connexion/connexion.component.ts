import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from '../model';
import { ConnexionHttpService } from './connexion-http.service';

@Component({
  selector: 'connexion,[connexion]',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})

export class ConnexionComponent {

  login: string = "";
  password: string = "";
  connecte: Compte= new Compte();

  constructor(private cS: ConnexionHttpService, private router: Router){
    
  }

  auth() {
   this.cS.existByPasswordAndLogin(this.login, this.password).subscribe(resp => {
    this.connecte = resp;
    if(resp.id){
      this.router.navigate(["/medecin"]);
    }
    
  })


  };

}

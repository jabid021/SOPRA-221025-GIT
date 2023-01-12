import { Component } from '@angular/core';

@Component({
  selector: 'app-medecin',
  templateUrl: './medecin.component.html',
  styleUrls: ['./medecin.component.scss']
})
export class MedecinComponent {

  visite:boolean =false;
  attente:boolean=false;

  affichervisites(){
    this.visite = true;
    this.attente= false;
  }
  afficherAttente(){
    this.attente=true;
    this.visite=false;

  }
  recevoirPatient(){

  }
}

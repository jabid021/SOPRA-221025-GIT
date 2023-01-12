import { Component } from '@angular/core';
import { Ordinateur } from '../model';
import { OrdinateurHttpService } from './ordinateur-http.service';
import { OrdinateurService } from './ordinateur.service';


@Component({
  selector: 'app-ordinateur',
  templateUrl: './ordinateur.component.html',
  styleUrls: ['./ordinateur.component.scss']
})
export class OrdinateurComponent {
  formOrdinateur: Ordinateur = null;

  constructor(private ordinateurService: OrdinateurHttpService) {
  
  }


  list(): Array<Ordinateur> {
    return this.ordinateurService.findAll();
  }

  add():void {
    this.formOrdinateur = new Ordinateur();
  }

  edit(id: number): void {
    this.ordinateurService.findById(id).subscribe(resp => {
      this.formOrdinateur = resp;
    });
  }

  save(): void {
    if(this.formOrdinateur.id) { // UPDATE
      this.ordinateurService.update(this.formOrdinateur);
    } else { // CREATE
      this.ordinateurService.create(this.formOrdinateur);
    }

    this.cancel();
  }

  cancel(): void {
    this.formOrdinateur = null;
  }

  remove(id: number): void {
    this.ordinateurService.remove(id);
  }
}

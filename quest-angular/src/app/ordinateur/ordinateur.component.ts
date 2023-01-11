import { Component } from '@angular/core';
import { Ordinateur } from '../model';
import { OrdinateurService } from './ordinateur.service';

@Component({
  selector: 'app-ordinateur',
  templateUrl: './ordinateur.component.html',
  styleUrls: ['./ordinateur.component.scss']
})
export class OrdinateurComponent {
  formOrdinateur: Ordinateur = null;

  constructor(private ordinateurService: OrdinateurService) {
  }

  list(): Array<Ordinateur> {
    return this.ordinateurService.findAll();
  }

  add():void {
    this.formOrdinateur = new Ordinateur();
  }

  edit(id: number): void {
    this.formOrdinateur = {...this.ordinateurService.findById(id)};
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

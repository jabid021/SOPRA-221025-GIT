import { Component } from '@angular/core';
import { Filiere } from '../model';
import { FiliereService } from './filiere.service';

@Component({
  selector: 'app-filiere',
  templateUrl: './filiere.component.html',
  styleUrls: ['./filiere.component.scss']
})
export class FiliereComponent {

  formFiliere: Filiere = null;

  constructor(private filiereService: FiliereService) {
  }

  list(): Array<Filiere> {
    return this.filiereService.findAll();
  }

  add():void {
    this.formFiliere = new Filiere();
  }

  edit(id: number): void {
    this.formFiliere = {...this.filiereService.findById(id)};
  }

  save(): void {
    if(this.formFiliere.id) { // UPDATE
      this.filiereService.update(this.formFiliere);
    } else { // CREATE
      this.filiereService.create(this.formFiliere);
    }

    this.cancel();
  }

  cancel(): void {
    this.formFiliere = null;
  }

  remove(id: number): void {
    this.filiereService.remove(id);
  }
}

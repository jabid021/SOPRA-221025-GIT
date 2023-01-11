import { Component } from '@angular/core';
import { FiliereService } from '../filiere/filiere.service';
import { Filiere, Stagiaire } from '../model';
import { StagiaireService } from './stagiaire.service';

@Component({
  selector: 'app-stagiaire',
  templateUrl: './stagiaire.component.html',
  styleUrls: ['./stagiaire.component.scss']
})
export class StagiaireComponent {
  formStagiaire: Stagiaire = null;

  constructor(private stagiaireService: StagiaireService, private filiereService: FiliereService) {
  }

  list(): Array<Stagiaire> {
    return this.stagiaireService.findAll();
  }

  listFiliere(): Array<Filiere> {
    return this.filiereService.findAll();
  }

  add():void {
    this.formStagiaire = new Stagiaire();
    this.formStagiaire.filiere = new Filiere();
  }

  edit(id: number): void {
    this.formStagiaire = {...this.stagiaireService.findById(id)};

    if(!this.formStagiaire.filiere) {
      this.formStagiaire.filiere = new Filiere();
    }
  }

  save(): void {
    if(this.formStagiaire.id) { // UPDATE
      this.stagiaireService.update(this.formStagiaire);
    } else { // CREATE
      this.stagiaireService.create(this.formStagiaire);
    }

    this.cancel();
  }

  cancel(): void {
    this.formStagiaire = null;
  }

  remove(id: number): void {
    this.stagiaireService.remove(id);
  }
}

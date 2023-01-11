import { Injectable } from '@angular/core';
import { FiliereService } from '../filiere/filiere.service';
import { Filiere, Stagiaire } from '../model';

@Injectable({
  providedIn: 'root'
})
export class StagiaireService {

  stagiaires: Array<Stagiaire> = new Array<Stagiaire>();

  constructor(private filiereService: FiliereService) { 
    this.stagiaires.push(new Stagiaire(3, 0, "BONIN", "Manon", "manon@gmail.com"));
    this.stagiaires.push(new Stagiaire(5, 0, "HUOT", "Clément", "clement@hotmail.com", {...this.filiereService.findById(1)}));
  }

  findAll(): Array<Stagiaire> {
    return this.stagiaires;
  }

  findById(id: number): Stagiaire {
    return this.stagiaires.find(stag => stag.id == id);
  }

  create(stagiaire: Stagiaire): void {
    let maxId = 0;

    this.stagiaires.forEach(fil => {
      if(fil.id > maxId) {
        maxId = fil.id;
      }
    });
    stagiaire.id = maxId + 1;
    stagiaire.version = 0;

    if(stagiaire.filiere && stagiaire.filiere.id) {
      let filiere: Filiere = this.filiereService.findById(stagiaire.filiere.id);
      stagiaire.filiere = {...filiere};
    }

    this.stagiaires.push(stagiaire);
  }

  update(stagiaire: Stagiaire): void {
    let idx: number;

    idx = this.stagiaires.findIndex(stag => stag.id == stagiaire.id);

    stagiaire.version++;

    if(stagiaire.filiere && stagiaire.filiere.id) {
      let filiere: Filiere = this.filiereService.findById(stagiaire.filiere.id);
      stagiaire.filiere = {...filiere};
    }

    this.stagiaires[idx] = stagiaire;
  }

  remove(id: number): void {
    let idx: number = this.stagiaires.findIndex(stag => stag.id == id);

    this.stagiaires.splice(idx, 1);
  }
}

import { Injectable } from '@angular/core';
import { Matiere } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  matieres: Array<Matiere> = new Array<Matiere>();

  constructor() {
    this.matieres.push(new Matiere(1, "HTML", 5457, 0));
    this.matieres.push(new Matiere(7, "JPA", 8857, 2));
    this.matieres.push(new Matiere(9, "SPRING CORE", 1144, 0));
  }

  findAll(): Array<Matiere> {
    return this.matieres;
  }

  findById(id: number): Matiere {
    return this.matieres.find(mat => mat.id == id);
  }

  create(matiere: Matiere): void {
    let maxId = 0;

    this.matieres.forEach(mat => {
      if(mat.id > maxId) {
        maxId = mat.id;
      }
    });
    matiere.id = maxId + 1;
    matiere.version = 0;

    this.matieres.push(matiere);
  }

  update(matiere: Matiere): void {
    let idx: number;

    idx = this.matieres.findIndex(mat => mat.id == matiere.id);

    matiere.version++;
    this.matieres[idx] = matiere;
  }

  remove(id: number): void {
    let idx: number = this.matieres.findIndex(mat => mat.id == id);

    this.matieres.splice(idx, 1);
  }
 }

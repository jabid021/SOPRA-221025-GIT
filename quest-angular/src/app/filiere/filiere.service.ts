import { Injectable } from '@angular/core';
import { Filiere } from '../model';

@Injectable({
  providedIn: 'root'
})
export class FiliereService {

  filieres: Array<Filiere> = new Array<Filiere>();

  constructor() { 
    this.filieres.push(new Filiere(1, 0, "FILIERE JAVA", "2022-10-25", "2023-01-20"));
    this.filieres.push(new Filiere(7, 0, "FILIERE DOTNET", "2023-03-29", "2023-06-12"));
  }

  findAll(): Array<Filiere> {
    return this.filieres;
  }

  findById(id: number): Filiere {
    return this.filieres.find(fil => fil.id == id);
  }

  create(filiere: Filiere): void {
    let maxId = 0;

    this.filieres.forEach(fil => {
      if(fil.id > maxId) {
        maxId = fil.id;
      }
    });
    filiere.id = maxId + 1;
    filiere.version = 0;

    this.filieres.push(filiere);
  }

  update(filiere: Filiere): void {
    let idx: number;

    idx = this.filieres.findIndex(fil => fil.id == filiere.id);

    filiere.version++;
    this.filieres[idx] = filiere;
  }

  remove(id: number): void {
    let idx: number = this.filieres.findIndex(fil => fil.id == id);

    this.filieres.splice(idx, 1);
  }
}

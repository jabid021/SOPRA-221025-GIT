import { Injectable } from '@angular/core';
import { Ordinateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class OrdinateurService {

  ordinateurs: Array<Ordinateur> = new Array<Ordinateur>();

  constructor() { 
    this.ordinateurs.push(new Ordinateur(1, 0, "HP", 16));
    this.ordinateurs.push(new Ordinateur(7, 0, "ASUS", 32));
  }

  findAll(): Array<Ordinateur> {
    return this.ordinateurs;
  }

  findById(id: number): Ordinateur {
    return this.ordinateurs.find(fil => fil.id == id);
  }

  create(ordinateur: Ordinateur): void {
    let maxId = 0;

    this.ordinateurs.forEach(fil => {
      if(fil.id > maxId) {
        maxId = fil.id;
      }
    });
    ordinateur.id = maxId + 1;
    ordinateur.version = 0;

    this.ordinateurs.push(ordinateur);
  }

  update(ordinateur: Ordinateur): void {
    let idx: number;

    idx = this.ordinateurs.findIndex(fil => fil.id == ordinateur.id);

    ordinateur.version++;
    this.ordinateurs[idx] = ordinateur;
  }

  remove(id: number): void {
    let idx: number = this.ordinateurs.findIndex(fil => fil.id == id);

    this.ordinateurs.splice(idx, 1);
  }
}

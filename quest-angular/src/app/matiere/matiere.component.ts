import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Matiere } from '../model';
import { MatiereHttpService } from './matiere-http.service';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.scss']
})
export class MatiereComponent {

  formMatiere: Matiere = null;

  constructor(private matiereService: MatiereHttpService) {
  }

  list(): Array<Matiere> {
    return this.matiereService.findAll();
  }

  add():void {
    this.formMatiere = new Matiere();
  }

  edit(id: number): void {
    this.matiereService.findById(id).subscribe(resp => {
      this.formMatiere = resp;
    });
  }

  save(): void {
    if(this.formMatiere.id) { // UPDATE
      this.matiereService.update(this.formMatiere);
    } else { // CREATE
      this.matiereService.create(this.formMatiere);
    }

    this.cancel();
  }

  cancel(): void {
    this.formMatiere = null;
  }

  remove(id: number): void {
    this.matiereService.remove(id);
  }

}

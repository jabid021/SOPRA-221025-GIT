import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Matiere } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MatiereHttpService {

  serviceUrl: string;
  matieres: Array<Matiere> = new Array<Matiere>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "matieres/";
    this.load();
   }

  findAll(): Array<Matiere> {
    return this.matieres;
  }

  findById(id: number): Observable<Matiere> {
    return this.http.get<Matiere>(this.serviceUrl + id);
  }

  create(matiere: Matiere): void {
    this.http.post<Matiere>(this.serviceUrl, matiere).subscribe(resp => {
      this.load();
    });
  }

  update(matiere: Matiere): void {
    this.http.put<Matiere>(this.serviceUrl + matiere.id, matiere).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Matiere>>(this.serviceUrl).subscribe(response => {
      this.matieres = response;
    });
  }
}

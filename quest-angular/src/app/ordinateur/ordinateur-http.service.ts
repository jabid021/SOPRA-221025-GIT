import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Ordinateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class OrdinateurHttpService {

  serviceUrl: string;
  ordinateurs: Array<Ordinateur> = new Array<Ordinateur>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "ordinateurs/";
    this.load();
   }

  findAll(): Array<Ordinateur> {
    return this.ordinateurs;
  }

  findById(id: number): Observable<Ordinateur> {
    return this.http.get<Ordinateur>(this.serviceUrl + id);
  }

  create(ordinateur: Ordinateur): void {
    this.http.post<Ordinateur>(this.serviceUrl, ordinateur).subscribe(resp => {
      this.load();
    });
  }

  update(ordinateur: Ordinateur): void {
    this.http.put<Ordinateur>(this.serviceUrl + ordinateur.id, ordinateur).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Ordinateur>>(this.serviceUrl).subscribe(response => {
      this.ordinateurs = response;
    });
  }
}

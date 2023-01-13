import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Compte } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ConnexionHttpService {

  serviceUrl: string;
  comptes: Array<Compte> = new Array<Compte>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "";
  
   }


existByPasswordAndLogin(login: string, password :string): Observable<Compte> {
    let authDTO = {"login": login, "password": password};

      this.http.post(this.serviceUrl, authDTO);


  return this.http.post<Compte>(this.serviceUrl, authDTO);
}

}







import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Compte } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ConnexionHttpService {

  serviceUrl: string;
  connexions: Array<Compte> = new Array<Compte>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "";
   }


  auth(login: string, password :string): void {
    let authDTO = {"login": login, "password": password};


    this.http.post("http://www.localhost:4200", authDTO)
  }

}

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConnexionHttpService {

  serviceUrl: string;
  connexions: Array<Compte> = new Array<Compte>();

  constructor(private http: HttpConnexion, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "matieres/";
    this.load();
   }


  auth(login: string, password :string): void {
    let authDTO = {"login": login, "password": password};


    this.http.post("dsfjkfdhjs", authDTO)
  }

  private load(): void {
    this.http.get<Array<Compte>>(this.serviceUrl).subscribe(response => {
      this.connexions = response;
    });
  }
}

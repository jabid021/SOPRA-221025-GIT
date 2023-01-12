import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AppConfigService } from "../app-config.service";
import { Patient } from "../model";

@Injectable({
    providedIn: 'root'
  })
  export class PatientHttpService {
  
    serviceUrl: string;
    patients: Array<Patient> = new Array<Patient>();
  
    constructor(private http: HttpClient, private appConfig: AppConfigService) {
      this.serviceUrl = appConfig.backEndUrl + "secretaire/";
      this.load();
     }
  
    findAll(): Array<Patient> {
      return this.patients;
    }
  
    findById(id: number): Observable<Patient> {
      return this.http.get<Patient>(this.serviceUrl + id);
    }
  
    create(Patient: Patient): void {
      this.http.post<Patient>(this.serviceUrl, Patient).subscribe(resp => {
        this.load();
      });
    }
  
    update(Patient: Patient): void {
      this.http.put<Patient>(this.serviceUrl + Patient.id, Patient).subscribe(resp => {
        this.load();
      });
    }
  
    remove(id: number): void {
      this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
        this.load();
      });
  
     
    }
  
  
  
    private load(): void {
      this.http.get<Array<Patient>>(this.serviceUrl).subscribe(response => {
        this.patients = response;
      });
    }
  }
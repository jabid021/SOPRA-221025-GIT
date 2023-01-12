import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { MedecinComponent } from './medecin/medecin.component';
import { SecretaireComponent } from './secretaire/secretaire.component';
import { PauseComponent } from './pause/pause.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    MedecinComponent,
    SecretaireComponent,
    PauseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

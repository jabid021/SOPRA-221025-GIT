import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { SecretaireComponent } from './secretaire/secretaire.component';
import { MedecinComponent } from './medecin/medecin.component';
import { ConnexionHttpService } from './connexion/connexion-http.service';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    SecretaireComponent
    MedecinComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ConnexionHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }

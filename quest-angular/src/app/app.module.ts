import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { HomeComponent } from './home/home.component';
import { MatiereComponent } from './matiere/matiere.component';
import { MatiereService } from './matiere/matiere.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FiliereComponent } from './filiere/filiere.component';
import { StagiaireComponent } from './stagiaire/stagiaire.component';
import { OrdinateurComponent } from './ordinateur/ordinateur.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    MatiereComponent,
    FiliereComponent,
    StagiaireComponent,
    OrdinateurComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule 
  ],
  providers: [MatiereService],
  bootstrap: [AppComponent]
})
export class AppModule { }

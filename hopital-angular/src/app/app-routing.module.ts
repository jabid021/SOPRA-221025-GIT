import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { MedecinComponent } from './medecin/medecin.component';
import { PauseComponent } from './pause/pause.component';
import { SecretaireComponent } from './secretaire/secretaire.component';

const routes: Routes = [
  {path: "", component: ConnexionComponent, pathMatch: 'full'},
  {path: "medecin", component: MedecinComponent},
  {path: "secretaire", component: SecretaireComponent},
  {path: "pause", component: PauseComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

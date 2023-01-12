import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';

const routes: Routes = [
  {path: "", component: ConnexionComponent, pathMatch: 'full'},
  //{path: "inscription", component: InscriptionComponent},
 // {path: "secretaire", component: SecretaireComponent},
  //{path: "medecin", component: MedecinComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

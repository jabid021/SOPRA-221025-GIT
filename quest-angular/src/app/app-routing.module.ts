import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FiliereComponent } from './filiere/filiere.component';
import { HomeComponent } from './home/home.component';
import { MatiereComponent } from './matiere/matiere.component';
import { OrdinateurComponent } from './ordinateur/ordinateur.component';
import { StagiaireComponent } from './stagiaire/stagiaire.component';

const routes: Routes = [
  {path: "", component: HomeComponent, pathMatch: 'full'},
  {path: "filiere", component: FiliereComponent},
  {path: "matiere", component: MatiereComponent},
  {path: "ordinateur", component: OrdinateurComponent},
  {path: "stagiaire", component: StagiaireComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

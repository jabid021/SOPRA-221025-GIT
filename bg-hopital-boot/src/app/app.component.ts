import { Component } from '@angular/core';
import { Compte } from './model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'bg-hopital-boot';

  compte = new Compte(1,"SULTAN", "Eric");
}

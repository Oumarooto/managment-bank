import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private router: Router) {
  }

  signIn() {
    sessionStorage.setItem('isConnected','false');
    sessionStorage.setItem('token','');
    this.router.navigate(['/sign-in']);
  }

  logOut() {
    sessionStorage.setItem('isConnected','false');
    sessionStorage.setItem('token','');
    this.router.navigate(['/sign-in']);
  }

  isConnected(): boolean {
    return sessionStorage.getItem('isConnected') === 'true';
  }
}

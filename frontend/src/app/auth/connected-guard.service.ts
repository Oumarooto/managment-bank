import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ConnectedGuardService implements CanActivate{

  constructor(private router:Router) {

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const isConnected = sessionStorage.getItem('isConnected') === 'true';
    if (!isConnected){
      return this.router.navigate(['/sign-in'])
    }
    return isConnected;
  }
}

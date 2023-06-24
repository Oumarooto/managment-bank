import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {SignInRequest} from "./models/sign-in-request.model";
import {SignInResponse} from "./models/sign-in-response.model";

@Injectable({
  providedIn: 'root'
})
export class SignInService {

  url = environment.apiUrl + '/api/auth/sign-in'
  constructor(private http: HttpClient) { }

  signIn(signInRequest:SignInRequest):Observable<SignInResponse>{
    return this.http.post<SignInResponse>(this.url, signInRequest)
  }
}

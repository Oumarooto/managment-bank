import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SignInService} from "../sign-in.service";
import {SignInRequest} from "../models/sign-in-request.model";
import {SignInResponse} from "../models/sign-in-response.model";
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  signInForm = new FormGroup({
    login: new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]),
    password: new FormControl('', Validators.maxLength(50)),
  });

  constructor(private signInService: SignInService,
              private router: Router) {
  }
  ngOnInit(): void {
  }

  onSubmit() {
    if (this.signInForm.valid){
      const  value = this.signInForm.value;
      this.signInService.signIn(value as SignInRequest)
        .subscribe({
          next: (res: SignInResponse) => {
            sessionStorage.setItem('isConnected','true');
            sessionStorage.setItem('token',res.token);
            this.router.navigate(['/home']);
          },
          error: (err: any) => {
            console.log(err);
            sessionStorage.setItem('isConnected','false');
            sessionStorage.setItem('token','')
          }
        })
    }

  }

}

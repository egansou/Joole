import { Router } from '@angular/router';
import { Validators } from '@angular/forms';
import { FormGroup, FormControl } from '@angular/forms';
import { AuthService } from './../../services/auth/auth.service';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  invalidSignIn = false;

  form = new FormGroup({
    first : new FormControl('', Validators.required),
    last : new FormControl('', Validators.required),
    username : new FormControl('', Validators.required),
    email : new FormControl('', [Validators.required, Validators.email]),
    password : new FormControl('', Validators.required)
  });

  constructor(private authService : AuthService, private router : Router) {

  }

  ngOnInit(): void {
  }

  get first() {
    return this.form.get("first")
  }

  get last() {
    return this.form.get("last")
  }

  get username() {
    return this.form.get("username")
  }

  get email() {
    return this.form.get("email")
  }

  get password() {
    return this.form.get("password")
  }

  signup() {

    let consumer = {
      "consumerUsername": this.username.value, 
      "consumerEmail" : this.email.value,
      "consumerFirstName" : this.first.value, 
      "consumerLastName": this.last.value,
      "consumerPassword" : this.password.value,
      "consumerImage" : "placeholder"
    }

    this.authService.createConsumer(consumer).subscribe ( 
      response => {
        if (response === true) this.router.navigate(['/']);
        else this.invalidSignIn = true;
    }, 
    (error : Response) => {
      if (error.status === 500) {
        this.invalidSignIn = true;
      } else {
        alert('An unexpected error occured')
      }
    }

  )};

}

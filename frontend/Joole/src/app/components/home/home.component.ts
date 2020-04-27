import { Router } from '@angular/router';
import { AuthService } from './../../services/auth/auth.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  invalidLogin = false;

  form = new FormGroup({
    userInfo : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required)
  });

  constructor(public authService : AuthService, private router : Router) { }

  ngOnInit(): void {
  }

  get userInfo() {
    return this.form.get("userInfo")
  }

  get password() {
    return this.form.get("password")
  }

  login() {

    let consumer = {
      "consumerUsername": this.userInfo.value, 
      "consumerPassword" : this.password.value,
    }

    this.authService.login(consumer).subscribe ( 
      response => {
        if (response === true) {
          this.router.navigate(['/']);
          this.invalidLogin = false;
        }
        else this.invalidLogin = true;
    }, 
    (error : Response) => {
      if (error.status === 403) {
        this.invalidLogin = true;
      } else {
        alert('An unexpected error occured')
      }
    }

  )};

}

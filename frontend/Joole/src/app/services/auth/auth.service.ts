import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from "@auth0/angular-jwt";

@Injectable()
export class AuthService {

  readonly url = "http://localhost:8080/Joole/consumer/"

  constructor( private http:  HttpClient) { }


  createConsumer (consumer : any) {
    return this.http.post(this.url + 'create', consumer)
    .pipe(
      map (
        (response : any) => {
        if (response && response.jwt) { 
          localStorage.setItem('token', response.jwt);
          return true;
        }
        return false
      })
    );
  }

  login (consumer : any) {
    return this.http.post(this.url + 'login', consumer)
    .pipe(
      map (
        (response : any) => {
        if (response && response.jwt) { 
          localStorage.setItem('token', response.jwt);
          return true;
        }
        return false
      })
    );
  }

  logout (){
    localStorage.removeItem('token');
  }

  isLoggedIn() {
    let jwtHelper = new JwtHelperService();
    let token = localStorage.getItem('token');

    if(!token) return false;

    let isExpired = jwtHelper.isTokenExpired(token);

    return !isExpired;

  }

  get currentUser() {
    let token = localStorage.getItem('token');
    if (!token) return null;
    return new JwtHelperService().decodeToken(token);
  }
}

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { keyframes } from '@angular/animations';

@Injectable()
export class ProductService {

  readonly url = "http://localhost:8080/Joole/product/"

  constructor( private http : HttpClient) { 

  }

  getCompareProducts (ids : any){
    return this.http.post(this.url + 'compare', ids, this.getHeaders());
  }

  getFilterProducts (data : any){

    let par = new HttpParams();

    for (let i in data) { 
      for (let key in data[i]){
        par = par.append(key, data[i][key]);
        //console.log(data[i][key])
      } 
    }

    let para = { params : par}
    return this.http.get(this.url + 'filter', {...para, ...this.getHeaders()});
  }

  getProducts () {
    return this.http.get(this.url, this.getHeaders());
  }

  getProduct (id : string) {
    return this.http.get(this.url + id, this.getHeaders());
  }

  private getHeaders () {
    let token = localStorage.getItem('token');
    return { headers: new HttpHeaders().set("Authorization", 'Bearer ' + token)};
  }
   
}

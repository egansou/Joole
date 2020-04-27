import { Router } from '@angular/router';
import { AuthService } from './../../services/auth/auth.service';
import { ProductService } from './../../services/product/product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  //verifiedDate : string = "02/12/16";
  //manufName = "test 1";
  //series : string = "test 3" ;
  //model : string ="test 2";
  //airflow : number = 1;
  //powerMax : number = 2;
  //soundMaxSpeed : number = 3;
  //fanDiameter : number = 4;
  //firmSpec : number = 5;
  //globalSpec : number = 6;

  products : any[];
  compareList : number[];

  expandTechSpec : boolean;
  expandPastSelect : boolean;

  yearMin : string;
  yearMax : string;
  airflowMin : string;
  airflowMax : string;
  maxPowerMin : string;
  maxPowerMax : string;
  soundMin : string;
  soundMax : string;
  sweepMin : string;
  sweepMax : string;
  firmMin : string;
  firmMax : string;
  globalMin : string;
  globalMax : string;

  constructor(public authService : AuthService, 
    private productService : ProductService, 
    private router : Router) { 

  }

  ngOnInit(): void {
    this.products = [];
    this.compareList = [];

    this.getProducts();

    this.expandTechSpec = true;
    this.expandPastSelect = true;

    this.yearMin = "";
    this.yearMax = "";
    this.airflowMin ="2000";
    this.airflowMax ="10000";
    this.maxPowerMin = "9.84";
    this.maxPowerMax = "96.52";
    this.soundMin = "20";
    this.soundMax = "80";
    this.sweepMin = "18";
    this.sweepMax = "96";
    this.firmMin =  "0";
    this.firmMax = "10";
    this.globalMin = "0";
    this.globalMax = "1492"

  }

  private getProducts() {
    this.productService.getProducts()
    .subscribe ((response : any[])  => {
      this.products = response;
    }, (error : Response) => {
      alert('An unexpected error occured')
    }
  )}


  updateCompareList(info) {
    if(info.isSelected === true) {
      this.compareList.push(info.id)
    } else {
      this.compareList = this.compareList.filter(id => id !== info.id)
    }
  }

  compare(){
    this.router.navigate(['/compare', JSON.stringify(this.compareList)]);
  }

  techSpec() {
    this.expandTechSpec = !this.expandTechSpec;
  }

  pastSelect () {
    this.expandPastSelect = !this.expandPastSelect;
  }

  clear() {

    this.yearMin = "";
    this.yearMax = "";
    this.airflowMin ="2000";
    this.airflowMax ="10000";
    this.maxPowerMin = "9.84";
    this.maxPowerMax = "96.52";
    this.soundMin = "20";
    this.soundMax = "80";
    this.sweepMin = "18";
    this.sweepMax = "96";
    this.firmMin =  "0";
    this.firmMax = "10";
    this.globalMin = "0";
    this.globalMax = "1492"
    this.getProducts();

  }

  save() {
    this.getFilterProducts()
    
  }

  private getFilterProducts() {
    let params : any[] = [];

    if (this.yearMin && this.yearMin.trim() !== "") params.push({yearMin : this.yearMin});
    if (this.yearMax && this.yearMax.trim() !== "") params.push({yearMax : this.yearMax});
    if (this.airflowMin && this.airflowMin.trim() !== "") params.push({airflowMin : this.airflowMin});
    if (this.airflowMax && this.airflowMax.trim() !== "") params.push({airflowMax : this.airflowMax});
    if (this.maxPowerMin && this.maxPowerMin.trim() !== "") params.push({maxPowerMin : this.maxPowerMin});
    if (this.maxPowerMax && this.maxPowerMax.trim() !== "") params.push({maxPowerMax :this.maxPowerMax});
    if (this.soundMin && this.soundMin.trim() !== "") params.push({soundMin : this.soundMin});
    if (this.soundMax && this.soundMax.trim() !== "") params.push({soundMax : this.soundMax});
    if (this.sweepMin && this.sweepMin.trim() !== "") params.push({sweepMin : this.sweepMin});
    if (this.sweepMax && this.sweepMax.trim() !== "") params.push({sweepMax : this.sweepMax});
    if (this.firmMin && this.firmMin.trim() !== "") params.push({firmMin : this.firmMin});
    if (this.firmMax && this.firmMax.trim() !== "") params.push({firmMax : this.firmMax});
    if (this.globalMin && this.globalMin.trim() !== "") params.push({globalMin : this.globalMin});
    if (this.globalMax && this.globalMax.trim() !== "") params.push({globalMax : this.globalMax});

    console.log(params)

    this.productService.getFilterProducts(params)
    .subscribe ((response: any)  => {
      this.products = response;
    }, (error : Response) => {
      alert('An unexpected error occured')
    }
  )}


}

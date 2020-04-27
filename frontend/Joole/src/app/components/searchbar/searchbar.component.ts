import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent implements OnInit {

  defaultCategory : string;

  categories : string [];

  showCategories : boolean;
  showTypes : boolean;

  typeSearch: string;

  types: string[];

  searchTypes : string [];

  constructor(private router : Router) { }

  ngOnInit(): void {
    this.defaultCategory = "Mechanical";
    this.categories = ["Mechanical", "Chemical"];
    this.showCategories = false;
    this.showTypes = false;
    this.types = ["HVAC fans", "Machinery"];
    this.searchTypes = [];
  }

  showC(){
    this.showCategories = !this.showCategories;
  }

  selectC(category : string){
    this.defaultCategory = category;
    this.showCategories = false;
  }

  searchT(){
    this.searchTypes = this.types.filter( type => type.startsWith(this.typeSearch));
  }

  selectT(type : string){
    this.typeSearch = type;
    this.searchTypes = [];
  }

  showAllT(){
    this.showTypes = !this.showTypes;
    if (this.showTypes === true) this.searchTypes = this.types;
    else this.searchTypes = [];
    
  }

  submit(){

    if(this.defaultCategory === "Mechanical" && this.typeSearch === 'HVAC fans') this.router.navigate(['/products']);

  }

}

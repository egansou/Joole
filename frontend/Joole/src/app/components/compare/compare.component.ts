import { ProductService } from './../../services/product/product.service';
import { AuthService } from './../../services/auth/auth.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.css']
})
export class CompareComponent implements OnInit {

  ids : any;
  products : any[];
  constructor(private route : ActivatedRoute, 
    public authService : AuthService, 
    private productService : ProductService, ) { }


 
  ngOnInit(): void {
    this.route.paramMap
      .subscribe(params => {
        this.ids =  {"ids" : JSON.parse(params.get("data"))}
        this.getCompareProducts(this.ids);
      })

  }

  private getCompareProducts(ids : any) {
    this.productService.getCompareProducts(ids)
    .subscribe ((response : any)  => {
      this.products = response;
    }, (error : Response) => {
      alert('An unexpected error occured')
    }
  )}


}

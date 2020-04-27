import { ActivatedRoute } from '@angular/router';
import { ProductService } from './../../services/product/product.service';
import { AuthService } from './../../services/auth/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {


  notFound : boolean = false;
  product : any;

  seriesInformation : String [];
  documents : string [];
  model: string
  fanImage : string
  manufName: String;
  series : string;
  firmSpec : string;
  globalSpec : string;
  useType : string;
  application : string;
  mountingLocation : string;
  accessories : string;
  modelYear : string;
  airflow : string;
  powerMin : string;
  powerMax: string;
  voltageMin : string;
  voltageMax : string;
  fanSpeedMin : string;
  fanSpeedMax : string;
  numberFanSpeed :string;
  soundMaxSpeed :string;
  fanDiameter :string;
  heightMin :string;
  heightMax :string;
  weight :string;
  repName :string;
  repPhone : string;
  repEmail : string;
  repWeb : string;
  manufDep : string;
  manufPhone : string;
  manufEmail : string;
  manufWeb : string;
  constructor(public authService : AuthService, private productService : ProductService,
    private route: ActivatedRoute) { 

  }

  ngOnInit(): void {
    this.route.paramMap
    .subscribe(params => {
      this.getProduct(params.get('id'));
    })
  
  }

  private getProduct(id : string) {
    this.productService.getProduct(id)
    .subscribe ((response : any)  => {
      this.product = response;
      this.seriesInformation =  this.product.information.split("|");
      this.documents = this.product.documentation.split("|");
      this.notFound = false;
      this.fanImage = this.product.fanImage;
      this.model = this.product.model;
      this.manufName = this.product.manufacturer.manufName;
      this.series = this.product.series;
      this.firmSpec = this.product.firmSpec;
      this.globalSpec = this.product.globalSpec;
      this.useType = this.product.useType
      this.application =this.product.application
      this.mountingLocation = this.product.mountingLocation
      this.accessories = this.product.accessories
      this.modelYear = this.product.modelYear
      this.airflow = this.product.airflow
      this.powerMin = this.product.powerMin
      this.powerMax = this.product.powerMax
      this.voltageMin = this.product.voltageMin
      this.voltageMax = this.product.voltageMax
      this.fanSpeedMin = this.product.fanSpeedMin
      this.fanSpeedMax = this.product.fanSpeedMax
      this.numberFanSpeed = this.product.numberFanSpeed
      this.soundMaxSpeed = this.product.soundMaxSpeed
      this.fanDiameter = this.product.fanDiameter
      this.heightMin =  this.product.heightMin
      this.heightMax =this.product.heightMax
      this.weight = this.product.weight
      this.repName = this.product.manufacturer.representative.repName
      this.repPhone = this.product.manufacturer.representative.repPhone
      this.repEmail = this.product.manufacturer.representative.repEmail
      this.repWeb = this.product.manufacturer.representative.repWeb
      this.manufDep = this.product.manufacturer.manufDep
      this.manufPhone = this.product.manufacturer.manufPhone
      this.manufEmail = this.product.manufacturer.manufEmail
      this.manufWeb = this.product.manufacturer.manufWeb
    }, (error : Response) => {
      if(error.status === 404){
        this.notFound = true;
      }
      else alert('An unexpected error occured')
    }
  )}

}

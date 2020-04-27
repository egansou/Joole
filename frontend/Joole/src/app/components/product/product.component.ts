import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() fanId : number;
  @Input() fanImage : string;
  @Input() verifiedDate : string;
  @Input() manufName : string;
  @Input() series : string;
  @Input() model : string;
  @Input() airflow : number;
  @Input() powerMax : number;
  @Input() soundMaxSpeed : number;
  @Input() fanDiameter : number;
  @Input() firmSpec : number;
  @Input() globalSpec : number;

  @Output() select = new EventEmitter();

  date : string;

  isSelected: boolean;

  constructor() { }

  ngOnInit(): void {
    this.date = this.verifiedDate.split("-").reverse().join("/")
    this.isSelected = false;
  }

  onSelect(){
    this.isSelected = !this.isSelected; 
    let info = {isSelected : this.isSelected, id: this.fanId};
    this.select.emit(info);
  }

}

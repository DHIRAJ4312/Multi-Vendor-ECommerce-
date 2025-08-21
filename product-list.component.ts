import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html'
})
export class ProductListComponent implements OnInit {
  page: any;
  ngOnInit(){ this.load(); }
  constructor(private ps: ProductService) {}
  load(){ this.ps.list().subscribe(res => this.page = res); }
}

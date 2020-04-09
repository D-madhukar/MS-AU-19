import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/shared/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: any = [];
  keys: any = [];
  constructor(private productService: ProductService) {

  }
  ngOnInit() {
    this.productService.getProductDetails().subscribe(data => {
      this.products = data;
      const product: any = data[0];
      for (const key in product) {
        if (key != null) {
          this.keys.push(key);
        }
      }
    });
  }

}

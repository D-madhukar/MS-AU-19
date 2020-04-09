import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/shared/product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
product: any = {};
keys: any = [];
selectedId = '';
constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params =>{
      this.selectedId = params.get('id');
      this.productService.getProduct(this.selectedId).subscribe(data => {
        this.product = data;
        for (const key in this.product) {
          if (key != null) {
            this.keys.push(key);
          }
        }
      });
    });
  }
}

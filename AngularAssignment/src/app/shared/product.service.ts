import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  PRODUCT_LIST = 'http://localhost:8080/AccoliteCRUDRestService/student';
  // PRODUCT_LIST ="'https://jsonplaceholder.typicode.com/todos";
  constructor(private http: HttpClient) {

  }
  getProductDetails() {
    return this.http.get(this.PRODUCT_LIST);
  }
  getProduct(id: string) {
    return this.http.get(this.PRODUCT_LIST + '/' + id);
  }
}

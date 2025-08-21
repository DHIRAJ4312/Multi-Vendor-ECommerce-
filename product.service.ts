import { Injectable } from '@angular/core';
import { ApiService } from '../../core/api.service';
@Injectable({ providedIn: 'root' })
export class ProductService {
  constructor(private api: ApiService) {}
  list(category?: string, page: number = 0, size: number = 12) {
    const params: any = { page, size }; if (category) params.category = category;
    return this.api.get('/products', params);
  }
  create(body: any){ return this.api.post('/products', body); }
}

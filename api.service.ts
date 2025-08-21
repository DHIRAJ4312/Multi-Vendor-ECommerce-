import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
@Injectable({ providedIn: 'root' })
export class ApiService {
  base = environment.api;
  constructor(private http: HttpClient) {}
  get<T>(url: string, params: any = {}) { return this.http.get<T>(`${this.base}${url}`, { params }); }
  post<T>(url: string, body: any) { return this.http.post<T>(`${this.base}${url}`, body); }
}

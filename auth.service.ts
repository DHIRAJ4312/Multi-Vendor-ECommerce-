import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
@Injectable({ providedIn: 'root' })
export class AuthService {
  tokenKey = 'mv_token';
  constructor(private api: ApiService) {}
  login(email: string, password: string) { return this.api.post('/auth/login', { email, password }); }
  register(payload: any) { return this.api.post('/auth/register', payload); }
  setToken(t: any){ localStorage.setItem(this.tokenKey, t.token); }
  get token(){ return localStorage.getItem(this.tokenKey); }
  logout(){ localStorage.removeItem(this.tokenKey); }
}

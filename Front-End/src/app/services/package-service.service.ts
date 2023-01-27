import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const API_URL = 'http://localhost:8304/packages/getpackages';
@Injectable({
  providedIn: 'root'
})
export class PackageServiceService {
  
  constructor(private http:HttpClient) {
  
   }
   getAllPackages() {
    return this.http.get(API_URL);
  }
}

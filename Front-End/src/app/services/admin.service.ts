import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';


const API_URL = 'http://localhost:8305/profile/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})

export class AdminService {

  constructor(private http:HttpClient) { }

  addProfile(pro) {
    return this.http.post(API_URL+'addProfile',pro);
  }

  getProfile(username){
    let param = new HttpParams().set('username',username)
    return this.http.get(API_URL+`getProfile/${username}`, {params: param})
  }
}

import { Injectable } from '@angular/core';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';
const packagename='not defined';
const packagedesc='not defined desc';
const packageimage='not defined image';
const price='0';
const orderId='new';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  constructor() { }

  signOut(): void {
    window.sessionStorage.clear();
  }

  public savePackageName(name):void{
    window.sessionStorage.removeItem(packagename);
    window.sessionStorage.setItem(packagename,name);
  }
  public savePackageDesc(desc):void{
    window.sessionStorage.removeItem(packagedesc);
    window.sessionStorage.setItem(packagedesc,desc);
  }
  public savePackagePrice(amount):void{
    window.sessionStorage.removeItem(price);
    window.sessionStorage.setItem(price,amount);
  }
  public saveOrderId(id):void{
    window.sessionStorage.removeItem(orderId);
    window.sessionStorage.setItem(orderId,id);
  }
  public savePackageImage(image):void{
    window.sessionStorage.removeItem(packageimage);
    window.sessionStorage.setItem(packageimage,image);
  }
  public getPackageName(){
    return window.sessionStorage.getItem(packagename);
  }
  public getPackageDesc(){
    return window.sessionStorage.getItem(packagedesc);
  }
  public getPackagePrice(){
    return parseInt(window.sessionStorage.getItem(price));
  }
  public getPackageImage(){
    return window.sessionStorage.getItem(packageimage);
  }
  public getOrderId(){
    return window.sessionStorage.getItem(orderId);
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }

    return {};
  }
}
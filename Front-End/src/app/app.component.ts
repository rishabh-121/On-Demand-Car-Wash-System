import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './services/auth.service';
import { TokenStorageService } from './services/token-storage.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'on-demand-car-wash-system';
  private role: string[] = [];
  isLoggedIn = false;
  showUserBoard=false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;
  registerWasherform: any = {
    username: null,
    email: null,
    password: null,
    roles:["mod"]
  };

  
  constructor(private router: Router, private tokenStorageService: TokenStorageService, private authService:AuthService) {}

  gotologin() {
    this.router.navigate(['/login']); // define your component where you want to go
  }
  gotoHome() {
    this.router.navigate(['/home']); // define your component where you want to go
  }
  gotoAbout() {
    this.router.navigate(['/aboutus']);
  }
  gotoContact() {
    this.router.navigate(['/contact']);
  }
  gotoBooking() {
    this.router.navigate(['/booking']);
  }
  gotoAdmin(){
    this.router.navigate(['/admin']);
  }
  gotoMod(){
    this.router.navigate(['/mod']);
  }
  gotoUser(){
    this.router.navigate(['/user']);
  }
  gotoProfile(){
    this.router.navigate(['/profile']);
  }
  gotoOrder(){
    this.router.navigate(['/order']);
  }

//load automatically when component load
  ngOnInit():void{
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.role = user.roles;
      this.showUserBoard=this.role.includes('ROLE_USER');
      this.showAdminBoard = this.role.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.role.includes('ROLE_MODERATOR');

      this.username = user.username;
    }
  }
  logout(): void {
    this.tokenStorageService.signOut();
    //this.router.navigate(['/login']);
    window.location.reload();
  }

  registerWasherOnSubmit(){
    const { username, email, password, roles } = this.registerWasherform;
    this.authService.registerWasher(username, email, password, roles).subscribe(
      data => {
        console.log(data);
        
      },
     
    );
  }

}

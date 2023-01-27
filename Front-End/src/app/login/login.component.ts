import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginform: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  loginerrorMessage = '';
  roles: string[] = [];

  registerform: any = {
    username: null,
    email: null,
    password: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  registererrorMessage = '';


repeat=null;
 ispswdsame=false;

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  loginonSubmit(): void {
    const { username, password } = this.loginform;
    

    this.authService.login(username, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.reloadPage();
        //this.app.gotoHome();
       // this.router.navigate(['/home']);
       
      },
      err => {
        this.loginerrorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  registeronSubmit(): void {
    if(this.registerform.password==this.repeat)
    {
    const { username, email, password } = this.registerform;
   
      this.ispswdsame=true;
    

    this.authService.register(username, email, password).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.registererrorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
    }
    else{
      this.ispswdsame=true;
      
      console.log("password is not same");
    }
  }

  reloadPage(): void {
    window.location.reload();
  }
}
/**import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { AuthService } from './auth.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  
  token: any;
  new:any;
  authRequest:any={
    userName:'',
    password:'',
  };

  signup: any={
    userName:'',
    password:'',
    email:''
 };

  response: any;

  constructor(private service: AuthService, private router: Router, private app:AppComponent) {}

  ngOnInit(): void {}

  public getAccessToken() {
    if((this.authRequest.userName!='' && this.authRequest.password!=''))
    {
    let resp = this.service.generateToken(this.authRequest);
    resp.subscribe((data) => {
      this.token = data;
      this.service.loginUser(this.token);
      this.router.navigate(['/home']);
      this.app.loggedIn=this.service.isLoggedIn();
      
    });
  }
  else{
    console.log("Bad credentials");
  }
  }

  public newUser(){
    if((this.authRequest.userName!='' && this.authRequest.password!=''))
    {
    let res = this.service.signUp(this.signup);
    res.subscribe((data) => {
      console.log(data);
      this.router.navigate(['/login']); 
    });
  }
  else{
    console.log("Bad credentials");
  }
  }


  public accessBookingApi(token) {
    let resp = this.service.welcome(token);
    resp.subscribe((data) => {
      this.response = data;
      this.router.navigate(['/booking']);
    });
  }
}
**/


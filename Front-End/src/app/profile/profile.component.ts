import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  profile:any={
    username:'',
    firstName:'',
    lastName:'',
    email:'',
    phone:'',
    street:'',
    city:'',
    state:'',
    zip:''
  }
  email:'';

  constructor(private token: TokenStorageService, private admin:AdminService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.profile.username=this.currentUser.username;
    this.email=this.currentUser.email;
    this.profile.email=this.email;
    this.admin.getProfile(this.profile.username).subscribe((data)=>{
      console.log(data);
      this.profile=data;
    })
  }

  addUserProfile(){
    let res=this.admin.addProfile(this.profile);
    res.subscribe((data)=>{
      console.log(data);
      window.location.reload();
      
    })
  }

}
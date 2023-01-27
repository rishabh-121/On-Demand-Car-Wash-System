import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PackageServiceService } from '../services/package-service.service';
import { TokenStorageService } from '../services/token-storage.service';
import { UserService } from '../services/user.service';


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css'],
})
export class BookingComponent implements OnInit {
  constructor(private router: Router,private userService: UserService, private packageService:PackageServiceService,private tokenService:TokenStorageService) {}
  content?: string;
  package:any;

  ngOnInit(): void {
     this.packageService.getAllPackages().subscribe(data=>{
       this.package=data;
     }
      )

  }

  gotoBookNow(pack) {
    this.userService.getUserBoard().subscribe(
      data => {
        this.router.navigate(['/book-now']);
        this.tokenService.savePackageName(pack.packageName);
        this.tokenService.savePackageDesc(pack.packageDesc);
        this.tokenService.savePackagePrice(pack.price);
        this.tokenService.savePackageImage(pack.image);
        //console.log(pack.price);
        //console.log(this.tokenService.getPackagePrice());
        console.log(this.tokenService.getPackageName());
        //this.content = data;
      },
      err => {
        //this.content = JSON.parse(err.error).message;
        this.router.navigate(['/login']);
      }
    );
    
  }
}

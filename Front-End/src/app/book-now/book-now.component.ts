import { Component, NgZone, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookNowService } from '../services/book-now.service';
import { UserService } from '../services/user.service';
import { TokenStorageService } from '../services/token-storage.service';
import { HttpClient,HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-book-now',
  templateUrl: './book-now.component.html',
  styleUrls: ['./book-now.component.css']
})
export class BookNowComponent implements OnInit {



  selectedFile:File;
  title:any='NewImage';

  customerDet:any={
    username:'',
    firstName:'',
    lastName:'',
    email:'',
    contactNo:null,
    address1:'',
    address2:'',
    city:'',
    state:'',
    zip:'',
    carNo:'',
    date:Date,
    packageName:'',
    packageDesc:'',
    packageImage:'',
    washerName:'Pending',
    status:'Pending',
    isCancelled:false,

    price:null

  }
  paymentForm:any={
    cardNumber:null,
    expMonth:null,
    expYear:null,
    cvv:null,
  }
 
  content?: string;
  amount:any;
  constructor(private service:BookNowService, private router:Router, private userService: UserService,private token: TokenStorageService,private http:HttpClient,private zone:NgZone)
  {

  }
  
  ngOnInit(): void {
    this.customerDet.username=this.token.getUser().username;
    window.scrollTo(0, 0);
  }

  onSelectedFile(event)
  {
    this.selectedFile = event.target.files[0];
  }

  proceed()
  {
    console.log(this.customerDet.date)
    this.customerDet.packageName=this.token.getPackageName();
    this.customerDet.packageDesc=this.token.getPackageDesc();
    this.customerDet.price=this.token.getPackagePrice();
    this.customerDet.packageImage=this.token.getPackageImage();
    this.customerDet.isWasherCancelled=[''];
    const uploadImageData = new FormData();

    uploadImageData.append('username',this.customerDet.username);
    uploadImageData.append('first',this.customerDet.firstName);
    uploadImageData.append('last',this.customerDet.lastName);
    uploadImageData.append('em',this.customerDet.email);
    uploadImageData.append('cn',this.customerDet.contactNo);
    uploadImageData.append('ad1',this.customerDet.address1);
    uploadImageData.append('ad2',this.customerDet.address2);
    uploadImageData.append('city',this.customerDet.city);
    uploadImageData.append('state',this.customerDet.state);
    uploadImageData.append('zip',this.customerDet.zip);
    uploadImageData.append('caN',this.customerDet.carNo);
    uploadImageData.append('date',this.customerDet.date);
    uploadImageData.append('pn',this.customerDet.packageName);
    uploadImageData.append('pd',this.customerDet.packageDesc);
    uploadImageData.append('pc',this.customerDet.price);
    uploadImageData.append('iu',this.customerDet.packageImage);
    uploadImageData.append('wn',this.customerDet.washerName);
    uploadImageData.append('status',this.customerDet.status);
    uploadImageData.append('isc',this.customerDet.isCancelled);
    uploadImageData.append('image', this.selectedFile, this.selectedFile.name);
    let res=this.service.addBookNowData(uploadImageData);
    res.subscribe((data) => {
      console.log(data);
      this.zone.run(()=>this.router.navigate(['/order']));
    });
 }

 updatePrice(){
   this.amount=this.token.getPackagePrice();

 }
 

 chargeCreditCard() {
  
  (<any>window).Stripe.card.createToken({
    number: this.paymentForm.cardNumber,
    exp_month: this.paymentForm.expMonth,
    exp_year: this.paymentForm.expYear,
    cvc: this.paymentForm.cvv
  }, (status: number, response: any) => {
    if (status === 200) {
      let paymentToken = response.id;
     
      this.chargeCard(paymentToken);
    } else {
      console.log(response.error.message);
    }
  });
}


chargeCard(paymentToken: string) {
  
  let price=this.token.getPackagePrice();

  this.service.payment(paymentToken,price)
    .subscribe(resp => {
      
      console.log(resp);
      this.zone.run(()=> this.proceed());
     
    });
}

}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookNowService } from '../services/book-now.service';
import { TokenStorageService } from '../services/token-storage.service';
import { InvoiceComponent } from '../invoice/invoice.component';

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit {

  constructor(private http:HttpClient,private order:BookNowService,private tokenService:TokenStorageService,private router:Router) { }
userName:any;
orderDetails:any;
userDetails:any;
  ngOnInit(): void 
  {
this.userDetails=this.tokenService.getUser();
this.userName=this.userDetails.username;
this.order.getBookingDetails(this.userName).subscribe(data=>{
  this.orderDetails=data;
  window.scrollTo(0, 0);
}
 )
 }

 
 gotoinvoice(orderId) {
  console.log(orderId);
  this.tokenService.saveOrderId(orderId);
  this.tokenService.getOrderId();
   this.router.navigate(['/invoice']);
  
   // define your component where you want to go
}


//orderId inplace of washerId
 updateCancel(washerId,isCancelledReq){
   console.log(washerId);
   let res=this.order.updateCancellReq(washerId,isCancelledReq);
   res.subscribe((data) => {
    console.log(data); 
    window.location.reload();
  });
 }


}

import { Component, OnInit } from '@angular/core';
import { BookNowService } from '../services/book-now.service';
import { TokenStorageService } from '../services/token-storage.service';


@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {
  invoiceDetails:any;
  username?: string;
  id;
  okk:'why';
 
  constructor(private invoice:BookNowService,private tokenStorageService:TokenStorageService ) { }

  ngOnInit(): void {
    console.log(this.tokenStorageService.getOrderId());
    this.invoice.getInvoiceDetails(this.tokenStorageService.getOrderId()).subscribe(data=>{
      this.invoiceDetails=data;
      window.scrollTo(0, 0);
      console.log(data);
    })

  }

 



}

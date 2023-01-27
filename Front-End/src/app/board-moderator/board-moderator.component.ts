import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { SafeUrlPipe } from 'src/SafeUrlPipe.pipe';
import { BookNowService } from '../services/book-now.service';
import { TokenStorageService } from '../services/token-storage.service';
import { UserService } from '../services/user.service';


@Component({
  selector: 'app-board-admin',
  templateUrl: './board-moderator.component.html',
  styleUrls: ['./board-moderator.component.css']
})
export class BoardModeratorComponent implements OnInit {
  content?: string;
  isContent=false;
  allBooking;
currentUser;
userName;
status;
doneOrderId;
selectedFile:File;
title:any='NewImage';
  constructor(private userService: UserService,private safe:SafeUrlPipe,private domSanitizer:DomSanitizer, private booking:BookNowService,private token: TokenStorageService) { }

  onSelectedFile(event)
  {
    this.selectedFile = event.target.files[0];
  }

  ngOnInit(): void {
    this.userService.getModeratorBoard().subscribe(
      data => {
        this.currentUser = this.token.getUser();
        this.userName=this.currentUser.username;
        console.log(this.userName);
        window.scrollTo(0, 0);
        //Calling all booking details under authorize board
        this.booking.getAllBookingDetails().subscribe(
          data=>{
            this.allBooking=data;
          }
        );
      },
      err => {
        this.content = JSON.parse(err.error).message;
        this.isContent=true;
      }
    );
  }


  acceptBookingByWasher(orderId,userName){
    console.log(orderId);
    let res=this.booking.acceptBooking(orderId,userName);
    res.subscribe((data) => {
     console.log(data);
     window.location.reload(); 
   });
  }


  cancelBookingByWasher(orderId,userName){
    console.log(orderId);
    let res=this.booking.washerCancelBooking(orderId,userName);
    res.subscribe((data) => {
     console.log(data); 
     window.location.reload();
   });
  }

  done(realId){
    this.doneOrderId=realId;
  }


  doneBookingByWasher(orderId){
    console.log(orderId);
    this.status='done';
    const uploadImageData = new FormData();
    uploadImageData.append('id',orderId);
    uploadImageData.append('status',this.status);
    uploadImageData.append('image', this.selectedFile, this.selectedFile.name);
    let res=this.booking.doneBooking(uploadImageData);
    res.subscribe((data) => {
      console.log(data);
      window.location.reload();
      
    });

  }


  //To fetch image from db but of no use.
  dataURItoBlob(dataURI) {
    console.log(dataURI);
    var binary = atob(dataURI.split(',')[1]);
    var array = [];
    
  for (var i = 0; i < binary.length; i++) {
     array.push(binary.charCodeAt(i));
  }
 return new Blob([new Uint8Array(array)], {
    type: 'image/jpg'
});
}
user_photo: SafeResourceUrl;
photo_url(data: string){
     this.user_photo = this.domSanitizer.bypassSecurityTrustResourceUrl(
       data);
       return this.user_photo;
}




}
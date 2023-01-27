import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { BookNowService } from '../services/book-now.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  content?: string;
  usersDetail;
  allBooking;
  constructor(private userService: UserService, private userDetails:AdminService, private booking:BookNowService) { }

  ngOnInit(): void {
    this.userService.getAdminBoard().subscribe(
      data => {
        this.content = data;
        this.booking.getAllBookingDetails().subscribe(
          data=>{
            this.allBooking=data;
          }
        );
        
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }
}


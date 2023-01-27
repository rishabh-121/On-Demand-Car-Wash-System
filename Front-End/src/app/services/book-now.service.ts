import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookNowService {

  constructor(private httpClient:HttpClient) { }
  // headers = new HttpHeaders();

  // data:any;
  // headers = { header: new Headers({ 'Content-Type': 'application/json' }) 
  //     };
      // headers : new HttpHeaders({
      //   'Content-Type' : 'application/json'
      // })

// options = { headers: this.headers, withCredintials: false };
public getBookingDetails(userName){
  let params = new HttpParams()
    .set('username', userName)
  return this.httpClient.get('http://localhost:8303/getBookingDetails', {params: params});
}


public getAllBookingDetails(){
 
  return this.httpClient.get('http://localhost:8303/getAllBookingDetails');
}


public updateCancellReq(id,isCancelled){
  let param = new HttpParams().set('id',id)
  .set('isc', isCancelled)
  
return this.httpClient.put(`http://localhost:8303/updateCancellReq/${id}/${isCancelled}`, {params: param});
}


public acceptBooking(id,washerName){
  let param = new HttpParams().set('id',id)
  .set('washer', washerName)
  
return this.httpClient.put(`http://localhost:8303/acceptBooking/${id}/${washerName}`, {params: param});
}


public washerCancelBooking(id,washerName){
  let param = new HttpParams().set('id',id)
  .set('washer', washerName)
  
return this.httpClient.put(`http://localhost:8303/washerCancelBooking/${id}/${washerName}`, {params: param});
}

public getInvoiceDetails(id){
  let param = new HttpParams().set('id',id)

  return this.httpClient.get(`http://localhost:8303/getInvoiceDetails/${id}`, {params: param});
}

public doneBooking(done){
  return this.httpClient.put('http://localhost:8303/doneBooking',
  done);
}

public payment(token,price){
  let param = new HttpParams().set('token',token)
  .set('price',price)
  return this.httpClient.post(`http://localhost:8306/payment/charge/${token}/${price}`, {params: param})
}


  public addBookNowData(image)
  {
    return this.httpClient.post<any>('http://localhost:8303/photos',
    image,
    { responseType: 'text' as 'json' }
    );
  }
}

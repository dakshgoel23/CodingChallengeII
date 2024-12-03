import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookFlightService {

  constructor(private httpClient:HttpClient) { }

  getAllFlightsApi='http://localhost:8081/api/flight/all'
  enterUserApi='http://localhost:8081/api/user/add'
  bookFlightApi='http://localhost:8081/api/book/flight'

  getAllFlights():Observable<any>
  {
   return  this.httpClient.get(this.getAllFlightsApi)
  }

  enterUser(obj:any):Observable<any>{
    return this.httpClient.post(this.enterUserApi,obj)
  }

  bookFlightForUser(flight_id:number,user_id:number,obj:any):Observable<any>
  {
    return this.httpClient.post(this.bookFlightApi+"?flight_id="+flight_id+"&user_id="+user_id,obj)
  }
}

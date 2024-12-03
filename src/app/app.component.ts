import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BookFlightService } from './service/book-flight.service';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [NgFor,NgIf,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  constructor(private bookFlight:BookFlightService){}

  allflight:any
  flight:any
  selectedFlight:any

  name:any
  contact:any
  no_of_passangers:any
  date_of_journey:any

  flight_id:number=0
  user_id:number=0

  ngOnInit(): void {
    this.bookFlight.getAllFlights().subscribe({
      next:(data)=>{
        this.allflight=data
      },
      error:()=>{}
    })
    
  }

  openForm(flight:any){
    this.selectedFlight=flight
    console.log(this.selectedFlight)
  }


  completeBooking(){
    this.flight_id=this.selectedFlight.id

    this.bookFlight.enterUser({
      name:this.name,
      contact:this.contact
    }).subscribe({
      next:(data)=>{
        this.user_id=data.id

        this.bookFlight.bookFlightForUser(
          this.flight_id,this.user_id,
          {
            date_of_journey:this.date_of_journey,
            no_of_passangers:this.no_of_passangers
          }
        ).subscribe({
          next:(data)=>{
            alert("Booked Flight Successfully")
          },
          error:(err)=>{
            alert("Error occurs"+err)
          }
        })
      },
      error:()=>{}
    })
  }


}

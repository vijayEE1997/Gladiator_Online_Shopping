import { Component, OnInit } from '@angular/core';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private sessionService:SessionService) { }

  ngOnInit(): void {
    this.sessionService.checkSession()
  }

}

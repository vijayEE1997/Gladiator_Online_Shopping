import { Component, OnInit } from '@angular/core';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';

@Component({
  selector: 'side-header',
  templateUrl: './side-header.component.html',
  styleUrls: ['./side-header.component.css']
})
export class SideHeaderComponent implements OnInit {

  constructor(private EncrDecr: EncrDecrService) { }

  ngOnInit(): void {
    
  }

}

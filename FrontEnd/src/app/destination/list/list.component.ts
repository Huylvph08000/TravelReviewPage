import { Component, OnInit } from '@angular/core';
import {Destination} from '../../interface/destination';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  destinationList: Destination[] = [];

  ngOnInit(): void {
  }

}

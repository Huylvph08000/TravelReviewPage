import {Component, OnInit} from '@angular/core';
import {Destination} from '../../interface/destination';
import {DestinationService} from '../../_services/des.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  desList: Destination[] = [];
  failMessage: string | undefined;
  keyword: any;

  constructor(private desService: DestinationService) {
  }

  ngOnInit(): void {
    this.desService.showDesList()
      .subscribe(result => {
        this.desList = result;
      }, error => {
        this.failMessage = 'SHOW CAR LIST  FAIL !';
      });
  }

}

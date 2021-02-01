import {Component, OnInit} from '@angular/core';
import {Destination} from '../../interface/destination';
import {DestinationService} from '../../_services/des.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  desList: Destination[] = [];
  failMessage!: string ;
  keyword: any;

  constructor(private router: Router, public desService: DestinationService) {
  }

  // tslint:disable-next-line:typedef
  desDetails(id: number){
    this.router.navigate(['destination/review', id]);
  }

  ngOnInit(): void {
    this.desService.showDesList()
      .subscribe(result => {
        this.desList = result;
      }, error => {
        this.failMessage = 'SHOW DES LIST FAIL !';
      });
  }
}

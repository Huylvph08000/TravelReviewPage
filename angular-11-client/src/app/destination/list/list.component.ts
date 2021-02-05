import {Component, OnInit} from '@angular/core';
import {Destination} from '../../interface/destination';
import {DestinationService} from '../../_services/des.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  desList: Destination[] = [];
  failMessage!: string ;
  keyword: any;
  imageName: any;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;

  constructor(private router: Router, public desService: DestinationService, private httpClient: HttpClient) {
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
  getImage() {
    this.httpClient.get('http://localhost:8080/image/get/' + this.imageName)
      .subscribe(res => {
      this.retrieveResonse = res;
      this.base64Data = this.retrieveResonse.picByte;
      this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
    }
  );
  }
}

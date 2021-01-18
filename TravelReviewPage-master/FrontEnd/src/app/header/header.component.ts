import {Component, HostListener, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  showMe = ' ';
  close = ' ';
  constructor() {
  }

  ngOnInit(): void {
  }
@HostListener('document:click', ['$event'])
openSearch(): void {
    this.showMe = document.getElementById('header-search').style.width = '100%';

  }
}

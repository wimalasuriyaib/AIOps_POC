import { Component, OnInit, OnDestroy } from '@angular/core';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {
  isCollapsed = true;
  constructor() { }

  ngOnInit() {
    var body = document.getElementsByTagName('body')[0];
    body.classList.add('landing-page');

    var canvas: any = document.getElementById('chartBig');
    // var ctx = canvas.getContext('2d');
    // var gradientFill = ctx.createLinearGradient(0, 350, 0, 50);
    // gradientFill.addColorStop(0, 'rgba(228, 76, 196, 0.0)');
    // gradientFill.addColorStop(1, 'rgba(228, 76, 196, 0.14)');
  
  }
  ngOnDestroy() {
    var body = document.getElementsByTagName('body')[0];
    body.classList.remove('landing-page');
  }
}

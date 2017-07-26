import { Component, Input } from '@angular/core';
import { Http ,RequestOptions, Response, Headers } from '@angular/http';
import { LoginService } from '../../../pages/login/login.service';
import { GlobalState } from '../../../global.state';

@Component({
  selector: 'ba-page-top',
  templateUrl: './baPageTop.html',
  styleUrls: ['./baPageTop.scss'],
  providers: [LoginService]
})
export class BaPageTop {
  
 // @Input() hero: Hero;
  companyid: string;
  username: string;
  
  public isScrolled:boolean = false;
  public isMenuCollapsed:boolean = false;
 
  constructor(private _state:GlobalState,private login: LoginService,private http: Http) {
   
      this._state.subscribe('menu.isCollapsed', (isCollapsed) => {
      this.isMenuCollapsed = isCollapsed;
      });
      this.login.userData().subscribe(
          data => {
             this.username = data['username'];
              this.companyid = data['companyid'];
            if(data != null){
            }
          },
          error => {
          });

      }

  public toggleMenu() {
    this.isMenuCollapsed = !this.isMenuCollapsed;
    this._state.notifyDataChanged('menu.isCollapsed', this.isMenuCollapsed);
    return false;
  }

  public scrolledChanged(isScrolled) {
    this.isScrolled = isScrolled;

  }
}

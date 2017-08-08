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
  //signOutElement= document.getElementById('signOut').addEventListener('click',()=>this.signOut());
 
  constructor(private _state:GlobalState,private login: LoginService,private http: Http) {
   
      this._state.subscribe('menu.isCollapsed', (isCollapsed) => {
      this.isMenuCollapsed = isCollapsed;
      
      });
     
     this.username = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))['username'];
       this.companyid = JSON.parse(sessionStorage.getItem("http://localhost:8080/ecr/user/login"))['companyName'];
    
      }

  public toggleMenu() {
    this.isMenuCollapsed = !this.isMenuCollapsed;
    this._state.notifyDataChanged('menu.isCollapsed', this.isMenuCollapsed);
    return false;
  }

  public scrolledChanged(isScrolled) {
    this.isScrolled = isScrolled;
    
  }

  signOut(){
    console.log("session " + sessionStorage.getItem("http://localhost:8080/ecr/user/login"));
    sessionStorage.removeItem("http://localhost:8080/ecr/user/login");
    console.log("session " + sessionStorage.getItem("http://localhost:8080/ecr/user/login"));
    sessionStorage.removeItem("add2Cart");
  }

  
}

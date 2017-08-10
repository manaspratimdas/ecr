import { Component, OnInit } from '@angular/core';
import { FormGroup, AbstractControl,FormControl, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute,Router } from '@angular/router';
import { LoginService } from './login.service';
import { Http ,RequestOptions, Response, Headers } from '@angular/http';

@Component({
  selector: 'login',
  templateUrl: './login.html',
  styleUrls: ['./login.scss']
})
export class Login implements OnInit{

  form:FormGroup;
  title: String = '';
  isSubmitting: boolean = false;
  //router: ActivatedRoute;
  errormsg:boolean = false;
  authType: String = '';
  username: String = '';
  companyId : String = null;
  
constructor(private fb:FormBuilder ,private router: Router ,private service: LoginService,private http: Http) { 
   
   this.form = this.fb.group({
      'email': ['', Validators.compose([Validators.required, Validators.minLength(4)])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(4)])]
    });
}
    ngOnInit() {
   this.title = "Login";
  }
  onSubmit(){
      this.isSubmitting = true;

    let credentials = this.form.value;
    
    this.service.test(credentials).subscribe(
          data => {
            if(data != null){
              this.username = data['username'];
              this.companyId = data['companyId'];
              if(this.companyId!=null){
                
                window.location.href = "http://10.4.3.182:4200/#/pages/dashboard";

              }else{
                window.location.href = "/login.html";

              }
              
            }
          },
          error => {
          });

  }
}

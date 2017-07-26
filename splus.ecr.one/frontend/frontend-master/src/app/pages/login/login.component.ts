import { Component, OnInit } from '@angular/core';
import { FormGroup, AbstractControl,FormControl, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
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
  router: ActivatedRoute;
  authType: String = '';
  
constructor(private fb:FormBuilder ,private route: ActivatedRoute ,private service: LoginService,private http: Http) { 
   
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
    window.alert("username : " + credentials['email']);
    
    this.service.test(credentials).subscribe(
          data => {
            if(data != null){
            }
          },
          error => {
          });

  }
}

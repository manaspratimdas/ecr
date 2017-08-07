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
    if((credentials['email'] != "") && (credentials['password'] != "")){
      console.log("in if looooooooooooooop");
    this.service.test(credentials).subscribe(
          data => {
            console.log("dbusername : "+data['username']);
            console.log("dbpassword : "+data['password']);
        
            console.log("username : "+credentials['email']);
            console.log("password : "+credentials['password']);
        
            if((data['username'] != credentials['email']) || ((data['password'] != credentials['password']))){
              
              console.log("session " + sessionStorage.getItem("http://localhost:8080/ecr/user/login"));
                sessionStorage.removeItem("http://localhost:8080/ecr/user/login");
                console.log("session " + sessionStorage.getItem("http://localhost:8080/ecr/user/login"));
            }else{
              this.username = data['username'];
              this.companyId = data['companyId'];
              if(this.companyId!=null){
                
                window.location.href = "http://localhost:4200/#/pages/dashboard";

              }else{
                window.location.href = "/login.html";
                window.location.href = "http://localhost:4200";
              }
            }
          },
          error => {
          });
    }else if((credentials['email'] != "")&&(credentials['password'] == "") || (credentials['email'] == "")&&(credentials['password'] != "")){
               console.log("in else looooooooooooooop");
               window.alert("Please check username & password");
               window.location.href = "http://localhost:4200";
            
    }else{
               console.log("in else looooooooooooooop");
               window.alert("Please enter username & password");
               window.location.href = "http://localhost:4200";
    }
  }
}

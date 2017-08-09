import {Injectable} from '@angular/core'
import {Observable} from 'rxjs/Observable';

@Injectable()
export class BaMsgCenterService {

  private _notifications = [
    {
      name: 'Vlad',
      text: 'Vlad posted a new article.',
      time: '1 min ago'
    },
    {
      name: 'Kostya',
      text: 'Kostya changed his contact information.',
      time: '2 hrs ago'
    },
    {
      image: 'assets/img/shopping-cart.svg',
      text: 'New orders received.',
      time: '5 hrs ago'
    },
    {
      name: 'Andrey',
      text: 'Andrey replied to your comment.',
      time: '1 day ago'
    },
    {
      name: 'Nasta',
      text: 'Today is Nasta\'s birthday.',
      time: '2 days ago'
    },
    {
      image: 'assets/img/comments.svg',
      text: 'New comments on your post.',
      time: '3 days ago'
    },
    {
      name: 'Kostya',
      text: 'Kostya invited you to join the event.',
      time: '1 week ago'
    }
  ];

  private _messages =  this.getProducts();

  public getMessages():Observable<any> {
    return this._messages;
  }

  public getNotifications():Array<Object> {
    return this._notifications;
  }

  getProducts() : Observable<any> {
     // ...using get request
let data = sessionStorage.getItem("add2Cart");
     let response  = new Observable<any>();
     if(data!= null){
        response = JSON.parse(data);
     }else{
        response = JSON.parse("[]");
     }
    
    
    return response;
 }
}

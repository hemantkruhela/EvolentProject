import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Contact} from './contact';


@Injectable({
  providedIn: 'root'
})


export class ContactService {
  private baseUrl ="http://localhost:8081/api/contacts/";
  
  constructor(private http: HttpClient) { }
 
 
  getContact(id: number): Observable<any>{
    return  this.http.get(`${this.baseUrl}${id}`);
  }

  createContact(contact: object): Observable<Object>{
    return this.http.post(`${this.baseUrl}`,contact);
  }

  updateContact(contact: object): Observable<object>{
    console.log("update obect" +contact)
    return this.http.put(`${this.baseUrl}`,contact);
  }


  getContactList():Observable<any>{
     console.log("contacts list:"+this.baseUrl);
    return this.http.get(`${this.baseUrl}`);
  
  }

  deleteContact(id: number): Observable<any>{
    console.log('Delete URL:'+`${this.baseUrl}${id}`)
    return this.http.delete(`${this.baseUrl}${id}`);
  }

  activeContact(id: number): Observable<any>{
    console.log('URL:'+`${this.baseUrl}active/${id}`);
    return this.http.put(`${this.baseUrl}active/${id}`,{responseType: 'text'});
  }

  inActiveContact(id: number): Observable<any>{
    console.log('URL:'+`${this.baseUrl}inactive/${id}`);
    return this.http.put(`${this.baseUrl}inactive/${id}`,{responseType: 'text'});
  }
}

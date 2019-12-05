import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Contact} from './contact';
import { AuthenticationService } from './login/auth.service';



@Injectable({
  providedIn: 'root'
})


export class ContactService {
  private baseUrl ="http://localhost:8081/api/contacts/";
  
  constructor(private http: HttpClient, private authenticatedService: AuthenticationService) { }
 
 
  getContact(id: number): Observable<any>{
    return  this.http.get(`${this.baseUrl}${id}`,
    { headers: { Authorization: this.authenticatedService.getBasicAuthToken(),
      'Access-Control-Allow-Origin':'*' } });

      return this.http.get<Contact[]>(`${this.baseUrl}${id}`);
  }

  createContact(contact: object): Observable<Object>{
    return this.http.post(`${this.baseUrl}`,contact,
    { headers: { Authorization: this.authenticatedService.getBasicAuthToken(),
      'Access-Control-Allow-Origin':'*' } });
  }

  updateContact(contact: object): Observable<object>{
    console.log("update obect" +contact)
    return this.http.put(`${this.baseUrl}`,contact,
    { headers: { Authorization: this.authenticatedService.getBasicAuthToken(),
      'Access-Control-Allow-Origin':'*' } });
  }


  getContactList():Observable<any>{
     return this.http.get(`${this.baseUrl}`,
    { headers: { Authorization: this.authenticatedService.getBasicAuthToken(),
      'Access-Control-Allow-Origin':'*' } });
  
  }

  deleteContact(id: number): Observable<any>{
    console.log('Delete URL:'+`${this.baseUrl}${id}`)
    return this.http.delete(`${this.baseUrl}${id}`,
    { headers: { Authorization: this.authenticatedService.getBasicAuthToken(),
      'Access-Control-Allow-Origin':'*' } });
  }

  activeContact(id: number): Observable<any>{
    console.log('URL:'+`${this.baseUrl}active/${id}`);
    return this.http.put(`${this.baseUrl}active/${id}`,{responseType: 'text'},
    { headers: { Authorization: this.authenticatedService.getBasicAuthToken(),
      'Access-Control-Allow-Origin':'*' } });
  }

  inActiveContact(id: number): Observable<any>{
    console.log('URL:'+`${this.baseUrl}inactive/${id}`);
    return this.http.put(`${this.baseUrl}inactive/${id}`,{responseType: 'text'},
    { headers: { Authorization: this.authenticatedService.getBasicAuthToken(),
      'Access-Control-Allow-Origin':'*' } });
  }
}

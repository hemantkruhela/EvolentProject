import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ContactService } from "./../contact.service"
import { Contact } from "./../contact";
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {
  contacts : Observable<Contact[]>;
  constructor(private contactService: ContactService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.contacts= this.contactService.getContactList();
  }

  deleteContact(id: number) {
    this.contactService.deleteContact(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  activeContact(id: number){
    this.contactService.activeContact(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      }

    )
  }
  inActiveContact(id: number){
    this.contactService.inActiveContact(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      }

    )
  }

  contactDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateContact(id: number){
    console.log("udpate id"+id);
    this.router.navigate(['update', id]);
  }
}

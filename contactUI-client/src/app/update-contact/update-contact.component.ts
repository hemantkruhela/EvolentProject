import { Component, OnInit } from '@angular/core';
import { Contact } from '../contact';
import { ActivatedRoute, Router } from '@angular/router';
import { ContactService } from '../contact.service';
import { FormsModule } from '@angular/forms'


@Component({
  selector: 'app-update-contact',
  templateUrl: './update-contact.component.html',
  styleUrls: ['./update-contact.component.css']
})
export class UpdateContactComponent implements OnInit {

  id: number;
  contact: Contact;
  constructor(private route: ActivatedRoute,private router: Router,
    private contactService: ContactService) { }

    ngOnInit() {
      
      
      this.id = this.route.snapshot.params['id'];
      this.contactService.getContact(this.id)
        .subscribe(data => {
          console.log(data)
          this.contact = data;
          console.log("Fetched Object"+this.contact);
        }, error => console.log(error));
    }
  
    updateContact() {
      this.contactService.updateContact(this.contact)
        .subscribe(data => console.log(data), error => console.log(error));
      this.contact = new Contact();
      this.gotoList();
    }
  
    onSubmit() {
      this.updateContact();    
    }
  
    gotoList() {
      this.router.navigate(['/contacts']);
    }
}

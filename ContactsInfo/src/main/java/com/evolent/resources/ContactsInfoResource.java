package com.evolent.resources;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.beans.Contact;
import com.evolent.services.ContactService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", allowedHeaders = "*")
@RequestMapping("/contacts")
public class ContactsInfoResource {
	
	@Autowired
	ContactService contactService;
	
	@Autowired
	ResourceBundleMessageSource messageResource;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Contact>> findAll(Pageable pageable){
			List<Contact> contactList=contactService.findAll(pageable).getContent();
		return new ResponseEntity<List<Contact>>(contactList,HttpStatus.OK);
	}
	
	@GetMapping("/{contactId}")
	public EntityModel<Contact> findAll(@PathVariable int contactId) throws EntityNotFoundException{
		Optional<Contact> contact = contactService.findContactById(contactId);
		contact.get().getContactId();		
		  Link findOneLink = linkTo(methodOn(ContactsInfoResource.class).findAll(contactId)).withSelfRel();
		  Link findAll = linkTo(methodOn(ContactsInfoResource.class).findAll(null)).withRel("All- Contacts");
		  Link deleteLink = linkTo(methodOn(ContactsInfoResource.class).deleteContact(contactId)).withRel("Delete Contact");
		  Link updateLink = linkTo(methodOn(ContactsInfoResource.class).updateContact(contact.get(), null)).withRel("Update contact");
		  EntityModel< Contact> linkedContact = new EntityModel<Contact>(contact.get(), findOneLink,findAll,deleteLink,updateLink);
		
		  

			  
		return linkedContact;
	}
	@PostMapping("/")
	public EntityModel<Contact> saveContact(@Valid @RequestBody Contact contact){
		Contact persistedContact = contactService.createContact(contact);
		 Link findOneLink = linkTo(methodOn(ContactsInfoResource.class).findAll(persistedContact.getContactId())).withSelfRel();
		  Link findAll = linkTo(methodOn(ContactsInfoResource.class).findAll(null)).withRel("All- Contacts");
		  Link deleteLink = linkTo(methodOn(ContactsInfoResource.class).deleteContact(persistedContact.getContactId())).withRel("Delete Contact");
		  Link updateLink = linkTo(methodOn(ContactsInfoResource.class).updateContact(persistedContact, null)).withRel("Update contact");
		  EntityModel< Contact> linkedContact = new EntityModel<Contact>(persistedContact, findOneLink,findAll,deleteLink,updateLink);
		return linkedContact;
	}
	
	@PutMapping("/")
	public EntityModel<Contact> updateContact( @Valid @RequestBody Contact contact,BindingResult bindingResult){
		Contact persistedContact = contactService.updateContact(contact);
		 Link findOneLink = linkTo(methodOn(ContactsInfoResource.class).findAll(persistedContact.getContactId())).withSelfRel();
		  Link findAll = linkTo(methodOn(ContactsInfoResource.class).findAll(null)).withRel("All- Contacts");
		  Link deleteLink = linkTo(methodOn(ContactsInfoResource.class).deleteContact(persistedContact.getContactId())).withRel("Delete Contact");
		  Link updateLink = linkTo(methodOn(ContactsInfoResource.class).updateContact(persistedContact, null)).withRel("Update contact");
		  EntityModel< Contact> linkedContact = new EntityModel<Contact>(persistedContact, findOneLink,findAll,deleteLink,updateLink);
		return  linkedContact;
	}
	
	@DeleteMapping("/{contactId}")
	public EntityModel<Contact> deleteContact( @Valid @PathVariable int contactId){
		Optional<Contact> contact = contactService.findContactById(contactId);
		contactService.deleteContact(contact.get().getContactId());
		  Link findAll = linkTo(methodOn(ContactsInfoResource.class).findAll(null)).withRel("All- Contacts");
		  EntityModel< Contact> linkedContact = new EntityModel<Contact>(contact.get(), findAll);
			return  linkedContact;
	}
	
	@PutMapping("/inactive/{contactId}")
	public EntityModel<Contact> updateStatusInActiveContact(@PathVariable int contactId){
		Optional<Contact> contact = contactService.findContactById(contactId);
		contact.get().setStatus("INACTIVE");
		Contact persistedContact = contactService.updateContact(contact.get());
		 Link findOneLink = linkTo(methodOn(ContactsInfoResource.class).findAll(persistedContact.getContactId())).withSelfRel();
		  Link findAll = linkTo(methodOn(ContactsInfoResource.class).findAll(null)).withRel("All- Contacts");
		  Link deleteLink = linkTo(methodOn(ContactsInfoResource.class).deleteContact(persistedContact.getContactId())).withRel("Delete Contact");
		  EntityModel< Contact> linkedContact = new EntityModel<Contact>(persistedContact, findOneLink,findAll,deleteLink);
			return  linkedContact;
	}
	
	@PutMapping("/active/{contactId}")
	public EntityModel<Contact> updateStatusActiveContact(@PathVariable int contactId){
		Optional<Contact> contact = contactService.findContactById(contactId);
		contact.get().setStatus("ACTIVE");
		Contact persistedContact = contactService.updateContact(contact.get());
		 Link findOneLink = linkTo(methodOn(ContactsInfoResource.class).findAll(persistedContact.getContactId())).withSelfRel();
		  Link findAll = linkTo(methodOn(ContactsInfoResource.class).findAll(null)).withRel("All- Contacts");
		  Link deleteLink = linkTo(methodOn(ContactsInfoResource.class).deleteContact(persistedContact.getContactId())).withRel("Delete Contact");
		  Link updateLink = linkTo(methodOn(ContactsInfoResource.class).updateContact(persistedContact, null)).withRel("Update contact");
		  EntityModel< Contact> linkedContact = new EntityModel<Contact>(persistedContact, findOneLink,findAll,deleteLink,updateLink);
			return  linkedContact;
	}
	
	
	/*
	 * @ExceptionHandler(EntityNotFoundException.class) public
	 * ResponseEntity<EntityNotFoundException>
	 * EntityNotFoundExceptionHandler(Exception e){ return Exc
	 * 
	 * }
	 */
	  
	 

}

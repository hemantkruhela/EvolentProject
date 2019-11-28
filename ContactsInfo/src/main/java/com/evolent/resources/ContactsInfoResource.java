package com.evolent.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.servlet.LocaleResolver;

import com.evolent.beans.Contact;
import com.evolent.services.ContactService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
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
	public ResponseEntity<Contact> findAll(@PathVariable int contactId){
			Contact contact = contactService.findContactById(contactId);
		return new ResponseEntity<Contact>(contact,HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Contact> saveContact(@Valid @RequestBody Contact contact){
		Contact persistedContact = contactService.createContact(contact);
		return new ResponseEntity<Contact>(persistedContact,HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Contact> updateContact( @Valid @RequestBody Contact contact,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			//bindingResult.getAllErrors().get(0).getDefaultMessage();
			String errorMessage = messageResource.getMessage(bindingResult.getAllErrors().get(0).getDefaultMessage(),null,LocaleContextHolder.getLocale());
			throw new RuntimeException(errorMessage);
		}
		Contact persistedContact = contactService.updateContact(contact);
		return new ResponseEntity<Contact>(persistedContact,HttpStatus.OK);
	}
	
	@DeleteMapping("/{contactId}")
	public ResponseEntity<Contact> deleteContact( @Valid @PathVariable int contactId){
		Contact contact = contactService.findContactById(contactId);
		contactService.deleteContact(contact.getContactId());
		return new ResponseEntity<Contact>(contact,HttpStatus.OK);
	}
	
	@PutMapping("/inactive/{contactId}")
	public ResponseEntity<Contact> updateStatusInActiveContact(@PathVariable int contactId){
		Contact contact = contactService.findContactById(contactId);
		contact.setStatus("INACTIVE");
		Contact persistedContact = contactService.updateContact(contact);
		
		return new ResponseEntity<Contact>(persistedContact,HttpStatus.OK);
	}
	
	@PutMapping("/active/{contactId}")
	public ResponseEntity<Contact> updateStatusActiveContact(@PathVariable int contactId){
		Contact contact = contactService.findContactById(contactId);
		contact.setStatus("ACTIVE");
		Contact persistedContact = contactService.updateContact(contact);
		return new ResponseEntity<Contact>(persistedContact,HttpStatus.OK);
	}
	

}

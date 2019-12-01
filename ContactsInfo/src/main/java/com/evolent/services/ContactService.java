package com.evolent.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.evolent.beans.Contact;
import com.evolent.repositories.ContactRepository;


/**
 * @author VaibhavNimit
 *
 */
@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	
	/**
	 * @param contact
	 * @return
	 */
	public Contact createContact(Contact contact) {
		return contactRepository.saveAndFlush(contact);		
	}
	
	
	/**
	 * @return
	 */
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}
	
	/**
	 * @param pageable
	 * @return
	 */
	public Page<Contact> findAll(Pageable pageable){
		return contactRepository.findAll(pageable);
	}
	
	/**
	 * @param contact
	 * @return
	 */
	public Contact updateContact(Contact contact) {
		Contact contactDb= contactRepository.getOne(contact.getContactId());
		contactDb.setEmail(contact.getEmail());
		contactDb.setFirstName(contact.getFirstName());
		contactDb.setLastName(contact.getLastName());
		contactDb.setPhone(contact.getPhone());
		contactDb.setStatus(contact.getStatus());
		return contactRepository.saveAndFlush(contactDb);
	}
	
	/**
	 * @param contactId
	 */
	public void deleteContact(Integer contactId) {
		contactRepository.deleteById(contactId);
	}


	/**
	 * @param contactId
	 * @return
	 */
	public Optional<Contact> findContactById(int contactId) {
        return  contactRepository.findById(contactId);
	}
	
	
}


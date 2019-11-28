package com.evolent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evolent.beans.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>  {


}
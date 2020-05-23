package jcg.zheng.demo.vaadinwebdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcg.zheng.demo.vaadinwebdemo.dao.ContactRepository;
import jcg.zheng.demo.vaadinwebdemo.entity.Contact;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactDao;

	public List<Contact> getContacts() {
		return contactDao.findAll();
	}

	public Contact save(Contact contact) {
		contactDao.save(contact);
		return contact;
	}

	public void delete(Contact contact) {
		contactDao.delete(contact);
	}

}
